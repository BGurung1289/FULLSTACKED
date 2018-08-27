INSERT INTO video(Video_ID, Video_Title, Video_URL) values("1", "Layup", "https://www.youtube.com/embed/BwR1DPCVsP8");
INSERT INTO play(PlayID, PlayName) values("1", "Inside Fundamentals");
INSERT INTO rule(RuleID, Rule_Name) values("1","Layup Rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("1", "Inside Scoring", (Select PlayID from play WHERE PlayID="1"),(Select RuleID from rule WHERE RuleID="1"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="1"));

INSERT INTO video(Video_ID, Video_Title, Video_URL) values("2", "Shooting", "https://www.youtube.com/embed/x7anDE7OEww");
INSERT INTO play(PlayID, PlayName) values("2", "Shooting Fundamentals");
INSERT INTO rule(RuleID, Rule_Name) values("2","Shooting Rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("2", "Shooting", (Select PlayID from play WHERE PlayID="2"),(Select RuleID from rule WHERE RuleID="2"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="2"));

INSERT INTO video(Video_ID, Video_Title, Video_URL) values("3", "Dribbling", "https://www.youtube.com/embed/HmlJjskzjuo");
INSERT INTO play(PlayID, PlayName) values("3", "Dribbling Fundamentals");
INSERT INTO rule(RuleID, Rule_Name) values("3","Dribbling Rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("3", "Dribbling", (Select PlayID from play WHERE PlayID="3"),(Select RuleID from rule WHERE RuleID="3"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="3"));

INSERT INTO video(Video_ID, Video_Title, Video_URL) values("4", "Passing", "https://www.youtube.com/embed/32akH1rGcKA");
INSERT INTO play(PlayID, PlayName) values("4", "Passing Fundamentals");
INSERT INTO rule(RuleID, Rule_Name) values("4","Passing Rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("4", "Passing", (Select PlayID from play WHERE PlayID="4"),(Select RuleID from rule WHERE RuleID="4"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="4"));

INSERT INTO video(Video_ID, Video_Title, Video_URL) values("5", "Screens", "https://www.youtube.com/watch?v=z9dQB37N5GE");
INSERT INTO play(PlayID, PlayName) values("5", "Screening Fundamentals");
INSERT INTO rule(RuleID, Rule_Name) values("5","Screening rules");
INSERT INTO lesson(LessonID, Lesson_Title, Play_ID, Rule_ID, User_ID, Video_ID) values("5", "Screening", (Select PlayID from play WHERE PlayID="5"),(Select RuleID from rule WHERE RuleID="5"),(Select UserID from user WHERE UserID="1"),(Select Video_ID from video WHERE Video_ID="5"));

