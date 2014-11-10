create index IX_C05F3E24 on LG_Coordinator (facilityId);
create index IX_8439EBD on LG_Coordinator (officeId);

create index IX_2859F587 on LG_Facility (level);
create index IX_8059650C on LG_Facility (name);
create index IX_A4C50BE6 on LG_Facility (parentId);
create index IX_89A9675F on LG_Facility (sort);
create index IX_2DCDB70E on LG_Facility (typ);
create index IX_2DF72F1A on LG_Facility (www);

create index IX_C28682D8 on LG_Facility_Host (facilityId);
create index IX_43DE435D on LG_Facility_Host (hostId);

create index IX_8CD13042 on LG_Lectureseries (approved);
create index IX_9D792271 on LG_Lectureseries (eventCategory);
create index IX_EBC55E2D on LG_Lectureseries (eventType);
create index IX_F43BC8 on LG_Lectureseries (facultyName);
create index IX_4F65B8A3 on LG_Lectureseries (language);
create index IX_DB929396 on LG_Lectureseries (name);
create index IX_225A0AF on LG_Lectureseries (number_);
create index IX_2E421DEE on LG_Lectureseries (semesterName);

create index IX_9ACE8C9 on LG_Lectureseries_Facility (facilityId);
create index IX_1E259A49 on LG_Lectureseries_Facility (lectureseriesId);
create index IX_77C632DB on LG_Lectureseries_Facility (lectureseriesId, facilityId);

create index IX_C0376223 on LG_License (videoId);

create index IX_4FD6C927 on LG_Producer (approved);
create index IX_B7B3784E on LG_Producer (facilityId);
create index IX_7DAEE222 on LG_Producer (homeDir);
create index IX_FE9C63D3 on LG_Producer (hostId);
create index IX_4115449F on LG_Producer (idNum);

create index IX_2A06594E on LG_Producer_Lectureseries (lectureseriesId);
create index IX_2BD4E3CF on LG_Producer_Lectureseries (lectureseriesId, producerId);
create index IX_C19D6C13 on LG_Producer_Lectureseries (producerId);

create index IX_87A17CC1 on LG_Segment_User_Video (segmentId);
create index IX_165E5A37 on LG_Segment_User_Video (userId);
create index IX_F1DC7249 on LG_Segment_User_Video (videoId);

create index IX_27903D2F on LG_Video (facilityId);
create index IX_3B4515A3 on LG_Video (lectureseriesId);
create index IX_35558E9E on LG_Video (producerId);
create index IX_99A86BC2 on LG_Video (producerId, lectureseriesId);

create index IX_7D0E80BC on LG_VideoLectureseries (lectureseriesId);
create index IX_EADAE6C2 on LG_VideoLectureseries (videoId);

create index IX_946D6703 on LG_Video_Facility (facilityId);
create index IX_1A4F9955 on LG_Video_Facility (videoId);

create index IX_12087ECD on LG_Video_Lectureseries (lectureseriesId);
create index IX_F35885D3 on LG_Video_Lectureseries (videoId);