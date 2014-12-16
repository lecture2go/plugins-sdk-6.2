database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;


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


