create index IX_8FA32867 on LG_Category (name);

create index IX_4EE19791 on LG_Coordinator (institutionId);
create index IX_8439EBD on LG_Coordinator (officeId);

create index IX_D3B1627D on LG_Creator (firstName);
create index IX_E933BBBC on LG_Creator (fullName);
create index IX_8BEDCA83 on LG_Creator (lastName);
create index IX_2CE50242 on LG_Creator (middleName);

create index IX_B56E8218 on LG_Host (groupId);
create index IX_35EC15AF on LG_Host (groupId, hostId);
create index IX_59DDB869 on LG_Host (hostId);

create index IX_78986E50 on LG_Institution (groupId);
create index IX_2F011093 on LG_Institution (groupId, institutionId);
create index IX_BB3A2F69 on LG_Institution (groupId, parentId);
create index IX_4CF38EBB on LG_Institution (groupId, parentId, sort);
create index IX_49E78C5A on LG_Institution (level);
create index IX_982D2D90 on LG_Institution (level, groupId);
create index IX_C5BF45E1 on LG_Institution (level, typ);
create index IX_63B03BE9 on LG_Institution (level, typ, groupId);
create index IX_582427D9 on LG_Institution (name);
create index IX_755E10F1 on LG_Institution (name, groupId);
create index IX_40A7A033 on LG_Institution (parentId);
create index IX_61742A2C on LG_Institution (sort);
create index IX_ACBFFBFE on LG_Institution (sort, groupId);
create index IX_C968E6A1 on LG_Institution (typ);
create index IX_8BEF7329 on LG_Institution (typ, groupId);
create index IX_C9925EAD on LG_Institution (www);
create index IX_8A5E489D on LG_Institution (www, groupId);

create index IX_4EF42608 on LG_Institution_Host (groupId, hostId);
create unique index IX_56E67D52 on LG_Institution_Host (groupId, institutionId);
create index IX_C8262FF0 on LG_Institution_Host (hostId);
create index IX_9018FE6A on LG_Institution_Host (institutionId);

create index IX_7503A061 on LG_Lastvideolist (videoId);

create index IX_8CD13042 on LG_Lectureseries (approved);
create index IX_A3002D84 on LG_Lectureseries (categoryId);
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
create index IX_E5CD21A4 on LG_Lectureseries (tags);
create index IX_8D242272 on LG_Lectureseries (termId);
create index IX_77CE15C3 on LG_Lectureseries (yearId);

create index IX_EE7F24BF on LG_Lectureseries_Category (categoryId);
create index IX_E459C00E on LG_Lectureseries_Category (lectureseriesId);

create index IX_60A5A33 on LG_Lectureseries_Creator (creatorId);
create index IX_B43D577C on LG_Lectureseries_Creator (lectureseriesId);
create index IX_3D4C3B5B on LG_Lectureseries_Creator (lectureseriesId, creatorId);

create index IX_719B09B3 on LG_Lectureseries_Institution (institutionId);
create index IX_A6D66CFD on LG_Lectureseries_Institution (institutionParentId);
create index IX_C80ED770 on LG_Lectureseries_Institution (lectureseriesId);
create index IX_4B074373 on LG_Lectureseries_Institution (lectureseriesId, institutionId);

create index IX_A925E0D7 on LG_Lectureseries_Person (lectureseriesId);
create index IX_6537F3ED on LG_Lectureseries_Person (personId);

create index IX_C0376223 on LG_License (videoId);

create index IX_41F2963D on LG_Office (institutionId);

create index IX_368EB4AC on LG_Person (firstName);
create index IX_6E15F674 on LG_Person (lastName);
create index IX_25B1F5F3 on LG_Person (middleName);

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

create index IX_A0EB34C3 on LG_ServerTemplate (groupId);
create index IX_7A43E1D3 on LG_ServerTemplate (serverTemplateId);

create index IX_8CFBC36 on LG_Tagcloud (isLectureseries);
create index IX_A59DF0BC on LG_Tagcloud (isVideo);
create index IX_CA87A1E on LG_Tagcloud (objectClassType);
create index IX_6D2C99CC on LG_Tagcloud (objectClassType, objectId);
create index IX_385A2033 on LG_Tagcloud (objectId);
create index IX_2FE55CF0 on LG_Tagcloud (type_);

create index IX_297D1038 on LG_Tags (isLectureseries);
create index IX_AC9866BE on LG_Tags (isVideo);
create index IX_B51AB490 on LG_Tags (tags);

create index IX_4A54301C on LG_Term (prefix);
create index IX_16F89D07 on LG_Term (year);

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

create index IX_ED691EED on LG_Video_Creator (creatorId);
create index IX_A28928BC on LG_Video_Creator (videoId);
create index IX_F68D221B on LG_Video_Creator (videoId, creatorId);

create index IX_39AE746D on LG_Video_Institution (institutionId);
create index IX_98796437 on LG_Video_Institution (institutionParentId);
create index IX_4467AFB0 on LG_Video_Institution (videoId);
create index IX_B5AE333 on LG_Video_Institution (videoId, institutionId);

create index IX_12087ECD on LG_Video_Lectureseries (lectureseriesId);
create index IX_F35885D3 on LG_Video_Lectureseries (videoId);

create index IX_BBE4D526 on LG_Videohitlist (videoId);

create index IX_D6EE16A6 on LG_Year (name);
create index IX_1954A2AD on LG_Year (prefix);