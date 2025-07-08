with cte1 as(
    select customer_id
    from delivery
    group by customer_id
    having MIN(order_date) = MIN(customer_pref_delivery_date)
)
,
cte2 as(
    select customer_id
    from delivery
    group by customer_id
)

select ROUND(((select count(*) from cte1) / (select count(*) from cte2)) * 100,2) as immediate_percentage 