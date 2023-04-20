insert into `word`
select
    id
     ,word
     ,''
     ,create_by
     ,now()
     ,update_by
     ,now()
     ,'' remark
from word_sort_origin



    insert into word_of_ranklist
select
    id
     ,1 user_id
     ,1 rank_list_id
     ,id word_id
     ,sort rank_num
     ,0 del_flag
     ,create_by
     ,now()
     ,update_by
     ,now()
     ,'' remark
from word_sort_origin limit 10
