select 
    prices.product_id,
    round(
        ifnull(sum(unitsold.units * prices.price) / sum(unitsold.units), 0),
        2
    ) as average_price
from Prices prices
left join UnitsSold unitsold
    on prices.product_id = unitsold.product_id 
    and unitsold.purchase_date between prices.start_date and prices.end_date
group by prices.product_id;
