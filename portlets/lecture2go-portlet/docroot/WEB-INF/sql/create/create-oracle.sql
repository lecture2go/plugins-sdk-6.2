drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table LG_Coordinator (
	coordinatorId number(30,0) not null primary key,
	institutionId number(30,0),
	officeId number(30,0)
);

create table LG_Host (
	hostId number(30,0) not null primary key,
	protocol VARCHAR2(75 CHAR) null,
	streamer VARCHAR2(75 CHAR) null,
	port number(30,0),
	serverRoot VARCHAR2(75 CHAR) null,
	name VARCHAR2(75 CHAR) null,
	serverTemplate VARCHAR2(75 CHAR) null
);

create table LG_Institution (
	institutionId number(30,0) not null primary key,
	parentId number(30,0),
	name VARCHAR2(75 CHAR) null,
	typ VARCHAR2(75 CHAR) null,
	www VARCHAR2(75 CHAR) null,
	level number(30,0),
	sort number(30,0)
);

create table LG_Institution_Host (
	institutionHostId number(30,0) not null primary key,
	institutionId number(30,0),
	hostId number(30,0)
);

create table LG_Lastvideolist (
	lastvideolistId number(30,0) not null primary key,
	videoId number(30,0)
);

create table LG_Lectureseries (
	number_ VARCHAR2(75 CHAR) null,
	eventType VARCHAR2(75 CHAR) null,
	eventCategory VARCHAR2(75 CHAR) null,
	name VARCHAR2(75 CHAR) null,
	shortDesc VARCHAR2(75 CHAR) null,
	semesterName VARCHAR2(75 CHAR) null,
	language VARCHAR2(75 CHAR) null,
	facultyName VARCHAR2(75 CHAR) null,
	instructorsString VARCHAR2(75 CHAR) null,
	lectureseriesId number(30,0) not null primary key,
	password_ VARCHAR2(75 CHAR) null,
	approved number(30,0),
	longDesc VARCHAR2(75 CHAR) null
);

create table LG_Lectureseries_Institution (
	lectureseriesInstitutionId number(30,0) not null primary key,
	lectureseriesId number(30,0),
	institutionId number(30,0)
);

create table LG_License (
	licenseId number(30,0) not null primary key,
	videoId number(30,0),
	ccby number(30,0),
	ccbybc number(30,0),
	ccbyncnd number(30,0),
	ccbyncsa number(30,0),
	ccbysa number(30,0),
	ccbync number(30,0),
	l2go number(30,0)
);

create table LG_Metadata (
	metadataId number(30,0) not null primary key,
	URLID VARCHAR2(75 CHAR) null,
	format VARCHAR2(75 CHAR) null,
	type_ VARCHAR2(75 CHAR) null,
	language VARCHAR2(75 CHAR) null,
	title VARCHAR2(75 CHAR) null,
	subject VARCHAR2(75 CHAR) null,
	coverage VARCHAR2(75 CHAR) null,
	description VARCHAR2(75 CHAR) null,
	creator VARCHAR2(75 CHAR) null,
	publisher VARCHAR2(75 CHAR) null,
	contributor VARCHAR2(75 CHAR) null,
	rightsHolder VARCHAR2(75 CHAR) null,
	rights VARCHAR2(75 CHAR) null,
	provenance VARCHAR2(75 CHAR) null,
	source VARCHAR2(75 CHAR) null,
	relation VARCHAR2(75 CHAR) null,
	audience VARCHAR2(75 CHAR) null,
	instructionalMethods VARCHAR2(75 CHAR) null,
	date_ timestamp null
);

create table LG_Office (
	officeId number(30,0) not null primary key,
	name VARCHAR2(75 CHAR) null,
	www VARCHAR2(75 CHAR) null,
	email VARCHAR2(75 CHAR) null,
	institutionId number(30,0)
);

create table LG_Producer (
	producerId number(30,0) not null primary key,
	idNum VARCHAR2(75 CHAR) null,
	homeDir VARCHAR2(75 CHAR) null,
	hostId number(30,0),
	institutionId number(30,0),
	numberOfProductions number(30,0),
	approved number(30,0)
);

create table LG_Producer_Lectureseries (
	producerLectureseriesId number(30,0) not null primary key,
	lectureseriesId number(30,0),
	producerId number(30,0)
);

create table LG_Segment (
	segmentId number(30,0) not null primary key,
	videoId number(30,0),
	start_ VARCHAR2(75 CHAR) null,
	title VARCHAR2(75 CHAR) null,
	description VARCHAR2(75 CHAR) null,
	end_ VARCHAR2(75 CHAR) null,
	chapter number(30,0),
	userId number(30,0)
);

create table LG_Segment_User_Video (
	segmentId number(30,0),
	userId number(30,0),
	videoId number(30,0),
	segmentUserVideoId number(30,0) not null primary key
);

create table LG_Sys (
	sysId number(30,0) not null primary key,
	version VARCHAR2(75 CHAR) null,
	setupWizard number(30,0)
);

create table LG_TestEntity (
	testEntityId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	testField VARCHAR2(75 CHAR) null
);

