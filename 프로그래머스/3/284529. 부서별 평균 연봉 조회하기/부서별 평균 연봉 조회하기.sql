SELECT A.DEPT_ID,DEPT_NAME_EN,ROUND(AVG(SAL)) AS AVG_SAL
FROM HR_EMPLOYEES AS A
JOIN HR_DEPARTMENT  AS B ON A.DEPT_ID = B.DEPT_ID
GROUP BY DEPT_ID
ORDER BY AVG_SAL DESC;
