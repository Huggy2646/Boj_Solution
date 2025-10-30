-- 코드를 입력하세요
SELECT  A.ANIMAL_ID  AS  ANIMAL_ID
      , A.ANIMAL_TYPE AS  ANIMAL_TYPE
      , A.NAME  AS  NAME
  FROM  
        ANIMAL_INS A
      , ANIMAL_OUTS B
 WHERE  A.ANIMAL_ID = B.ANIMAL_ID
   AND  A.SEX_UPON_INTAKE LIKE '%Intact%'
   AND  ( 
         B.SEX_UPON_OUTCOME LIKE '%Spayed%'
         OR
         B.SEX_UPON_OUTCOME LIKE '%Neutered%'
         )
 ORDER
    BY  ANIMAL_ID