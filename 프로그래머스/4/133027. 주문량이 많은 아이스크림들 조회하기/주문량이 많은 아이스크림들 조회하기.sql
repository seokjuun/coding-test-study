
select f.flavor as FLAVOR
from first_half f, (select flavor, sum(total_order) as total_order
                    from july 
                    group by flavor) j
where f.flavor = j.flavor
group by f.flavor
order by sum(f.total_order + j.total_order) desc
limit 3
