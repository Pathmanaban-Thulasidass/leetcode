# Write your MySQL query statement below
select w2.id
from Weather w1
cross join Weather w2
WHERE DATEDIFF(w2.recordDate, w1.recordDate) = 1 
And w2.temperature > w1.temperature;