use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table LG_Category (
	categoryId decimal(20,0) not null primary key,
	parentId decimal(20,0),
	languageId varchar(75) null,
	name varchar(75) null,
	translation varchar(75) null
)
go

create table LG_Coordinator (
	coordinatorId decimal(20,0) not null primary key,
	institutionId decimal(20,0),
	officeId decimal(20,0)
)
go

create table LG_Host (
	hostId decimal(20,0) not null primary key,
	protocol varchar(75) null,
	streamer varchar(75) null,
	port int,
	serverRoot varchar(75) null,
	name varchar(75) null,
	serverTemplate varchar(75) null
)
go

create table LG_Institution (
	institutionId decimal(20,0) not null primary key,
	parentId decimal(20,0),
	name varchar(75) null,
	typ varchar(75) null,
	www varchar(75) null,
	level int,
	sort int
)
go

create table LG_Institution_Host (
	institutionHostId decimal(20,0) not null primary key,
	institutionId decimal(20,0),
	hostId decimal(20,0)
)
go

create table LG_Lastvideolist (
	lastvideolistId int not null primary key,
	videoId decimal(20,0)
)
go

create table LG_Lectureseries (
	number_ varchar(75) null,
	eventType varchar(75) null,
	eventCategory varchar(75) null,
	name varchar(75) null,
	shortDesc varchar(75) null,
	yearId decimal(20,0),
	language varchar(75) null,
	facultyName varchar(75) null,
	instructorsString varchar(75) null,
	lectureseriesId decimal(20,0) not null primary key,
	password_ varchar(75) null,
	approved int,
	longDesc varchar(75) null,
	latestOpenAccessVideoId decimal(20,0),
	latestVideoUploadDate datetime null,
	latestVideoGenerationDate varchar(75) null
)
go

create table LG_Lectureseries_Category (
	lectureseriesCategoryId decimal(20,0) not null primary key,
	categoryId decimal(20,0),
	lectureseriesId decimal(20,0)
)
go

create table LG_Lectureseries_Institution (
	lectureseriesInstitutionId decimal(20,0) not null primary key,
	lectureseriesId decimal(20,0),
	institutionId decimal(20,0)
)
go

create table LG_License (
	licenseId decimal(20,0) not null primary key,
	videoId decimal(20,0),
	ccby int,
	ccbybc int,
	ccbyncnd int,
	ccbyncsa int,
	ccbysa int,
	ccbync int,
	l2go int
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
	institutionId decimal(20,0)
)
go

create table LG_Producer (
	producerId decimal(20,0) not null primary key,
	idNum varchar(75) null,
	homeDir varchar(75) null,
	hostId decimal(20,0),
	institutionId decimal(20,0),
	numberOfProductions decimal(20,0),
	approved int
)
go

create table LG_Producer_Lectureseries (
	producerLectureseriesId decimal(20,0) not null primary key,
	lectureseriesId decimal(20,0),
	producerId decimal(20,0)
)
go

create table LG_Segment (
	segmentId decimal(20,0) not null primary key,
	videoId decimal(20,0),
	start_ varchar(75) null,
	title varchar(75) null,
	description varchar(75) null,
	end_ varchar(75) null,
	chapter int,
	userId decimal(20,0)
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

create table LG_TestEntity (
	testEntityId decimal(20,0) not null primary key,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	testField varchar(75) null
)
go

create table LG_Upload (
	uploadId decimal(20,0) not null primary key,
	userId decimal(20,0),
	contentLength decimal(20,0),
	timestamp decimal(20,0),
	status int,
	videoId decimal(20,0)
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
	metadataId decimal(20,0),
	surl varchar(75) null,
	hits decimal(20,0),
	uploadDate datetime null,
	permittedToSegment int,
	rootInstitutionId decimal(20,0),
	citation2go int,
	yearId decimal(20,0)
)
go

create table LG_Video_Category (
	videoCategoryId decimal(20,0) not null primary key,
	videoId decimal(20,0),
	categoryId decimal(20,0)
)
go

create table LG_Video_Institution (
	videoInstitutionId decimal(20,0) not null primary key,
	videoId decimal(20,0),
	institutionId decimal(20,0)
)
go

create table LG_Video_Lectureseries (
	videoLectureseriesId decimal(20,0) not null primary key,
	videoId decimal(20,0),
	lectureseriesId decimal(20,0),
	openAccess int
)
go

create table LG_Videohitlist (
	videohitlistId decimal(20,0) not null primary key,
	hitsPerDay decimal(20,0),
	hitsPerWeek decimal(20,0),
	hitsPerMonth decimal(20,0),
	hitsPerYear decimal(20,0),
	videoId decimal(20,0)
)
go

create table LG_Year (
	yearId decimal(20,0) not null primary key,
	prefix varchar(75) null,
	name varchar(75) null
)
go




