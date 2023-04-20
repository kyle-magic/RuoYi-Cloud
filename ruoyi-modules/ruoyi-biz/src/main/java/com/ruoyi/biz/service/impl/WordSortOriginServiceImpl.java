package com.ruoyi.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.biz.domain.Word;
import com.ruoyi.biz.domain.WordMean;
import com.ruoyi.biz.mapper.WordMapper;
import com.ruoyi.biz.mapper.WordMeanMapper;
import com.ruoyi.common.log.aspect.LogAspect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import java.util.Objects;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.biz.mapper.WordSortOriginMapper;
import com.ruoyi.biz.domain.WordSortOrigin;
import com.ruoyi.biz.service.IWordSortOriginService;

/**
 * 单词排行榜Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Service
public class WordSortOriginServiceImpl implements IWordSortOriginService
{
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private WordSortOriginMapper wordSortOriginMapper;

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private WordMeanMapper wordMeanMapper;

    /**
     * 查询单词排行榜
     * 
     * @param id 单词排行榜主键
     * @return 单词排行榜
     */
    @Override
    public WordSortOrigin selectWordSortOriginById(Long id)
    {
        return wordSortOriginMapper.selectWordSortOriginById(id);
    }

    /**
     * 查询单词排行榜列表
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 单词排行榜
     */
    @Override
    public List<WordSortOrigin> selectWordSortOriginList(WordSortOrigin wordSortOrigin)
    {
        return wordSortOriginMapper.selectWordSortOriginList(wordSortOrigin);
    }

    /**
     * 新增单词排行榜
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 结果
     */
    @Override
    public int insertWordSortOrigin(WordSortOrigin wordSortOrigin)
    {
        wordSortOrigin.setCreateTime(DateUtils.getNowDate());
        return wordSortOriginMapper.insertWordSortOrigin(wordSortOrigin);
    }

    /**
     * 修改单词排行榜
     * 
     * @param wordSortOrigin 单词排行榜
     * @return 结果
     */
    @Override
    public int updateWordSortOrigin(WordSortOrigin wordSortOrigin)
    {
        wordSortOrigin.setUpdateTime(DateUtils.getNowDate());
        return wordSortOriginMapper.updateWordSortOrigin(wordSortOrigin);
    }

    /**
     * 批量删除单词排行榜
     * 
     * @param ids 需要删除的单词排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordSortOriginByIds(Long[] ids)
    {
        return wordSortOriginMapper.deleteWordSortOriginByIds(ids);
    }

    /**
     * 删除单词排行榜信息
     * 
     * @param id 单词排行榜主键
     * @return 结果
     */
    @Override
    public int deleteWordSortOriginById(Long id)
    {
        return wordSortOriginMapper.deleteWordSortOriginById(id);
    }

    /**
     * 根据index开始爬取数据
     *
     * @param index
     * @return 结果
     */
    public int startCrawl(int index){
        //开启新线程爬取数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                //查询所有单词排行榜
                 List<WordSortOrigin> wordSortOriginList = wordSortOriginMapper.selectWordSortEmpty(new WordSortOrigin());
                //遍历爬取数据
                List<WordSortOrigin> writeBuffer = new ArrayList<>(30);

                System.out.println("---->>>start crawl word sort origin data");
                for (int i = index; i < wordSortOriginList.size(); i++) {
                    WordSortOrigin wordSortOrigin = wordSortOriginList.get(i);
                    if (wordSortOrigin.getSort() < index)
                        continue;
                    //爬取数据
                    wordSortOrigin.setWordInfo(crawlWordSortOrigin(wordSortOrigin.getWord()));
                    writeBuffer.add(wordSortOrigin);

                    if (writeBuffer.size()==30) {
                        //批量更新
                        System.out.println("---->>>update word sort origin data");
                        wordSortOriginMapper.updateWordSortOriginBatch(writeBuffer);
                        writeBuffer.clear();
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (writeBuffer.size()>0) {
                    //批量更新
                    wordSortOriginMapper.updateWordSortOriginBatch(writeBuffer);
                    writeBuffer.clear();
                }
            }
        }).start();
        return 1;
    }

    /**
     * 根据word爬取数据，返回json字符串
     *
     * @param word
     * @return 结果
     */
    private String crawlWordSortOrigin(String word) {
        //查询所有单词排行榜
        String url =String.format("https://dict.iciba.com/dictionary/word/suggestion?word=%s&nums=5&ck=709a0db45332167b0e2ce1868b84773e&timestamp=1677206005766&client=6&uid=123123&key=1000006&is_need_mean=1&signature=f51d56468f23aac80e02fed00f29263e", word);
        return get(url);
    }

    static CloseableHttpClient httpClient = HttpClients.createDefault();

    private static String get(String url){
        String result = "";
        HttpGet get = new HttpGet(url);
        try{
            HttpResponse response = httpClient.execute(get);
            result = getHttpEntityContent(response);

            if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
                result = "服务器异常";
            }
        } catch (Exception e){
            System.out.println("请求异常");
            throw new RuntimeException(e);
        } finally{
            get.abort();
        }
        return result;
    }

    private static String getHttpEntityContent(HttpResponse response) throws UnsupportedOperationException, IOException {
        String result = "";
        HttpEntity entity = response.getEntity();
        if(entity != null){
            InputStream in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber= new StringBuilder();
            String line = null;
            while((line = br.readLine())!=null){
                strber.append(line+'\n');
            }
            br.close();
            in.close();
            result = strber.toString();
        }

        return result;

    }

    /**
     * 解析wordMean
     */
    public Integer parseWordMean(Integer index){

        //开启新线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //查询所有单词排行榜
                //List<WordSortOrigin> wordSortOriginList = wordSortOriginMapper.selectWordSortEmpty(new WordSortOrigin());
                List<Long> ids = wordSortOriginMapper.selectWordSortOriginIdList();

                //遍历爬取数据
                List<WordMean> writeBuffer = new ArrayList<>(100);

                System.out.println("---->>> parse word mean");
                for (Long id : ids) {
                    if (id <= index )
                        continue;

                    WordSortOrigin wordSortOrigin = wordSortOriginMapper.selectWordSortOriginById(id);
                    //解析
                    writeBuffer.addAll(infoToMean(wordSortOrigin.getWordInfo(), wordSortOrigin.getWord()));

                    if (writeBuffer.size() >= 100) {
                        //批量更新
                        System.out.println("---->>> insert word mean");
                        wordMeanMapper.insertWordMeanBatch(writeBuffer);
                        writeBuffer.clear();
                        System.out.println("---->>> end insert:" + id);
                    }

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (writeBuffer.size()>0) {
                    //批量更新
                    wordMeanMapper.insertWordMeanBatch(writeBuffer);
                    writeBuffer.clear();
                }
            }
        }).start();

        return 1;
    }

    private List<WordMean> infoToMean(String wordInfo, String word){
        JSONObject obj = JSON.parseObject(wordInfo);
        JSONArray messages = obj.getJSONArray("message");

        List<WordMean> wordMeanList = new ArrayList<>();

        if (Objects.isNull(messages)) {
            return wordMeanList;
        }
        System.out.println("------>>>word:" + word);
        Word w = wordMapper.selectWordByWord(word);

        for (int i=0; i<messages.size(); i++) {
            JSONObject msg = messages.getJSONObject(i);
            if (!msg.getString("key").equals(word)) {
                continue;
            }

            JSONArray means = msg.getJSONArray("means");
            if (Objects.isNull(means)) {
                continue;
            }

            for (int j=0; j < means.size(); j++) {
                JSONObject mean = means.getJSONObject(j);
                WordMean wm = new WordMean();
                wm.setWordMean(mean.getString("means"));
                wm.setWordType(mean.getString("part"));
                wm.setWordId(w.getId());
                wm.setWord(w.getWord());

                wordMeanList.add(wm);
            }
        }
        return wordMeanList;
    }

    private String getMeanStr(String wordInfo, String word){
        JSONObject obj = JSON.parseObject(wordInfo);
        JSONArray messages = obj.getJSONArray("message");

        if (Objects.isNull(messages)) {
            return "";
        }
        System.out.println("------>>>word:" + word);
        Word w = wordMapper.selectWordByWord(word);

        for (int i=0; i<messages.size(); i++) {
            JSONObject msg = messages.getJSONObject(i);
            if (!msg.getString("key").equals(word)) {
                continue;
            }

            JSONArray means = msg.getJSONArray("means");
            if (Objects.isNull(means)) {
                continue;
            }

            return means.toString();
        }
        return "";
    }

    public Integer redundancyWordMean(Integer index){

        //开启新线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //查询所有单词排行榜
                //List<WordSortOrigin> wordSortOriginList = wordSortOriginMapper.selectWordSortEmpty(new WordSortOrigin());
                List<Long> ids = wordSortOriginMapper.selectWordSortOriginIdList();

                //遍历爬取数据
                List<Word> writeBuffer = new ArrayList<>(100);

                System.out.println("---->>> redundancy word mean");
                for (Long id : ids) {
                    if (id <= index )
                        continue;

                    WordSortOrigin wordSortOrigin = wordSortOriginMapper.selectWordSortOriginById(id);
                    //解析
                    String meanStr = getMeanStr(wordSortOrigin.getWordInfo(), wordSortOrigin.getWord());
                    Word w = new Word();
                    w.setId(wordSortOrigin.getId());
                    w.setWordMeanRedundancy(meanStr);

                    writeBuffer.add(w);

                    if (writeBuffer.size() >= 100) {
                        //批量更新
                        System.out.println("---->>> update word.mean");
                        wordMapper.batchUpdateWord(writeBuffer);
                        writeBuffer.clear();
                        System.out.println("---->>> end update:" + id);
                    }

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (writeBuffer.size()>0) {
                    //批量更新
                    wordMapper.batchUpdateWord(writeBuffer);
                    writeBuffer.clear();
                }
            }
        }).start();

        return 1;
    }
}
