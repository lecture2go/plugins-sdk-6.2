create table LG_Migration_TestEntityTwo (
	plid int8 not null primary key,
	groupId int8,
	companyId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Migration_Demo_ (
	id int8 not null primary key,
	groupId int8,
	companyId int8
)
extent size 16 next size 16
lock mode row;
