create index IX_4EE19791 on LG_Coordinator (institutionId);
create index IX_8439EBD on LG_Coordinator (officeId);

create index IX_B56E8218 on LG_Host (groupId);
create index IX_35EC15AF on LG_Host (groupId, hostId);
create index IX_59DDB869 on LG_Host (hostId);

create index IX_78986E50 on LG_Institution (groupId);
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
create index IX_3714125D on LG_Lectureseries (password_);
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

create index IX_88EAD11B on LG_Upload (videoId);

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