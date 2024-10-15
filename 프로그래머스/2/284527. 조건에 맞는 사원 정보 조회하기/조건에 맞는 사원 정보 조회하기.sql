SELECT 
    C.SCORE,
    A.EMP_NO,
    A.EMP_NAME,
    A.POSITION,
    A.EMAIL
FROM 
    HR_EMPLOYEES AS A
JOIN 
    (SELECT 
        EMP_NO, 
        SUM(SCORE) AS SCORE 
     FROM 
        HR_GRADE 
     WHERE 
        YEAR = 2022 
     GROUP BY 
        EMP_NO) C ON A.EMP_NO = C.EMP_NO
WHERE 
    C.SCORE = (SELECT MAX(TOTAL_SCORE) 
                FROM (SELECT SUM(SCORE) AS TOTAL_SCORE 
                      FROM HR_GRADE 
                      WHERE YEAR = 2022 
                      GROUP BY EMP_NO) AS MAX_SCORES)
ORDER BY 
    C.SCORE DESC;