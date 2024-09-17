-- 코드를 작성해주세요
select count(id) as COUNT
from ECOLI_DATA
where (GENOTYPE & (1<<1))=0 AND ((GENOTYPE & (1<<0))!=0 OR (GENOTYPE & (1<<2))!=0);