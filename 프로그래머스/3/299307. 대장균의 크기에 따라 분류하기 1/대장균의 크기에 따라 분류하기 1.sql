-- 코드를 작성해주세요
select
    id AS ID,
    case
        when(SIZE_OF_COLONY<=100) then "LOW"
        when(100< SIZE_OF_COLONY AND SIZE_OF_COLONY <= 1000) then "MEDIUM"
        when(1000< SIZE_OF_COLONY) then "HIGH"
    end AS SIZE
from ecoli_data
order by id;