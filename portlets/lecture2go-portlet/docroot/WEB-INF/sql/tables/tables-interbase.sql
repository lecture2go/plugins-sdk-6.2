create table LG_Coordinator (
	coordinatorId int64 not null primary key,
	facilityId int64,
	officeId int64
);

create table LG_Facility (
	facilityId int64 not null primary key,
	parentId integer,
	name varchar(75),
	typ varchar(75),
	www varchar(75),
	level integer,
	sort integer
);

create table LG_Facility_Host (
	fasilityHostId int64 not null primary key,
	facilityId int64,
	hostId int64
);

create table LG_Host (
	hostId int64 not null primary key,
	protocol varchar(75),
	streamer varchar(75),
	port integer,
	serverRoot varchar(75),
	name varchar(75)
);

create table LG_Lastvideolist (
	lastvideolistId integer not null primary key,
	videoId integer
);

create table LG_Lectureseries (
	lectureseriesId int64 not null primary key,
	number_ varchar(75),
	eventType varchar(75),
	eventCategory varchar(75),
	name varchar(75),
	shortDesc varchar(75),
	semesterName varchar(75),
	language varchar(75),
	facultyName varchar(75),
	instructorsString varchar(75),
	password_ varchar(75),
	approved integer,
	longDesc varchar(75)
);

create table LG_Lectureseries_Facility (
	lectureseriesFacilityId int64 not null primary key,
	lectureseriesId int64,
	facilityId int64
);

create table LG_License (
	licenseId integer not null primary key,
	videoId integer,
	ccby varchar(75),
	ccbybc varchar(75),
	ccbyncnd varchar(75),
	ccbyncsa varchar(75),
	ccbysa varchar(75),
	ccbync varchar(75),
	l2go varchar(75)
);

create table LG_Metadata (
	metadataId int64 not null primary key,
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
	officeId int64 not null primary key,
	name varchar(75),
	www varchar(75),
	email varchar(75),
	facilityId int64
);

create table LG_Producer (
	producerId int64 not null primary key,
	idNum varchar(75),
	homeDir varchar(75),
	userId int64,
	hostId int64,
	facilityId int64,
	numberOfProductions int64,
	approved integer
);

create table LG_Producer_Lectureseries (
	producerLectureseries int64 not null primary key,
	lectureseriesId int64,
	producerId int64
);

create table LG_Segment (
	segmentId integer not null primary key,
	videoId integer,
	start_ varchar(75),
	title varchar(75),
	description varchar(75),
	end_ varchar(75),
	chapter varchar(75),
	userId integer
);

create table LG_Segment_User_Video (
	segmentId int64,
	userId int64,
	videoId int64,
	segmentUserVideoId int64 not null primary key
);

create table LG_Sys (
	sysId integer not null primary key,
	version varchar(75),
	setupWizard integer
);

create table LG_Upload (
	uploadId int64 not null primary key,
	userId int64,
	contentLength int64,
	timestamp int64,
	status integer,
	videoId integer
);

create table LG_Video (
	videoId int64 not null primary key,
	title varchar(75),
	tags varchar(75),
	lectureseriesId int64,
	producerId int64,
	containerFormat varchar(75),
	filename varchar(75),
	resolution varchar(75),
	duration varchar(75),
	hostId int64,
	fileSize varchar(75),
	generationDate varchar(75),
	openAccess integer,
	downloadLink integer,
	metadataId integer,
	surl varchar(75),
	hits integer,
	uploadDate timestamp,
	permittedToSegment integer,
	facilityId int64,
	citation2go integer
);

create table LG_Video_Facility (
	videoFacilityId int64 not null primary key,
	videoId int64,
	facilityId int64
);

create table LG_Videohitlist (
	videohitlistId integer not null primary key,
	hitsPerDay integer,
	hitsPerWeek integer,
	hitsPerMonth integer,
	hitsPerYear integer
);
