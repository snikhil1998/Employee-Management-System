drop database empdb;
create database empdb;
use empdb;


create table department(
department_id int(10) not null primary key,
department_mn varchar(25) not null
);

create table employees(
empid int(10) not null primary key,
firstname varchar(45),
lastname varchar(45),
dob date,
email varchar(100),
department_id int(10),
foreign key (department_id) references department(department_id)
);

create table compliance(
complianceid int(10) not null primary key,
rltype varchar(15),
details varchar(250),
createdate date,
department_id int(10),
foreign key (department_id) references department(department_id)
);

create table statusreport(
complianceid int(10) not null,
statusrptid int(10) not null primary key,
empid int(10) not null,
comments varchar(15),
createdate date,
department_id int(10),
foreign key (complianceid) references compliance(complianceid),
foreign key (empid) references employees(empid),
foreign key (department_id) references department(department_id)
);

create table login_master(
userid int(10) not null primary key,
password varchar(30) not null,
role varchar(20) not null,
foreign key (userid) references employees(empid)
);