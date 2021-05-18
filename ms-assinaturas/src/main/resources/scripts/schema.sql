/**
ALTER TABLE IF EXISTS t_event_history 
DROP CONSTRAINT IF EXISTS fk_subscription_in_t_event_history;

ALTER TABLE IF EXISTS t_subscription 
DROP CONSTRAINT IF EXISTS fk_status_in_t_subscription;

DROP TABLE IF EXISTS public.t_event_history;
DROP TABLE IF EXISTS public.t_status;
DROP TABLE IF EXISTS public.t_subscription;

DROP SEQUENCE IF EXISTS public.sq_event_history;
DROP SEQUENCE IF EXISTS public.sq_status;
DROP SEQUENCE IF EXISTS public.sq_subscription;
**/

CREATE SEQUENCE IF NOT EXISTS public.sq_status START 1;

CREATE TABLE IF NOT EXISTS public.t_status (
	id integer not null DEFAULT nextval('sq_status'),
	name varchar(255) not null,
	primary key(id)
);

CREATE TABLE IF NOT EXISTS public.t_subscription (
	id varchar(255) not null,
	status_id integer not null,
	create_at timestamp  not null,
	update_at timestamp  not null,
	primary key(id),
	constraint fk_status_in_t_subscription 
	foreign key(status_id)
	references t_status(id)
);

CREATE SEQUENCE IF NOT EXISTS public.sq_event_history START 1;

CREATE TABLE IF NOT EXISTS public.t_event_history (
	id integer not null DEFAULT nextval('sq_event_history'),
	type varchar(255) not null,
	subscription_id varchar(255) not null,
	create_at timestamp,
	primary key(id),
	constraint fk_subscription_in_t_event_history
	foreign key(subscription_id)
	references t_subscription(id)
);