create table LG_Upload (
	uploadId number(30,0) not null primary key,
	userId number(30,0),
	contentLength number(30,0),
	timestamp number(30,0),
	status number(30,0),
	videoId number(30,0)
);

create table LG_Video (
	videoId number(30,0) not null primary key,
	title VARCHAR2(75 CHAR) null,
	tags VARCHAR2(75 CHAR) null,
	lectureseriesId number(30,0),
	producerId number(30,0),
	containerFormat VARCHAR2(75 CHAR) null,
	filename VARCHAR2(75 CHAR) null,
	resolution VARCHAR2(75 CHAR) null,
	duration VARCHAR2(75 CHAR) null,
	hostId number(30,0),
	fileSize VARCHAR2(75 CHAR) null,
	generationDate VARCHAR2(75 CHAR) null,
	openAccess number(30,0),
	downloadLink number(30,0),
	metadataId number(30,0),
	surl VARCHAR2(75 CHAR) null,
	hits number(30,0),
	uploadDate timestamp null,
	permittedToSegment number(30,0),
	rootInstitutionId number(30,0),
	citation2go number(30,0)
);

create table LG_Video_Institution (
	videoInstitutionId number(30,0) not null primary key,
	videoId number(30,0),
	institutionId number(30,0)
);

create table LG_Video_Lectureseries (
	videoLectureseriesId number(30,0) not null primary key,
	videoId number(30,0),
	lectureseriesId number(30,0)
);

create table LG_Videohitlist (
	videohitlistId number(30,0) not null primary key,
	hitsPerDay number(30,0),
	hitsPerWeek number(30,0),
	hitsPerMonth number(30,0),
	hitsPerYear number(30,0)
);


create index IX_4EE19791 on LG_Coordinator (institutionId);
create index IX_8439EBD on LG_Coordinator (officeId);

create index IX_B56E8218 on LG_Host (groupId);
create index IX_35EC15AF on LG_Host (groupId, hostId);
create index IX_59DDB869 on LG_Host (hostId);

create index IX_49E78C5A on LG_Institution (level);
create index IX_C5BF45E1 on LG_Institution (level, typ);
create index IX_582427D9 on LG_Institution (name);
create index IX_40A7A033 on LG_Institution (parentId);
create index IX_61742A2C on LG_Institution (sort);
create index IX_C968E6A1 on LG_Institution (typ);
create index IX_C9925EAD on LG_Institution (www);

create index IX_C8262FF0 on LG_Institution_Host (hostId);
create index IX_9018FE6A on LG_Institution_Host (institutionId);

create index IX_7503A061 on LG_Lastvideolist (videoId);

create index IX_8CD13042 on LG_Lectureseries (approved);
create index IX_9D792271 on LG_Lectureseries (eventCategory);
create index IX_EBC55E2D on LG_Lectureseries (eventType);
create index IX_F43BC8 on LG_Lectureseries (facultyName);
create index IX_4F65B8A3 on LG_Lectureseries (language);
create index IX_DB929396 on LG_Lectureseries (name);
create index IX_225A0AF on LG_Lectureseries (number_);
create index IX_2E421DEE on LG_Lectureseries (semesterName);

create index IX_719B09B3 on LG_Lectureseries_Institution (institutionId);
create index IX_C80ED770 on LG_Lectureseries_Institution (lectureseriesId);
create index IX_4B074373 on LG_Lectureseries_Institution (lectureseriesId, institutionId);

create index IX_C0376223 on LG_License (videoId);

create index IX_41F2963D on LG_Office (institutionId);

create index IX_4FD6C927 on LG_Producer (approved);
create index IX_7DAEE222 on LG_Producer (homeDir);
create index IX_FE9C63D3 on LG_Producer (hostId);
create index IX_4115449F on LG_Producer (idNum);
create index IX_417E3527 on LG_Producer (institutionId);

create index IX_2A06594E on LG_Producer_Lectureseries (lectureseriesId);
create index IX_2BD4E3CF on LG_Producer_Lectureseries (lectureseriesId, producerId);
create index IX_C19D6C13 on LG_Producer_Lectureseries (producerId);

create index IX_BC659B8F on LG_Segment (userId);
create index IX_CBD5BF1 on LG_Segment (videoId);

create index IX_87A17CC1 on LG_Segment_User_Video (segmentId);
create index IX_165E5A37 on LG_Segment_User_Video (userId);
create index IX_F1DC7249 on LG_Segment_User_Video (videoId);

create index IX_3B4515A3 on LG_Video (lectureseriesId);
create index IX_AAE2F865 on LG_Video (lectureseriesId, openAccess);
create index IX_35558E9E on LG_Video (producerId);
create index IX_2B61D434 on LG_Video (producerId, downloadLink);
create index IX_99A86BC2 on LG_Video (producerId, lectureseriesId);
create index IX_55AEC6E4 on LG_Video (rootInstitutionId);

create index IX_39AE746D on LG_Video_Institution (institutionId);
create index IX_4467AFB0 on LG_Video_Institution (videoId);

create index IX_12087ECD on LG_Video_Lectureseries (lectureseriesId);
create index IX_F35885D3 on LG_Video_Lectureseries (videoId);



quit