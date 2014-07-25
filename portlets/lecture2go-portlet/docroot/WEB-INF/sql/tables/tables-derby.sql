create table LG_Coordinator (
	coordinatorId bigint not null primary key,
	facilityId bigint,
	officeId bigint
);

create table LG_Facility (
	facilityId bigint not null primary key,
	parentId integer,
	name varchar(75),
	typ varchar(75),
	www varchar(75),
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
	lectureseriesId bigint not null primary key,
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
	lectureseriesFacilityId bigint not null primary key,
	lectureseriesId bigint,
	facilityId bigint
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
	facilityId bigint
);

create table LG_Producer (
	producerId bigint not null primary key,
	idNum varchar(75),
	homeDir varchar(75),
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
	start_ varchar(75),
	title varchar(75),
	description varchar(75),
	end_ varchar(75),
	chapter varchar(75),
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
	version varchar(75),
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
	metadataId integer,
	surl varchar(75),
	hits integer,
	uploadDate timestamp,
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
