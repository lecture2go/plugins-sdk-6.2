create table LG_Category (
	categoryId LONG not null primary key,
	parentId LONG,
	languageId VARCHAR(75) null,
	name VARCHAR(75) null,
	translation VARCHAR(75) null
);

create table LG_Coordinator (
	coordinatorId LONG not null primary key,
	institutionId LONG,
	officeId LONG
);

create table LG_Creator (
	creatorId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	jobTitle VARCHAR(75) null,
	gender VARCHAR(75) null,
	fullName VARCHAR(75) null
);

create table LG_Host (
	hostId LONG not null primary key,
	protocol VARCHAR(75) null,
	streamer VARCHAR(75) null,
	port INTEGER,
	serverRoot VARCHAR(75) null,
	name VARCHAR(75) null,
	serverTemplate VARCHAR(75) null
);

create table LG_Institution (
	institutionId LONG not null primary key,
	parentId LONG,
	name VARCHAR(75) null,
	typ VARCHAR(75) null,
	www VARCHAR(75) null,
	level INTEGER,
	sort INTEGER
);

create table LG_Institution_Host (
	institutionHostId LONG not null primary key,
	institutionId LONG,
	hostId LONG
);

create table LG_Lastvideolist (
	lastvideolistId INTEGER not null primary key,
	videoId LONG
);

create table LG_Lectureseries (
	number_ VARCHAR(75) null,
	eventType VARCHAR(75) null,
	categoryId LONG,
	name VARCHAR(75) null,
	shortDesc VARCHAR(75) null,
	termId LONG,
	language VARCHAR(75) null,
	facultyName VARCHAR(75) null,
	lectureseriesId LONG not null primary key,
	password_ VARCHAR(75) null,
	approved INTEGER,
	longDesc VARCHAR(75) null,
	latestOpenAccessVideoId LONG,
	latestVideoUploadDate DATE null,
	latestVideoGenerationDate VARCHAR(75) null
);

create table LG_Lectureseries_Category (
	lectureseriesCategoryId LONG not null primary key,
	categoryId LONG,
	lectureseriesId LONG
);

create table LG_Lectureseries_Creator (
	lectureseriesCreatorId LONG not null primary key,
	lectureseriesId LONG,
	creatorId LONG
);

create table LG_Lectureseries_Institution (
	lectureseriesInstitutionId LONG not null primary key,
	lectureseriesId LONG,
	institutionId LONG,
	institutionParentId LONG
);

create table LG_Lectureseries_Person (
	lectureseriesPersonId LONG not null primary key,
	lectureseriesId LONG,
	personId LONG
);

create table LG_License (
	licenseId LONG not null primary key,
	videoId LONG,
	ccby INTEGER,
	ccbybc INTEGER,
	ccbyncnd INTEGER,
	ccbyncsa INTEGER,
	ccbysa INTEGER,
	ccbync INTEGER,
	l2go INTEGER
);

create table LG_Metadata (
	metadataId LONG not null primary key,
	type_ VARCHAR(75) null,
	language VARCHAR(75) null,
	title VARCHAR(75) null,
	subject VARCHAR(75) null,
	description VARCHAR(75) null,
	publisher VARCHAR(75) null
);

create table LG_Metadata_Person (
	metadataPersonId LONG not null primary key,
	metadataId LONG,
	personId LONG
);

create table LG_Office (
	officeId LONG not null primary key,
	name VARCHAR(75) null,
	www VARCHAR(75) null,
	email VARCHAR(75) null,
	institutionId LONG
);

create table LG_Person (
	personId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	jobTitle VARCHAR(75) null
);

create table LG_Producer (
	producerId LONG not null primary key,
	idNum VARCHAR(75) null,
	homeDir VARCHAR(75) null,
	hostId LONG,
	institutionId LONG,
	numberOfProductions LONG,
	approved INTEGER
);

create table LG_Producer_Lectureseries (
	producerLectureseriesId LONG not null primary key,
	lectureseriesId LONG,
	producerId LONG
);

create table LG_Segment (
	segmentId LONG not null primary key,
	videoId LONG,
	start_ VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	end_ VARCHAR(75) null,
	chapter INTEGER,
	userId LONG
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

create table LG_Term (
	termId LONG not null primary key,
	parentId LONG,
	languageId VARCHAR(75) null,
	prefix VARCHAR(75) null,
	year VARCHAR(75) null,
	translation VARCHAR(75) null
);

create table LG_TestEntity (
	testEntityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	testField VARCHAR(75) null
);

create table LG_Upload (
	uploadId LONG not null primary key,
	userId LONG,
	contentLength LONG,
	timestamp LONG,
	status INTEGER,
	videoId LONG
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
	metadataId LONG,
	surl VARCHAR(75) null,
	hits LONG,
	uploadDate DATE null,
	permittedToSegment INTEGER,
	rootInstitutionId LONG,
	citation2go INTEGER,
	termId LONG,
	videoCreatorId LONG
);

create table LG_Video_Category (
	videoCategoryId LONG not null primary key,
	videoId LONG,
	categoryId LONG
);

create table LG_Video_Creator (
	videoCreatorId LONG not null primary key,
	creatorId LONG,
	videoId LONG
);

create table LG_Video_Institution (
	videoInstitutionId LONG not null primary key,
	videoId LONG,
	institutionId LONG
);

create table LG_Video_Lectureseries (
	videoLectureseriesId LONG not null primary key,
	videoId LONG,
	lectureseriesId LONG,
	openAccess INTEGER
);

create table LG_Videohitlist (
	videohitlistId LONG not null primary key,
	hitsPerDay LONG,
	hitsPerWeek LONG,
	hitsPerMonth LONG,
	hitsPerYear LONG,
	videoId LONG
);

create table LG_Year (
	yearId LONG not null primary key,
	parentId LONG,
	languageId VARCHAR(75) null,
	prefix VARCHAR(75) null,
	name VARCHAR(75) null,
	translation VARCHAR(75) null
);