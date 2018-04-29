\c carpool_db;

drop table if exists car_pool_booking;
drop table if exists car_pool_slot;
drop table if exists user_detail;
drop table if exists destination;

-- User data
create table user_detail (
    user_id varchar(20) primary key,
    first_name varchar(20), 
    last_name varchar(20),
    last_active_time timestamp );

-- Destination Reference Data
create table destination (
    destination_id integer primary key,
    destination_name varchar(50),
    area varchar(20) );

-- Car Pool Slot details
create table car_pool_slot (
    slot_id integer primary key,
    destination_id integer,
    total_slot integer,
    free_slot integer,
    offer_time timestamp,
    price integer,
    last_update_time timestamp,
    provider_id varchar(20),
    constraint dest_fkey foreign key(destination_id) references destination(destination_id),
    constraint provider_fkey foreign key(provider_id) references user_detail(user_id) );

-- Car Pool Bookings
create table car_pool_booking (
    seeker_id varchar(20),
    slot_id integer,
    last_update_time timestamp,
    constraint seeker_fkey foreign key(seeker_id) references user_detail(user_id),
    constraint slot_fkey foreign key(slot_id) references car_pool_slot(slot_id),
    primary key(seeker_id, slot_id) );

   
