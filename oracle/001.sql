--데이터 집어넣기
INSERT INTO T_MENU(MENU_NUM, TITLE, PRICE)
VALUES(1, '짜장면', 5000);

INSERT INTO T_MENU(MENU_NUM, TITLE, PRICE)
VALUES(2, '짬뽕', 6000);

INSERT INTO T_MENU(MENU_NUM, TITLE, PRICE)
VALUES(3, '군만두', 5000);

INSERT INTO T_MENU(MENU_NUM, TITLE, PRICE)
VALUES(4, '탕수육', 10000);

INSERT INTO T_MENU(MENU_NUM, TITLE, PRICE)
VALUES(5, '볶음밥', 6000);

--넣은 값들 확인해보기
SELECT *
FROM T_MENU
order by menu_num;

--위의 것과 다른 방법으로 RECEIPT에 데이터 넣어보기
--SYSDATE는 현재 날짜정보 나타낸다. 뒤의 char로 시스데이트를 'yyyy~'를 만들어서 바꿈
SELECT SYSDATE, TO_CHAR(SYSDATE, 'yyyy-mm-dd hh24:mi:ss')
FROM DUAL;

--RECEIPT 정보 넣어보기
INSERT INTO T_RECEIPT(RECEIPT_NUM, RECEIPT_DATETIME)
VALUES (1, TO_DATE('2017-07-26 09:30:45', 'yyyy-mm-dd hh24:mi:ss'));


INSERT INTO T_RECEIPT(RECEIPT_NUM, RECEIPT_DATETIME)
VALUES (2, TO_DATE('2017-07-26 09:40:42', 'yyyy-mm-dd hh24:mi:ss'));

INSERT INTO T_RECEIPT(RECEIPT_NUM, RECEIPT_DATETIME)
VALUES (3, TO_DATE('2017-07-26 09:53:04', 'yyyy-mm-dd hh24:mi:ss'));

--결과 볼때 *로 하지 말고 NUM, TO_CHAR로 포맷 정하고 해야 시간정보가 뜬다고 햄
SELECT RECEIPT_NUM, TO_CHAR(RECEIPT_DATETIME, 'yyyy-mm-dd hh24:mi:ss') "RECEIPT_DTIME"
FROM T_RECEIPT;

--커밋은 select로 결과 확인 후에 하기
COMMIT;

--RECEIPT_DETAIL에 첫번째 주문에 대한 정보 넣기
INSERT INTO T_RECEIPT_DETAIL(RECEIPT_NUM, MENU_NUM, QTY)
VALUES(1, 1, 2);

INSERT INTO T_RECEIPT_DETAIL(RECEIPT_NUM, MENU_NUM, QTY)
VALUES(1, 2, 1);

SELECT *
FROM T_RECEIPT_DETAIL;

COMMIT;

--T_MENU와 T_RECEIPT_DETAIL가 조인한 결과 만들기

--컬럼목록(*는 전체, 엑셀처럼 보이게 만들어줄 수도 있다. a.RECEIPT~이러케)
SELECT  a.RECEIPT_NUM, a.MENU_NUM, a.QTY, b.TITLE, b.PRICE, 
a.QTY * b.PRICE "AMOUNT"
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = B.MENU_NUM);  --테이블 또는 조인조건..디테일을 a, 메뉴는 b로 줄여말함

--지금 이 시각 볶음밥 2개 탕수육 1개 짜장면 1개를 먹었다. 얼마?
INSERT INTO T_RECEIPT(RECEIPT_NUM, RECEIPT_DATETIME)
VALUES (4, SYSDATE);

--입력 후에 항상 SELECT로 확인하기
SELECT RECEIPT_NUM, TO_CHAR(RECEIPT_DATETIME, 'yyyy-mm-dd hh24:mi:ss') "RECEIPT_DTIME"
FROM T_RECEIPT;

INSERT INTO T_RECEIPT_DETAIL(RECEIPT_NUM, MENU_NUM, QTY)
VALUES(4, 5, 2);

INSERT INTO T_RECEIPT_DETAIL(RECEIPT_NUM, MENU_NUM, QTY)
VALUES(4, 4, 1);

INSERT INTO T_RECEIPT_DETAIL(RECEIPT_NUM, MENU_NUM, QTY)
VALUES(4, 1, 1);

SELECT *
FROM T_RECEIPT_DETAIL;

COMMIT;

--영수증 디테일에서 영수증숫자 4만 나오게 하기 위해서 WHERE 씀. 그리고 디테일과 T_MENU를 조인
SELECT a.RECEIPT_NUM, b.TITLE, b.PRICE, a.QTY, b.PRICE * a.QTY "AMOUNT"
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = b.MENU_NUM)
WHERE a.RECEIPT_NUM = 4;

--전체 가격과 부가세까지 구해보자... 위의 것을 기반으로 SUM함수
SELECT a.RECEIPT_NUM, SUM(b.PRICE * a.QTY) "TOTAL"
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = b.MENU_NUM)
GROUP BY a.RECEIPT_NUM; --그룹함수 구할때의 기준 이렇게 하면 주문번호별 합산금액.
--만약 group by a.RECEIPT_NUM, b.TITLE;로 한다면 주문번호별+메뉴명별 함산금액이 됨
--T_RECEIPT를 같은 값이 있던 걸 이용해 조인하고 
SELECT a.RECEIPT_NUM, TO_CHAR(c.RECEIPT_DATETIME, 'yyyy-mm-dd hh24:mi:ss') "RECEIPT_DTIME", 
SUM(b.PRICE * a.QTY) "TOTAL", SUM(b.PRICE * a.QTY) * 0.1 "VAT"
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = b.MENU_NUM)
                        JOIN T_RECEIPT c ON (a.RECEIPT_NUM = c.RECEIPT_NUM)
GROUP BY a.RECEIPT_NUM, c.RECEIPT_DATETIME --그룹바이시 RECEIPT_DTIME으로 하면 안됨.
HAVING a.RECEIPT_NUM= 4; --WHERE a.RECEIPT_NUM = 4와 같은 뜻이지만 WHERE는 SELECT 후에 행 제약. 
--HAVING은 GROUPING 후에 행 제약. WHERE가 더 빠르기에 WHERE 최우선



--퀴즈: 메뉴별 매출현황을 구해보자 (조건: 매출이 높은 순으로)
--1 수량정보 확인
SELECT MENU_NUM, QTY
FROM T_RECEIPT_DETAIL; 
--2 PK와 FK로 조인하기
SELECT a.MENU_NUM, a.QTY, b.PRICE
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = b.MENU_NUM);
--3 양과 가격을 곱한 정보
SELECT a.MENU_NUM, a.QTY * b.PRICE
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = b.MENU_NUM);
--4 SUM으로 그룹핑
SELECT b.TITLE, SUM(a.QTY * b.PRICE) "AMOUNT" 
FROM T_RECEIPT_DETAIL a JOIN T_MENU b ON (a.MENU_NUM = b.MENU_NUM)
GROUP BY b.TITLE
ORDER BY AMOUNT DESC; --ORDER BY로 높은 순서대로함. 