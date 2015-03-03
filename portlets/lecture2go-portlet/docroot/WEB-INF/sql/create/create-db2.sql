drop database lportal;
create database lportal pagesize 8192;
connect to lportal;
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


create index IX_8FA32867 on LG_Category (name);

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
create index IX_183A42D8 on LG_Lectureseries (latestGenerationDate);
create index IX_714473BA on LG_Lectureseries (latestOpenAccessVideoId);
create index IX_7DCCF0F3 on LG_Lectureseries (latestVideoGenerationDate);
create index IX_5EDF7468 on LG_Lectureseries (latestVideoId);
create index IX_31FBA89C on LG_Lectureseries (latestVideoUploadDate);
create index IX_DB929396 on LG_Lectureseries (name);
create index IX_225A0AF on LG_Lectureseries (number_);
create index IX_3714125D on LG_Lectureseries (password_);
create index IX_2E421DEE on LG_Lectureseries (semesterName);
create index IX_77CE15C3 on LG_Lectureseries (yearId);

create index IX_EE7F24BF on LG_Lectureseries_Category (categoryId);
create index IX_E459C00E on LG_Lectureseries_Category (lectureseriesId);

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

create index IX_88EAD11B on LG_Upload (videoId);

create index IX_D1B2A998 on LG_Video (filename);
create index IX_3B4515A3 on LG_Video (lectureseriesId);
create index IX_AAE2F865 on LG_Video (lectureseriesId, openAccess);
create index IX_35558E9E on LG_Video (producerId);
create index IX_2B61D434 on LG_Video (producerId, downloadLink);
create index IX_99A86BC2 on LG_Video (producerId, lectureseriesId);
create index IX_55AEC6E4 on LG_Video (rootInstitutionId);
create index IX_923BA320 on LG_Video (uploadDate);

create index IX_793FA2F9 on LG_Video_Category (categoryId);
create index IX_3334541A on LG_Video_Category (videoId);

create index IX_39AE746D on LG_Video_Institution (institutionId);
create index IX_4467AFB0 on LG_Video_Institution (videoId);

create index IX_12087ECD on LG_Video_Lectureseries (lectureseriesId);
create index IX_F35885D3 on LG_Video_Lectureseries (videoId);

create index IX_BBE4D526 on LG_Videohitlist (videoId);

create index IX_D6EE16A6 on LG_Year (name);
create index IX_1954A2AD on LG_Year (prefix);


