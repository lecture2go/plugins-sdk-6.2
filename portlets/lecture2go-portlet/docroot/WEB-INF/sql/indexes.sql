create index IX_C05F3E24 on LG_Coordinator (facilityId);
create index IX_8439EBD on LG_Coordinator (officeId);

create index IX_2859F587 on LG_Facility (level);
create index IX_8059650C on LG_Facility (name);
create index IX_A4C50BE6 on LG_Facility (parentId);
create index IX_89A9675F on LG_Facility (sort);
create index IX_2DCDB70E on LG_Facility (typ);
create index IX_2DF72F1A on LG_Facility (www);

create index IX_8CD13042 on LG_Lectureseries (approved);
create index IX_9D792271 on LG_Lectureseries (eventCategory);
create index IX_EBC55E2D on LG_Lectureseries (eventType);
create index IX_F43BC8 on LG_Lectureseries (facultyName);
create index IX_4F65B8A3 on LG_Lectureseries (language);
create index IX_DB929396 on LG_Lectureseries (name);
create index IX_225A0AF on LG_Lectureseries (number_);
create index IX_2E421DEE on LG_Lectureseries (semesterName);

create index IX_4FD6C927 on LG_Producer (approved);
create index IX_B7B3784E on LG_Producer (facilityId);
create index IX_7DAEE222 on LG_Producer (homeDir);
create index IX_FE9C63D3 on LG_Producer (hostId);
create index IX_4115449F on LG_Producer (idNum);