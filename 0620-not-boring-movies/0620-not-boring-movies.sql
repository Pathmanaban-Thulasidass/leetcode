# Write your MySQL query statement below
select *
from Cinema c
where (c.id % 2 != 0) and (description != 'boring')
order by c.rating desc;