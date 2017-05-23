create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table LG_Migration_TestEntityTwo (plid int64 not null primary key,groupId int64,companyId int64);
create table LG_Migration_Demo_ (id int64 not null primary key,groupId int64,companyId int64);
