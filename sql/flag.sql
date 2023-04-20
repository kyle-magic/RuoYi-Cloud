insert into word_flag(user_id, name,remark) values
(1,'n.' ,'名词(n.)'),
(1,'v.' ,'动词(v.)'),
(1,'adj.' ,'形容词(adj.)'),
(1,'abbr.' ,'缩写(abbr.)'),
(1,'adv.' ,'副词(adv.)'),
(1,'vt.' ,'及物动词(vt.)'),
(1,'vi.' ,'不及物动词(vi.)'),
(1,'prep.' ,'介词(prep.)'),
(1,'vt.& vi.' ,'vt.& vi.'),
(1,'pron.' ,'代词(pron.)'),
(1,'int.' ,'感叹词(int.)'),
(1,'conj.' ,'连词(conj.)'),
(1,'det.' ,'限定词(det.)'),
(1,'num.' ,'数词(num.)'),
(1,'aux.' ,'助词(aux.)'),
(1,'interj.' ,'感叹词(interj.)'),
(1,'art.' ,'冠词(art.)'),
(1,'exclamation' ,'感叹词(exclamation)'),
(1,'modal.' ,'情态动词(modal.)'),
(1,'infinitive marker' ,'infinitive marker'),
(1,'n.& v.' ,'n.& v.'),
(1,'adj. .' ,'adj. .'),
(1,'adj.& adv.' ,'adj.& adv.'),
(1,'combining form' ,'combining form'),
(1,'pref.' ,'pref.'),
(1,'vi. .' ,'vi. .'),
(1,'link-v.' ,'link-v.'),
(1,'adj.& n.' ,'adj.& n.'),
(1,'modal verb' ,'modal verb'),
(1,'n.& adj.' ,'n.& adj.'),
(1,'adj.& pron.' ,'adj.& pron.'),
(1,'pron.&det.' ,'pron.&det.'),
(1,'modal' ,'modal')


    insert into word_flag(user_id, name,remark) values
    (1,'UN_KNOWN_TYPE' ,'未知词性')



insert into word_flag_relation
select
    w.id,
    1 user_id,
    word_id,
    case when fl.id is null then 37 else fl.id end  flag_id,
    'N' del_flag,
    w.create_by,
    w.create_time,
    w.update_by,
    w.update_time,
    w.remark

from word_mean w
left join word_flag fl
   on w.word_type=fl.name