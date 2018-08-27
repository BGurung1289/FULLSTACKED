select Lesson_Title from lesson;
select * from video;
select * from user;
select * from video WHERE Video_ID="1";
select * from rule WHERE RuleID="1";
select * from play WHERE PlayID="1";

INSERT INTO video(Video_ID, Video_Title, Video_URL) values("4", "Passing", "https://www.youtube.com/embed/32akH1rGcKA");
INSERT INTO play(PlayID, PlayName) values("4", "Passing");
INSERT INTO rule(RuleID, Rule_Name) values("4","Passing Rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("4", "Passing", (Select PlayID from play WHERE PlayID="4"),(Select RuleID from rule WHERE RuleID="4"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="4"));


INSERT INTO video(Video_ID, Video_Title, Video_URL) values("5", "Layup", "https://www.youtube.com/embed/BwR1DPCVsP8");
INSERT INTO play(PlayID, PlayName) values("5", "Scoring Inside");
INSERT INTO rule(RuleID, Rule_Name) values("5","Layup rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("5", "Layups", (Select PlayID from play WHERE PlayID="5"),(Select RuleID from rule WHERE RuleID="5"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="5"));


select * from play;

select * from lesson;