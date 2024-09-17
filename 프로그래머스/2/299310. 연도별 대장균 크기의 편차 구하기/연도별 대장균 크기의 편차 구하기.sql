select b.year as YEAR, b.max_colony_size - a.size_of_colony as YEAR_DEV, a.id as ID
from
ecoli_data as a
join 
(SELECT year(differentiation_date) AS year, MAX(size_of_colony) AS max_colony_size
FROM ecoli_data
GROUP BY year(differentiation_date)) as b
on year(a.differentiation_date) = b.year
order by YEAR,YEAR_DEV;