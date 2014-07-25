create table LG_Coordinator (
	coordinatorId bigint not null primary key,
	facilityId bigint,
	officeId bigint
);

create table LG_Facility (
	facilityId bigint not null primary key,
	parentId int,
	name nvarchar(75) null,
	typ nvarchar(75) null,
	www nvarchar(75) null,
	level int,
	sort int
);

create table LG_Facility_Host (
	fasilityHostId bigint not null primary key,
	facilityId bigint,
	hostId bigint
);

create table LG_Host (
	hostId bigint not null primary key,
	protocol nvarchar(75) null,
	streamer nvarchar(75) null,
	port int,
	serverRoot nvarchar(75) null,
	name nvarchar(75) null
);

create table LG_Lastvideolist (
	lastvideolistId int not null primary key,
	videoId int
);

create table LG_Lectureseries (
	lectureseriesId bigint not null primary key,
	number_ nvarchar(75) null,
	eventType nvarchar(75) null,
	eventCategory nvarchar(75) null,
	name nvarchar(75) null,
	shortDesc nvarchar(75) null,
	semesterName nvarchar(75) null,
	language nvarchar(75) null,
	facultyName nvarchar(75) null,
	instructorsString nvarchar(75) null,
	password_ nvarchar(75) null,
	approved int,
	longDesc nvarchar(75) null
);

create table LG_Lectureseries_Facility (
	lectureseriesFacilityId bigint not null primary key,
	lectureseriesId bigint,
	facilityId bigint
);

create table LG_License (
	licenseId int not null primary key,
	videoId int,
	ccby nvarchar(75) null,
	ccbybc nvarchar(75) null,
	ccbyncnd nvarchar(75) null,
	ccbyncsa nvarchar(75) null,
	ccbysa nvarchar(75) null,
	ccbync nvarchar(75) null,
	l2go nvarchar(75) null
);

create table LG_Metadata (
	metadataId bigint not null primary key,
	URLID nvarchar(75) null,
	format nvarchar(75) null,
	type_ nvarchar(75) null,
	language nvarchar(75) null,
	title nvarchar(75) null,
	subject nvarchar(75) null,
	coverage nvarchar(75) null,
	description nvarchar(75) null,
	creator nvarchar(75) null,
	publisher nvarchar(75) null,
	contributor nvarchar(75) null,
	rightsHolder nvarchar(75) null,
	rights nvarchar(75) null,
	provenance nvarchar(75) null,
	source nvarchar(75) null,
	relation nvarchar(75) null,
	audience nvarchar(75) null,
	instructionalMethods nvarchar(75) null,
	date_ datetime null
);

create table LG_Office (
	officeId bigint not null primary key,
	name nvarchar(75) null,
	www nvarchar(75) null,
	email nvarchar(75) null,
	facilityId bigint
);

create table LG_Producer (
	producerId bigint not null primary key,
	idNum nvarchar(75) null,
	homeDir nvarchar(75) null,
	userId bigint,
	hostId bigint,
	facilityId bigint,
	numberOfProductions bigint,
	approved int
);

create table LG_Producer_Lectureseries (
	producerLectureseries bigint not null primary key,
	lectureseriesId bigint,
	producerId bigint
);

create table LG_Segment (
	segmentId int not null primary key,
	videoId int,
	start_ nvarchar(75) null,
	title nvarchar(75) null,
	description nvarchar(75) null,
	end_ nvarchar(75) null,
	chapter nvarchar(75) null,
	userId int
);

create table LG_Segment_User_Video (
	segmentId bigint,
	userId bigint,
	videoId bigint,
	segmentUserVideoId bigint not null primary key
);

create table LG_Sys (
	sysId int not null primary key,
	version nvarchar(75) null,
	setupWizard int
);

create table LG_Upload (
	uploadId bigint not null primary key,
	userId bigint,
	contentLength bigint,
	timestamp bigint,
	status int,
	videoId int
);

create table LG_Video (
	videoId bigint not null primary key,
	title nvarchar(75) null,
	tags nvarchar(75) null,
	lectureseriesId bigint,
	producerId bigint,
	containerFormat nvarchar(75) null,
	filename nvarchar(75) null,
	resolution nvarchar(75) null,
	duration nvarchar(75) null,
	hostId bigint,
	fileSize nvarchar(75) null,
	generationDate nvarchar(75) null,
	openAccess int,
	downloadLink int,
	metadataId int,
	surl nvarchar(75) null,
	hits int,
	uploadDate datetime null,
	permittedToSegment int,
	facilityId bigint,
	citation2go int
);

create table LG_Video_Facility (
	videoFacilityId bigint not null primary key,
	videoId bigint,
	facilityId bigint
);

create table LG_Videohitlist (
	videohitlistId int not null primary key,
	hitsPerDay int,
	hitsPerWeek int,
	hitsPerMonth int,
	hitsPerYear int
);
