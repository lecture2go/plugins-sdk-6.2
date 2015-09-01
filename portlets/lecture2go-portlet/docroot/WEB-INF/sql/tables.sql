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
	protocol STRING null,
	streamer STRING null,
	port INTEGER,
	serverRoot STRING null,
	name STRING null,
	groupId LONG,
	companId LONG
);

create table LG_Institution (
	institutionId LONG not null primary key,
	parentId LONG,
	name STRING null,
	typ STRING null,
	www STRING null,
	level INTEGER,
	sort INTEGER,
	groupId LONG,
	companyId LONG
);

create table LG_Institution_Host (
	institutionHostId LONG not null primary key,
	institutionId LONG,
	hostId LONG,
	groupId LONG,
	companyId LONG
);

create table LG_Lastvideolist (
	lastvideolistId INTEGER not null primary key,
	videoId LONG
);

create table LG_Lectureseries (
	number_ VARCHAR(75) null,
	eventType STRING null,
	categoryId LONG,
	name STRING null,
	shortDesc TEXT null,
	termId LONG,
	language STRING null,
	facultyName STRING null,
	lectureseriesId LONG not null primary key,
	password_ STRING null,
	approved INTEGER,
	longDesc TEXT null,
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
	title STRING null,
	subject STRING null,
	description TEXT null,
	publisher STRING null
);

create table LG_Office (
	officeId LONG not null primary key,
	name VARCHAR(75) null,
	www VARCHAR(75) null,
	email VARCHAR(75) null,
	institutionId LONG
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
	title STRING null,
	description TEXT null,
	end_ VARCHAR(75) null,
	chapter INTEGER,
	userId LONG
);

create table LG_ServerTemplate (
	serverTemplateId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null,
	type_ INTEGER,
	prefixURL VARCHAR(75) null,
	suffixURL VARCHAR(75) null,
	secExt VARCHAR(75) null,
	templateURL VARCHAR(75) null,
	prefixFile VARCHAR(75) null,
	suffixFile VARCHAR(75) null,
	templateFile VARCHAR(75) null,
	templateIOS LONG,
	templateAndroid LONG,
	defaultServer INTEGER
);

create table LG_StreamingServerTemplate (
	streamingServerTemplateId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null,
	type_ INTEGER,
	prefix VARCHAR(75) null,
	suffix VARCHAR(75) null,
	secondExtention VARCHAR(75) null,
	uri VARCHAR(75) null
);

create table LG_Sys (
	sysId INTEGER not null primary key,
	version STRING null,
	setupWizard INTEGER
);

create table LG_Tagcloud (
	tagcloudId LONG not null primary key,
	objectClassType VARCHAR(75) null,
	objectId LONG,
	tags VARCHAR(75) null
);

create table LG_Term (
	termId LONG not null primary key,
	parentId LONG,
	languageId VARCHAR(75) null,
	prefix VARCHAR(75) null,
	year VARCHAR(75) null,
	translation VARCHAR(75) null
);

create table LG_URITemplate (
	uriTemplateId LONG not null,
	groupId LONG,
	type_ VARCHAR(75) not null,
	prefix VARCHAR(75) null,
	suffix VARCHAR(75) null,
	template VARCHAR(75) null,
	primary key (uriTemplateId, type_)
);

create table LG_Upload (
	uploadId LONG not null primary key,
	userId LONG,
	contentLength LONG,
	timestamp DATE null,
	status INTEGER,
	videoId LONG
);

create table LG_Video (
	videoId LONG not null primary key,
	title STRING null,
	lectureseriesId LONG,
	producerId LONG,
	containerFormat VARCHAR(75) null,
	filename TEXT null,
	resolution VARCHAR(75) null,
	duration VARCHAR(75) null,
	hostId LONG,
	fileSize VARCHAR(75) null,
	generationDate VARCHAR(75) null,
	openAccess INTEGER,
	downloadLink INTEGER,
	metadataId LONG,
	secureFilename VARCHAR(75) null,
	hits LONG,
	uploadDate DATE null,
	permittedToSegment INTEGER,
	rootInstitutionId LONG,
	citation2go INTEGER,
	termId LONG,
	videoCreatorId LONG,
	tags TEXT null,
	password_ VARCHAR(75) null
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
	institutionId LONG,
	institutionParentId LONG
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