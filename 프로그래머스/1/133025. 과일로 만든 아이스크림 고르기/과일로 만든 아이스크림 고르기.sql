-- 코드를 입력하세요
SELECT fh.flavor
FROM first_half AS fh
JOIN icecream_info AS ii
ON fh.flavor = ii.flavor
WHERE fh.total_order > 3000 AND ii.ingredient_type="fruit_based"
order by fh.total_order desc;