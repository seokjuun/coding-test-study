-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, sum(fp.price*fo.amount)
from food_product fp, food_order fo
where fp.product_id = fo.product_id
and fo.produce_date >= '2022-05-01'
and fo.produce_date <= '2022-05-31'
group by fp.product_id
order by sum(fp.price*fo.amount) desc, fp.product_id