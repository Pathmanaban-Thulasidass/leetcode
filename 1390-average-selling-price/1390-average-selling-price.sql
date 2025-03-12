# Write your MySQL query statement below
select 
    p.product_id, 
    COALESCE(ROUND(SUM(p.price * COALESCE(u.units, 0)) / NULLIF(SUM(u.units), 0), 2), 0)    
    as average_price 
from Prices p
left join UnitsSold u
on (p.product_id = u.product_id) and u.purchase_date Between p.start_date and p.end_date
group by p.product_id
