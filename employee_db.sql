drop database empdb;
create database empdb;
use empdb;


create table department(
department_id int(10) not null primary key,
department_nm varchar(25) not null
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

insert into department(department_id, department_nm) values(1, "top");
insert into department(department_id, department_nm) values(2, "below");

insert into employees(empid, firstname, lastname, dob, email, department_id) values(1, "a", "b", str_to_date(1998-1-1, "%Y-%m-%d"), "p@q.r", 1);
insert into employees(empid, firstname, lastname, dob, email, department_id) values(2, "c", "d", str_to_date(1998-1-2, "%Y-%m-%d"), "s@t.u", 2);

insert into login_master(userid, password, role) values(1, "admin", "admin");
insert into login_master(userid, password, role) values(2, "emp", "employee");
