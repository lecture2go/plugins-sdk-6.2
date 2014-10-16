create table LG_Coordinator (
	coordinatorId LONG not null primary key,
	facilityId LONG,
	officeId LONG
);

create table LG_Facility (
	facilityId LONG not null primary key,
	parentId LONG,
	name VARCHAR(75) null,
	typ VARCHAR(75) null,
	www VARCHAR(75) null,
	level INTEGER,
	sort INTEGER
);

create table LG_Facility_Host (
	fasilityHostId LONG not null primary key,
	facilityId LONG,
	hostId LONG
);

create table LG_Host (
	hostId LONG not null primary key,
	protocol VARCHAR(75) null,
	streamer VARCHAR(75) null,
	port INTEGER,
	serverRoot VARCHAR(75) null,
	name VARCHAR(75) null
);

create table LG_Lastvideolist (
	lastvideolistId INTEGER not null primary key,
	videoId INTEGER
);

create table LG_Lectureseries (
	number_ VARCHAR(75) null,
	eventType VARCHAR(75) null,
	eventCategory VARCHAR(75) null,
	name VARCHAR(75) null,
	shortDesc VARCHAR(75) null,
	semesterName VARCHAR(75) null,
	language VARCHAR(75) null,
	facultyName VARCHAR(75) null,
	instructorsString VARCHAR(75) null,
	lectureseriesId LONG not null primary key,
	password_ VARCHAR(75) null,
	approved INTEGER,
	longDesc VARCHAR(75) null
);

create table LG_Lectureseries_Facility (
	lectureseriesFacilityId LONG not null primary key,
	lectureseriesId LONG,
	facilityId LONG
);

create table LG_License (
	licenseId INTEGER not null primary key,
	videoId INTEGER,
	ccby VARCHAR(75) null,
	ccbybc VARCHAR(75) null,
	ccbyncnd VARCHAR(75) null,
	ccbyncsa VARCHAR(75) null,
	ccbysa VARCHAR(75) null,
	ccbync VARCHAR(75) null,
	l2go VARCHAR(75) null
);

create table LG_Metadata (
	metadataId LONG not null primary key,
	URLID VARCHAR(75) null,
	format VARCHAR(75) null,
	type_ VARCHAR(75) null,
	language VARCHAR(75) null,
	title VARCHAR(75) null,
	subject VARCHAR(75) null,
	coverage VARCHAR(75) null,
	description VARCHAR(75) null,
	creator VARCHAR(75) null,
	publisher VARCHAR(75) null,
	contributor VARCHAR(75) null,
	rightsHolder VARCHAR(75) null,
	rights VARCHAR(75) null,
	provenance VARCHAR(75) null,
	source VARCHAR(75) null,
	relation VARCHAR(75) null,
	audience VARCHAR(75) null,
	instructionalMethods VARCHAR(75) null,
	date_ DATE null
);

create table LG_Office (
	officeId LONG not null primary key,
	name VARCHAR(75) null,
	www VARCHAR(75) null,
	email VARCHAR(75) null,
	facilityId LONG
);

create table LG_Producer (
	producerId LONG not null primary key,
	idNum VARCHAR(75) null,
	homeDir VARCHAR(75) null,
	hostId LONG,
	facilityId LONG,
	numberOfProductions LONG,
	approved INTEGER
);

create table LG_Producer_Lectureseries (
	producerLectureseriesId LONG not null primary key,
	lectureseriesId LONG,
	producerId LONG
);

create table LG_Segment (
	segmentId INTEGER not null primary key,
	videoId INTEGER,
	start_ VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	end_ VARCHAR(75) null,
	chapter VARCHAR(75) null,
	userId INTEGER
);

create table LG_Segment_User_Video (
	segmentId LONG,
	userId LONG,
	videoId LONG,
	segmentUserVideoId LONG not null primary key
);

create table LG_Sys (
	sysId INTEGER not null primary key,
	version VARCHAR(75) null,
	setupWizard INTEGER
);

create table LG_Upload (
	uploadId LONG not null primary key,
	userId LONG,
	contentLength LONG,
	timestamp LONG,
	status INTEGER,
	videoId INTEGER
);

create table LG_Video (
	videoId LONG not null primary key,
	title VARCHAR(75) null,
	tags VARCHAR(75) null,
	lectureseriesId LONG,
	producerId LONG,
	containerFormat VARCHAR(75) null,
	filename VARCHAR(75) null,
	resolution VARCHAR(75) null,
	duration VARCHAR(75) null,
	hostId LONG,
	fileSize VARCHAR(75) null,
	generationDate VARCHAR(75) null,
	openAccess INTEGER,
	downloadLink INTEGER,
	metadataId INTEGER,
	surl VARCHAR(75) null,
	hits INTEGER,
	uploadDate DATE null,
	permittedToSegment INTEGER,
	facilityId LONG,
	citation2go INTEGER
);

create table LG_VideoLectureseries (
	videoLectureseriesId LONG not null primary key,
	videoId LONG,
	lectureseriesId LONG
);

create table LG_Video_Facility (
	videoFacilityId LONG not null primary key,
	videoId LONG,
	facilityId LONG
);

create table LG_Video_Lectureseries (
	videoLectureseriesId LONG not null primary key,
	videoId LONG,
	lectureseriesId LONG
);

create table LG_Videohitlist (
	videohitlistId INTEGER not null primary key,
	hitsPerDay INTEGER,
	hitsPerWeek INTEGER,
	hitsPerMonth INTEGER,
	hitsPerYear INTEGER
);