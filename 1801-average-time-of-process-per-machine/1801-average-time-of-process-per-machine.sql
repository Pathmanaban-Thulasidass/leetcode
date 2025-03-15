# Write your MySQL query statement below
with tempTable as(select a1.machine_id, (a2.timestamp - a1.timestamp) as diff 
    from Activity a1
    cross join Activity a2
    where a1.machine_id = a2.machine_id and a1.process_id = a2.process_id and a1.activity_type = 'start' and a2.activity_type = 'end')


select machine_id, Round(Avg(diff),3) as processing_time
from  tempTable
group by machine_id;