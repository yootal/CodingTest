SELECT ID,IFNULL(LENGTH,10) AS LENGTH
FROM FISH_INFO 
ORDER BY LENGTH DESC, ID
LIMIT 10;