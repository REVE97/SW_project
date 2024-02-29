/*
-- inner join

SELECT customer.name, book.bookname
FROM customer 
inner join orders on orders.custid
inner join book on orders.bookid = book.bookid
WHERE book.price = 20000;
*/

/*
-- LEFT OUTER JOIN 

SELECT customer.name,saleprice
FROM customer left outer join orders on customer.custid = orders.custid;
*/

 /*
 -- subquery

SELECT name
FROM customer
WHERE custid In(SELECT custid 
				FROM orders 
                WHERE bookid IN(SELECT bookid
								FROM book 
                                WHERE publisher='대한미디어') );
                                
*/


-- table 작성

/*
create table gisa(
	std_no integer primary key,
    email varchar(10) not null,
    kor integer not null,
	eng integer not null,
	math integer not null,
	sci integer not null,
	hist integer not null,
	total integer not null,
    mgr_code char(1) not null,
	acc_code char(1) not null,
	loc_code char(1) not null
);
*/

select * from gisa;

-- insert 사용
insert into gisa values(99000,'addx',17,29,16,49,43,154,'C','A','C');
     



