use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table LG_Coordinator (
	coordinatorId decimal(20,0) not null primary key,
	facilityId decimal(20,0),
	officeId decimal(20,0)
)
go

create table LG_Facility (
	facilityId decimal(20,0) not null primary key,
	parentId int,
	name varchar(75) null,
	typ varchar(75) null,
	www varchar(75) null,
	level int,
	sort int
)
go

create table LG_Facility_Host (
	fasilityHostId decimal(20,0) not null primary key,
	facilityId decimal(20,0),
	hostId decimal(20,0)
)
go

create table LG_Host (
	hostId decimal(20,0) not null primary key,
	protocol varchar(75) null,
	streamer varchar(75) null,
	port int,
	serverRoot varchar(75) null,
	name varchar(75) null
)
go

create table LG_Lastvideolist (
	lastvideolistId int not null primary key,
	videoId int
)
go

create table LG_Lectureseries (
	lectureseriesId decimal(20,0) not null primary key,
	number_ varchar(75) null,
	eventType varchar(75) null,
	eventCategory varchar(75) null,
	name varchar(75) null,
	shortDesc varchar(75) null,
	semesterName varchar(75) null,
	language varchar(75) null,
	facultyName varchar(75) null,
	instructorsString varchar(75) null,
	password_ varchar(75) null,
	approved int,
	longDesc varchar(75) null
)
go

create table LG_Lectureseries_Facility (
	lectureseriesFacilityId decimal(20,0) not null primary key,
	lectureseriesId decimal(20,0),
	facilityId decimal(20,0)
)
go

create table LG_License (
	licenseId int not null primary key,
	videoId int,
	ccby varchar(75) null,
	ccbybc varchar(75) null,
	ccbyncnd varchar(75) null,
	ccbyncsa varchar(75) null,
	ccbysa varchar(75) null,
	ccbync varchar(75) null,
	l2go varchar(75) null
)
go

create table LG_Metadata (
	metadataId decimal(20,0) not null primary key,
	URLID varchar(75) null,
	format varchar(75) null,
	type_ varchar(75) null,
	language varchar(75) null,
	title varchar(75) null,
	subject varchar(75) null,
	coverage varchar(75) null,
	description varchar(75) null,
	creator varchar(75) null,
	publisher varchar(75) null,
	contributor varchar(75) null,
	rightsHolder varchar(75) null,
	rights varchar(75) null,
	provenance varchar(75) null,
	source varchar(75) null,
	relation varchar(75) null,
	audience varchar(75) null,
	instructionalMethods varchar(75) null,
	date_ datetime null
)
go

create table LG_Office (
	officeId decimal(20,0) not null primary key,
	name varchar(75) null,
	www varchar(75) null,
	email varchar(75) null,
	facilityId decimal(20,0)
)
go

create table LG_Producer (
	producerId decimal(20,0) not null primary key,
	idNum varchar(75) null,
	homeDir varchar(75) null,
	userId decimal(20,0),
	hostId decimal(20,0),
	facilityId decimal(20,0),
	numberOfProductions decimal(20,0),
	approved int
)
go

create table LG_Producer_Lectureseries (
	producerLectureseries decimal(20,0) not null primary key,
	lectureseriesId decimal(20,0),
	producerId decimal(20,0)
)
go

create table LG_Segment (
	segmentId int not null primary key,
	videoId int,
	start_ varchar(75) null,
	title varchar(75) null,
	description varchar(75) null,
	end_ varchar(75) null,
	chapter varchar(75) null,
	userId int
)
go

create table LG_Segment_User_Video (
	segmentId decimal(20,0),
	userId decimal(20,0),
	videoId decimal(20,0),
	segmentUserVideoId decimal(20,0) not null primary key
)
go

create table LG_Sys (
	sysId int not null primary key,
	version varchar(75) null,
	setupWizard int
)
go

create table LG_Upload (
	uploadId decimal(20,0) not null primary key,
	userId decimal(20,0),
	contentLength decimal(20,0),
	timestamp decimal(20,0),
	status int,
	videoId int
)
go

create table LG_Video (
	videoId decimal(20,0) not null primary key,
	title varchar(75) null,
	tags varchar(75) null,
	lectureseriesId decimal(20,0),
	producerId decimal(20,0),
	containerFormat varchar(75) null,
	filename varchar(75) null,
	resolution varchar(75) null,
	duration varchar(75) null,
	hostId decimal(20,0),
	fileSize varchar(75) null,
	generationDate varchar(75) null,
	openAccess int,
	downloadLink int,
	metadataId int,
	surl varchar(75) null,
	hits int,
	uploadDate datetime null,
	permittedToSegment int,
	facilityId decimal(20,0),
	citation2go int
)
go

create table LG_Video_Facility (
	videoFacilityId decimal(20,0) not null primary key,
	videoId decimal(20,0),
	facilityId decimal(20,0)
)
go

create table LG_Videohitlist (
	videohitlistId int not null primary key,
	hitsPerDay int,
	hitsPerWeek int,
	hitsPerMonth int,
	hitsPerYear int
)
go




