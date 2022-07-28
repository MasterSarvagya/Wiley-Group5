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