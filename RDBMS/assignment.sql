create database assigment;
use assigment;


create table roles(id int not null primary key auto_increment,role varchar(50));
create table users(id int not null primary key auto_increment,name varchar(50),email varchar(50),role_id tinyint(1) references role(id));
create table questions(id int not null primary key auto_increment,question varchar(150),score int);
create table options(id int not null primary key auto_increment,option_a varchar(50),option_b varchar(50),option_c varchar(50),option_d varchar(50),is_image tinyint(1));
create table questions_options(id int not null primary key auto_increment,question_id int references questions(id),options_id int references options(id),is_visual tinyint(1));
create table result (id int not null primary key auto_increment, user_id int references users(id),assessment_question_id int references assessment_questions(id),answered varchar(50),is_correct tinyint(1));
create table assessment_questions(id int not null primary key auto_increment, question_id int references questions(id),assessment_id int references assessment(id));
create table assessment(id int not null primary key auto_increment,assessment_name varchar(50));


insert into roles values(1,'Administrator');
insert into roles values(2,'Candidate');


insert into users values(101,'Tejaswini Chile','tejaswini@weboniselab.com',2);
insert into users values(102,'Abhay Nikam','abhay@weboniselab.com',2);


insert into questions values(201,"26 Jan is celebrated as?",10);
insert into questions values(202,"15 Aug is celebrated as?",10);
insert into questions values(203,"Teacher day is on?",10);
insert into questions values(204,"Valentines day is on?",10);
insert into questions values(205,"National flag of India?",10);


insert into options values (301,"Republic day","Independence day","Teachers day","valentines day",0);
insert into options values (302,"Republic day","Independence day","Teachers day","valentines day",0);
insert into options values (303,"26 Jan","15 Aug","5 sept","14 Feb",0);
insert into options values (304,"26 Jan","15 Aug","5 sept","14 Feb",0);
insert into options values (305,"home/webonise/img1.jpg","home/webonise/img2.jpg","home/webonise/img3.jpg","home/webonise/img4.jpg",1);


insert into questions_options values(401,201,301,0);
insert into questions_options values(402,202,302,0);
insert into questions_options values(403,203,303,0);
insert into questions_options values(404,204,304,0);
insert into questions_options values(405,205,305,1);


insert into assessment_questions values(501,401,601);
insert into assessment_questions values(502,402,601);
insert into assessment_questions values(503,403,601);
insert into assessment_questions values(504,403,601);
insert into assessment_questions values(505,403,601);


insert into assessment values(601,"Assessment 1");


insert into result values(701,102,501,"Rebulic day",1);
insert into result values(702,102,502,"Independence day",1);
insert into result values(703,102,503,"5 sept",1);
insert into result values(704,102,504,"26 Jan",0);
insert into result values(705,102,505,"home/webonise/img2.jpg",1);
insert into result values(706,103,501,"Rebulic day",1);
insert into result values(707,103,502,"Independence day",1);
insert into result values(708,103,503,"5 sept",1);
insert into result values(709,103,504,"14 Feb",1);
insert into result values(710,103,505,"home/webonise/img2",1);


select * from roles;
select * from users;
select * from questions;
select * from options;
select * from questions_options;
select * from assessment_questions;
select * from assessment;
select * from result;


create view calculate_score as select u.id,u.name,sum(score) as assessment_score from result r, assessment_questions aq, questions q , users u where r.assessment_question_id = aq.id and aq.question_id = q.id and is_correct = 1 and u.id = r.user_id group by u.id;

select * from calculate_score;

set @sql = NULL;
select group_concat(quote(questions.question))into @sql from questions;
set @sql = concat('select users.id,users.name',@sql,'from users group by users.id');
prepare stmt from @sql;
execute stmt;

select max(if(q.question = '26 Jan is celebrated as?',r.answered,NULL)) as question from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id; 

/*select if(q.question = '26 Jan is celebrated as?',r.answered,NULL) as question1 ,if(q.question = '15 Aug is celebrated as?',r.answered,NULL) as question2 ,if(q.question = 'Teacher day is on?',r.answered,NULL) as question3 ,if(q.question = 'Valentines day is on?',r.answered,NULL) as question4 ,if(q.question = 'National flag of India is?',r.answered,NULL) as question5 from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id;
*/

/*select group_concat(concat('max(if(q.question = ''',question,''',r.answered,NULL)) as ',question)) into @sql from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id;
*/
set @sql = concat ('select users.id,users.name, ',@sql, 'from users where users.role_id = 2');

/*select group_concat(concat('if(q.question = ',question,' r.answered,NULL) as ',question)) into @sql from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id;

select max(if(q.question = question,r.answered,NULL)) as question from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id;

*/

select group_concat(distinct concat('if(q.question = ''',question,''',r.answered,NULL) as ',quote(question)) into @sql from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id;

set @sql = concat ('select r.user_id ,',@sql, ' from questions q, result r, assessment_questions aq where r.assessment_question_id = aq.id and aq.question_id = q.id');

prepare stmt from @sql;
execute stmt;
