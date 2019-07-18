create table car
(
	id bigint(19) auto_increment,
	car_number varchar(255) not null,
	constraint car_pk
		primary key (id)
);

create table parking_lot
(
    id       bigint(19) auto_increment
        primary key,
    capacity int(10)      not null,
    location varchar(255) null,
    name     varchar(255) not null
);

create table parking_order
(
	id bigint(19) auto_increment,
	end_time timestamp null,
	start_time timestamp null,
	flag int not null,
	parking_lot_id bigint(19) null,
	car_id bigint(19) null,
	lot_id bigint(19) null,
	constraint parking_order_pk
		primary key (id),
	constraint parking_order_car_id_fk
		foreign key (car_id) references car (id),
	constraint parking_order_parking_lot_id_fk
		foreign key (lot_id) references parking_lot (id)
);