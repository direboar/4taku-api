create table HeroEvaluation(
    id int primary key,
    -- tierTableId int not null,
    tierId int ,
    heroId int ,
    ban jsonb not null,
    memo varchar(9046) not null,
    linkName varchar(1024),
    linkUrl varchar(2048),
    evaluationOrder int not null
);
CREATE SEQUENCE hero_evaluation_seq START 1;

alter table if exists HeroEvaluation 
   add constraint HeroEvaluationFK 
   foreign key (tierId) 
   references Tier;

alter table if exists HeroEvaluation 
   add constraint HeroEvaluationFK2 
   foreign key (heroId) 
   references Hero;
