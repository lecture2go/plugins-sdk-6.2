drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table LG_Migration_TestEntityTwo (
	plid number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0)
);

create table LG_Migration_Demo_ (
	id number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0)
);





quit