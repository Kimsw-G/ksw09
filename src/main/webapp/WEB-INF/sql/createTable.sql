create table member(
	m_pk int auto_increment primary key,
	m_id varchar(20) unique,
	m_pw char(60),
	m_name char(5),
	m_tel varchar(15)
);

create table normaltodo(
	normal_pk int auto_increment primary key,
	m_pk int,
	regdate date default now(),
	ctnt varchar(50),
	docheck boolean,
	FOREIGN KEY (m_pk) REFERENCES member (m_pk)
);

create table dailytodo(
	daily_pk int auto_increment primary key,
	m_pk int,
	regdate date default now(),
	todoDate int(3),
	ctnt varchar(50),
	dday_pk int,
	FOREIGN KEY (m_pk) REFERENCES member (m_pk),
	FOREIGN KEY (dday_pk) REFERENCES ddaytodo (dday_pk)
);

create table dailypercent(
	daily_pk int,
	check_date date,
	FOREIGN KEY (daily_pk) REFERENCES dailytodo (daily_pk)
);

create table ddaytodo(
	dday_pk int auto_increment primary key,
	content varchar(50),
	dday date,
	m_pk int,
	FOREIGN KEY (m_pk) REFERENCES member (m_pk)
);

