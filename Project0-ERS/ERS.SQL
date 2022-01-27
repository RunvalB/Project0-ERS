CREATE DATABASE 'ERS';

CREATE TABLE employee (
empid int auto_increment=100,
empname varchar(30) not null ,
email varchar(30) not null UNIQUE ,
password varchar(30) not null ,
isManager bit not null default 0,
isWorking bit not null default 0,
constraint emp_pk primary key (empid)
);


CREATE TABLE request (
reqid int auto_increment=100,
remtype varchar(30) not null ,
amount int not null,
isApproved bit default 0,
reqStatus bit default 0, 
empid int,
constraint req_pk primary key(reqid),
constraint emp_fk foreign key(empid) references employee(empid)
);
