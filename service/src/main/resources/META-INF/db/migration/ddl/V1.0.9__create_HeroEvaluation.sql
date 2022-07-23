create table HeroEvaluation(
    id int primary key,
    -- tierTableId int not null,
    tierId int ,
    heroId int ,
    ban jsonb not null,
    memo varchar(9046) not null,
    heroMemoURL varchar(2048),
    evaluationOrder int not null
);
CREATE SEQUENCE hero_evaluation_seq START 1;
