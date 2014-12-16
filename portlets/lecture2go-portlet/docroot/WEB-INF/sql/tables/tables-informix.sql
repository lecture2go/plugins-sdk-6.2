create table LG_Coordinator (
	coordinatorId int8 not null primary key,
	institutionId int8,
	officeId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Host (
	hostId int8 not null primary key,
	protocol varchar(75),
	streamer varchar(75),
	port int,
	serverRoot varchar(75),
	name varchar(75),
	serverTemplate varchar(75)
)
extent size 16 next size 16
lock mode row;

create table LG_Institution (
	institutionId int8 not null primary key,
	parentId int8,
	name varchar(75),
	typ varchar(75),
	www varchar(75),
	level int,
	sort int
)
extent size 16 next size 16
lock mode row;

create table LG_Institution_Host (
	institutionHostId int8 not null primary key,
	institutionId int8,
	hostId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Lastvideolist (
	lastvideolistId int not null primary key,
	videoId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Lectureseries (
	number_ varchar(75),
	eventType varchar(75),
	eventCategory varchar(75),
	name varchar(75),
	shortDesc varchar(75),
	semesterName varchar(75),
	language varchar(75),
	facultyName varchar(75),
	instructorsString varchar(75),
	lectureseriesId int8 not null primary key,
	password_ varchar(75),
	approved int,
	longDesc varchar(75)
)
extent size 16 next size 16
lock mode row;

create table LG_Lectureseries_Institution (
	lectureseriesInstitutionId int8 not null primary key,
	lectureseriesId int8,
	institutionId int8
)
extent size 16 next size 16
lock mode row;

create table LG_License (
	licenseId int8 not null primary key,
	videoId int8,
	ccby int,
	ccbybc int,
	ccbyncnd int,
	ccbyncsa int,
	ccbysa int,
	ccbync int,
	l2go int
)
extent size 16 next size 16
lock mode row;

create table LG_Metadata (
	metadataId int8 not null primary key,
	URLID varchar(75),
	format varchar(75),
	type_ varchar(75),
	language varchar(75),
	title varchar(75),
	subject varchar(75),
	coverage varchar(75),
	description varchar(75),
	creator varchar(75),
	publisher varchar(75),
	contributor varchar(75),
	rightsHolder varchar(75),
	rights varchar(75),
	provenance varchar(75),
	source varchar(75),
	relation varchar(75),
	audience varchar(75),
	instructionalMethods varchar(75),
	date_ datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;

create table LG_Office (
	officeId int8 not null primary key,
	name varchar(75),
	www varchar(75),
	email varchar(75),
	institutionId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Producer (
	producerId int8 not null primary key,
	idNum varchar(75),
	homeDir varchar(75),
	hostId int8,
	institutionId int8,
	numberOfProductions int8,
	approved int
)
extent size 16 next size 16
lock mode row;

create table LG_Producer_Lectureseries (
	producerLectureseriesId int8 not null primary key,
	lectureseriesId int8,
	producerId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Segment (
	segmentId int8 not null primary key,
	videoId int8,
	start_ varchar(75),
	title varchar(75),
	description varchar(75),
	end_ varchar(75),
	chapter int,
	userId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Segment_User_Video (
	segmentId int8,
	userId int8,
	videoId int8,
	segmentUserVideoId int8 not null primary key
)
extent size 16 next size 16
lock mode row;

create table LG_Sys (
	sysId int not null primary key,
	version varchar(75),
	setupWizard int
)
extent size 16 next size 16
lock mode row;

create table LG_TestEntity (
	testEntityId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	testField varchar(75)
)
extent size 16 next size 16
lock mode row;

create table LG_Upload (
	uploadId int8 not null primary key,
	userId int8,
	contentLength int8,
	timestamp int8,
	status int,
	videoId int
)
extent size 16 next size 16
lock mode row;

create table LG_Video (
	videoId int8 not null primary key,
	title varchar(75),
	tags varchar(75),
	lectureseriesId int8,
	producerId int8,
	containerFormat varchar(75),
	filename varchar(75),
	resolution varchar(75),
	duration varchar(75),
	hostId int8,
	fileSize varchar(75),
	generationDate varchar(75),
	openAccess int,
	downloadLink int,
	metadataId int8,
	surl varchar(75),
	hits int,
	uploadDate datetime YEAR TO FRACTION,
	permittedToSegment int,
	rootInstitutionId int8,
	citation2go int
)
extent size 16 next size 16
lock mode row;

create table LG_Video_Institution (
	videoInstitutionId int8 not null primary key,
	videoId int8,
	institutionId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Video_Lectureseries (
	videoLectureseriesId int8 not null primary key,
	videoId int8,
	lectureseriesId int8
)
extent size 16 next size 16
lock mode row;

create table LG_Videohitlist (
	videohitlistId int8 not null primary key,
	hitsPerDay int,
	hitsPerWeek int,
	hitsPerMonth int,
	hitsPerYear int
)
extent size 16 next size 16
lock mode row;
