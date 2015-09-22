create table LG_Category (
	categoryId bigint not null primary key,
	parentId bigint,
	languageId varchar(75),
	name varchar(75),
	translation varchar(75)
);

create table LG_Coordinator (
	coordinatorId bigint not null primary key,
	institutionId bigint,
	officeId bigint
);

create table LG_Host (
	hostId bigint not null primary key,
	protocol varchar(75),
	streamer varchar(75),
	port integer,
	serverRoot varchar(75),
	name varchar(75),
	serverTemplate varchar(75)
);

create table LG_Institution (
	institutionId bigint not null primary key,
	parentId bigint,
	name varchar(75),
	typ varchar(75),
	www varchar(75),
	level integer,
	sort integer
);

create table LG_Institution_Host (
	institutionHostId bigint not null primary key,
	institutionId bigint,
	hostId bigint
);

create table LG_Lastvideolist (
	lastvideolistId integer not null primary key,
	videoId bigint
);

create table LG_Lectureseries (
	number_ varchar(75),
	eventType varchar(75),
	eventCategory varchar(75),
	name varchar(75),
	shortDesc varchar(75),
	yearId bigint,
	language varchar(75),
	facultyName varchar(75),
	instructorsString varchar(75),
	lectureseriesId bigint not null primary key,
	password_ varchar(75),
	approved integer,
	longDesc varchar(75),
	latestOpenAccessVideoId bigint,
	latestVideoUploadDate timestamp,
	latestVideoGenerationDate varchar(75)
);

create table LG_Lectureseries_Category (
	lectureseriesCategoryId bigint not null primary key,
	categoryId bigint,
	lectureseriesId bigint
);

create table LG_Lectureseries_Institution (
	lectureseriesInstitutionId bigint not null primary key,
	lectureseriesId bigint,
	institutionId bigint
);

create table LG_License (
	licenseId bigint not null primary key,
	videoId bigint,
	ccby integer,
	ccbybc integer,
	ccbyncnd integer,
	ccbyncsa integer,
	ccbysa integer,
	ccbync integer,
	l2go integer
);

create table LG_Metadata (
	metadataId bigint not null primary key,
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
	date_ timestamp
);

create table LG_Office (
	officeId bigint not null primary key,
	name varchar(75),
	www varchar(75),
	email varchar(75),
	institutionId bigint
);

create table LG_Producer (
	producerId bigint not null primary key,
	idNum varchar(75),
	homeDir varchar(75),
	hostId bigint,
	institutionId bigint,
	numberOfProductions bigint,
	approved integer
);

create table LG_Producer_Lectureseries (
	producerLectureseriesId bigint not null primary key,
	lectureseriesId bigint,
	producerId bigint
);

create table LG_Segment (
	segmentId bigint not null primary key,
	videoId bigint,
	start_ varchar(75),
	title varchar(75),
	description varchar(75),
	end_ varchar(75),
	chapter integer,
	userId bigint
);

create table LG_Segment_User_Video (
	segmentId bigint,
	userId bigint,
	videoId bigint,
	segmentUserVideoId bigint not null primary key
);

create table LG_Sys (
	sysId integer not null primary key,
	version varchar(75),
	setupWizard integer
);

create table LG_TestEntity (
	testEntityId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	testField varchar(75)
);

create table LG_Upload (
	uploadId bigint not null primary key,
	userId bigint,
	contentLength bigint,
	timestamp bigint,
	status integer,
	videoId bigint
);

create table LG_Video (
	videoId bigint not null primary key,
	title varchar(75),
	tags varchar(75),
	lectureseriesId bigint,
	producerId bigint,
	containerFormat varchar(75),
	filename varchar(75),
	resolution varchar(75),
	duration varchar(75),
	hostId bigint,
	fileSize varchar(75),
	generationDate varchar(75),
	openAccess integer,
	downloadLink integer,
	metadataId bigint,
	surl varchar(75),
	hits bigint,
	uploadDate timestamp,
	permittedToSegment integer,
	rootInstitutionId bigint,
	citation2go integer,
	yearId bigint
);

create table LG_Video_Category (
	videoCategoryId bigint not null primary key,
	videoId bigint,
	categoryId bigint
);

create table LG_Video_Institution (
	videoInstitutionId bigint not null primary key,
	videoId bigint,
	institutionId bigint
);

create table LG_Video_Lectureseries (
	videoLectureseriesId bigint not null primary key,
	videoId bigint,
	lectureseriesId bigint,
	openAccess integer
);

create table LG_Videohitlist (
	videohitlistId bigint not null primary key,
	hitsPerDay bigint,
	hitsPerWeek bigint,
	hitsPerMonth bigint,
	hitsPerYear bigint,
	videoId bigint
);

create table LG_Year (
	yearId bigint not null primary key,
	prefix varchar(75),
	name varchar(75)
);
