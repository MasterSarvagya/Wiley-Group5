create database LibraryManagementSystem;

use  LibraryManagementSystem;

create table if not exists BOOKS(
BOOK_ID int primary key,
BOOK_NAME varchar(40) ,
BOOK_TYPE varchar(40),
AUTHOR_NAME varchar(30) not null,
ORIGINAL_QTY int,
QTY_LEFT int

);

insert into BOOKS
values
(901,'Data Analytics Made Accessible','Data Analytics','Dr. Anil Maheshwari','1000','1000'),
(902,'No Math Added','Data Analytics','Annalyn Ng and Kenneth Soo','800','800'),
(903,'Exploring Data in Python 3','Data Analytics','Dr. Charles Russell Severance','1200','1200'),
(904,'The Age of A.I. ','Technology','Henry Kissinger','1300','1300'),
(905,'Doing Agile Right','Technology','Steve Berez','1400','1400'),
(906,'Technology & Society','Technology','Jameson M. Wetmore','600','600'),
(907,' The One Minute Manager','Management','Spencer Johnson','800','800'),
(908,'On Becoming a Leader','Management','Warren Bennis','1100','1100'),
(909,'Turn the Ship Around!','Management','David Marquet','1250','1250');

create table if not exists Employees(
Employee_ID int primary key,
Employee_NAME varchar(40) ,
Phone_Number long,
isAdmin boolean,
Password varchar(40),
Book_Limit int

);


insert into Employee
values
(000,'Admin','9140879412','1','WileyAdmin','1500'),
(101,'Jai','9140879407','0','XyZ123','5'),
(102,'Sarvagya','9140879408','0','AbC321','5'),
(103,'Aryan','9140879409','0','DeF345','5'),
(105,'Atul ','9140879400','0','SeF111','5'),
(106,'Devesh','9140879401','0','ZeV123','5'),
(107,'Anjali','9140879402','0','AbW132','5'),
(108,' Anushree','9140879403','0','QeR768','5'),
(109,'Anushi','9140879404','0','L34Qae','5'),
(110,'Harmeet','9140879405','0','K3Q145','5');