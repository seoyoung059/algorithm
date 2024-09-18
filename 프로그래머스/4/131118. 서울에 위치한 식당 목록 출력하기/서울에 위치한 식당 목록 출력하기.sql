-- 코드를 입력하세요
SELECT  RI.REST_ID,
        RI.REST_NAME, 
        RI.FOOD_TYPE,
        RI.FAVORITES, 
        RI.ADDRESS, 
        ROUND(RR.SCORE,2) AS SCORE
    FROM (SELECT *
                FROM REST_INFO
                WHERE ADDRESS LIKE "서울%") AS RI
    JOIN (SELECT    REST_ID,
                    AVG(REVIEW_SCORE) AS SCORE
                FROM REST_REVIEW
                GROUP BY REST_ID) AS RR
    ON RI.REST_ID=RR.REST_ID
    ORDER BY SCORE DESC, FAVORITES DESC;