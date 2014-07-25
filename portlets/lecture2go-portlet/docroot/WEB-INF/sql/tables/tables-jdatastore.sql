create table LG_Coordinator (
	coordinatorId bigint not null primary key,
	facilityId bigint,
	officeId bigint
);

create table LG_Facility (
	facilityId bigint not null primary key,
	parentId integer,
	name varchar(75) null,
	typ varchar(75) null,
	www varchar(75) null,
	level integer,
	sort integer
);

create table LG_Facility_Host (
	fasilityHostId bigint not null primary key,
	facilityId bigint,
	hostId bigint
);

create table LG_Host (
	hostId bigint not null primary key,
	protocol varchar(75) null,
	streamer varchar(75) null,
	port integer,
	serverRoot varchar(75) null,
	name varchar(75) null
);

create table LG_Lastvideolist (
	lastvideolistId integer not null primary key,
	videoId integer
);

create table LG_Lectureseries (
	lectureseriesId bigint not null primary key,
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
	approved integer,
	longDesc varchar(75) null
);

create table LG_Lectureseries_Facility (
	lectureseriesFacilityId bigint not null primary key,
	lectureseriesId bigint,
	facilityId bigint
);

create table LG_License (
	licenseId integer not null primary key,
	videoId integer,
	ccby varchar(75) null,
	ccbybc varchar(75) null,
	ccbyncnd varchar(75) null,
	ccbyncsa varchar(75) null,
	ccbysa varchar(75) null,
	ccbync varchar(75) null,
	l2go varchar(75) null
);

create table LG_Metadata (
	metadataId bigint not null primary key,
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
	date_ date null
);

create table LG_Office (
	officeId bigint not null primary key,
	name varchar(75) null,
	www varchar(75) null,
	email varchar(75) null,
	facilityId bigint
);

create table LG_Producer (
	producerId bigint not null primary key,
	idNum varchar(75) null,
	homeDir varchar(75) null,
	userId bigint,
	hostId bigint,
	facilityId bigint,
	numberOfProductions bigint,
	approved integer
);

create table LG_Producer_Lectureseries (
	producerLectureseries bigint not null primary key,
	lectureseriesId bigint,
	producerId bigint
);

create table LG_Segment (
	segmentId integer not null primary key,
	videoId integer,
	start_ varchar(75) null,
	title varchar(75) null,
	description varchar(75) null,
	end_ varchar(75) null,
	chapter varchar(75) null,
	userId integer
);

create table LG_Segment_User_Video (
	segmentId bigint,
	userId bigint,
	videoId bigint,
	segmentUserVideoId bigint not null primary key
);

create table LG_Sys (
	sysId integer not null primary key,
	version varchar(75) null,
	setupWizard integer
);

create table LG_Upload (
	uploadId bigint not null primary key,
	userId bigint,
	contentLength bigint,
	timestamp bigint,
	status integer,
	videoId integer
);

create table LG_Video (
	videoId bigint not null primary key,
	title varchar(75) null,
	tags varchar(75) null,
	lectureseriesId bigint,
	producerId bigint,
	containerFormat varchar(75) null,
	filename varchar(75) null,
	resolution varchar(75) null,
	duration varchar(75) null,
	hostId bigint,
	fileSize varchar(75) null,
	generationDate varchar(75) null,
	openAccess integer,
	downloadLink integer,
	metadataId integer,
	surl varchar(75) null,
	hits integer,
	uploadDate date null,
	permittedToSegment integer,
	facilityId bigint,
	citation2go integer
);

create table LG_Video_Facility (
	videoFacilityId bigint not null primary key,
	videoId bigint,
	facilityId bigint
);

create table LG_Videohitlist (
	videohitlistId integer not null primary key,
	hitsPerDay integer,
	hitsPerWeek integer,
	hitsPerMonth integer,
	hitsPerYear integer
);
