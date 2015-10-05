drop database lportal;
create database lportal pagesize 8192;
connect to lportal;
create table LG_Migration_TestEntityTwo (
	plid bigint not null primary key,
	groupId bigint,
	companyId bigint
);

create table LG_Migration_Demo_ (
	id bigint not null primary key,
	groupId bigint,
	companyId bigint
);




