CREATE TABLE flights
(
    id              bigserial PRIMARY KEY,
    flight_number   bigint,
    from_point      text,
    to_point        text,
    to_point_date   text,
    from_point_date text,
    air_company     text,
    flight_status   text,
    comment         text
);

CREATE TABLE users
(
    phone      text PRIMARY KEY,
    surname    text,
    name       text,
    patronymic text,
    email      text,
    org_inn    text
);

CREATE TABLE users_flights
(
    user_phone text   NOT NULL references users,
    id         bigint NOT NULL references flights,
    constraint xpk_users_flights
        primary key (user_phone, id)
);