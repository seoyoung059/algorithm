-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, Date_Format(HIRE_YMD, "%Y-%m-%d") as HIRE_YMD
from doctor 
where mcdp_cd in ("CS", "GS") 
order by HIRE_YMD desc, DR_NAME asc