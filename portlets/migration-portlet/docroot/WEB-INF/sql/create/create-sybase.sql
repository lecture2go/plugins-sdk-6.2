use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table LG_Migration_TestEntityTwo (
	plid decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table LG_Migration_Demo_ (
	id decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go




