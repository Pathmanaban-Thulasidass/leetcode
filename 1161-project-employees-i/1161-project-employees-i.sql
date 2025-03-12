# Write your MySQL query statement below
select p.project_id , round(Avg(e.experience_years),2) as average_years
from Project p
left join Employee e
using(employee_id)
group by p.project_id;