create table LG_Migration_TestEntityTwo (
	plid bigint not null primary key,
	groupId bigint,
	companyId bigint
) engine InnoDB;

create table LG_Migration_Demo_ (
	id bigint not null primary key,
	groupId bigint,
	companyId bigint
) engine InnoDB;
