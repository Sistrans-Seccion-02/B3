CREATE TABLE bares_hotel (
    id_servicio INTEGER NOT NULL,
    capacidad   INTEGER,
    estilo      VARCHAR2(4000)
);

ALTER TABLE bares ADD CONSTRAINT bares_id_servicio_un UNIQUE ( id_servicio );

CREATE TABLE bebidas_bar (
    nombre            VARCHAR2(20),
    costo             INTEGER,
    id                INTEGER NOT NULL,
    bares_id_servicio INTEGER NOT NULL
);

ALTER TABLE bebidas_bar ADD CONSTRAINT bebidas_bar_pk PRIMARY KEY ( bares_id_servicio,
                                                                    id );

CREATE TABLE checkins (
    reservas_id  INTEGER NOT NULL,
    id_checkin   INTEGER NOT NULL,
    clientes_id  INTEGER NOT NULL,
    empleados_id INTEGER NOT NULL
);

CREATE UNIQUE INDEX checkins__idx ON
    checkins (
        reservas_id
    ASC );

ALTER TABLE checkins ADD CONSTRAINT checkins_pk PRIMARY KEY ( id_checkin );

CREATE TABLE checkouts (
    reservas_id  INTEGER NOT NULL,
    id_checkout  INTEGER NOT NULL,
    clientes_id  INTEGER NOT NULL,
    empleados_id INTEGER NOT NULL
);

CREATE UNIQUE INDEX checkouts__idx ON
    checkouts (
        reservas_id
    ASC );

ALTER TABLE checkouts ADD CONSTRAINT checkouts_pk PRIMARY KEY ( id_checkout );

CREATE TABLE clientes (
    id              INTEGER NOT NULL,
    nombre          VARCHAR2(4000) NOT NULL,
    reservas_id     INTEGER NOT NULL,
    numacompañantes INTEGER
);

CREATE UNIQUE INDEX clientes__idx ON
    clientes (
        reservas_id
    ASC );

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( id );

CREATE TABLE consumos (
    id                         INTEGER,
    descripcion                VARCHAR2(500),
    costo                      NUMBER,
    fecha                      DATE,
    servicios_id_servicio      INTEGER NOT NULL,
    habitaciones_id_habitacion INTEGER NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( servicios_id_servicio,
                                                              habitaciones_id_habitacion );

CREATE TABLE empleados (
    id    INTEGER NOT NULL,
    cargo VARCHAR2(4000)
);

ALTER TABLE empleados ADD CONSTRAINT empleados_pk PRIMARY KEY ( id );

CREATE TABLE gimnasios (
    id_servicio INTEGER NOT NULL,
    capacidad   INTEGER,
    maquinas    INTEGER,
    horainicio  DATE,
    horafinal   DATE
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_id_servicio_un UNIQUE ( id_servicio );

CREATE TABLE habitaciones (
    tipo              VARCHAR2(4000) NOT NULL,
    hoteles_nombre    VARCHAR2(4000) NOT NULL,
    id_habitacion     INTEGER NOT NULL,
    tipohabitacion_id INTEGER NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( id_habitacion );

CREATE TABLE hoteles (
    nombre    VARCHAR2(4000) NOT NULL,
    ubicacion VARCHAR2(4000) NOT NULL,
    capacidad INTEGER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nombre );

CREATE TABLE internets (
    id_servicio INTEGER NOT NULL,
    capacidad   INTEGER NOT NULL
);

ALTER TABLE internets ADD CONSTRAINT internets_id_servicio_un UNIQUE ( id_servicio );

CREATE TABLE lavanderias (
    id_servicio INTEGER NOT NULL,
    zapatos     CHAR(1),
    prenda      CHAR(1),
    costo       NUMBER NOT NULL
);

ALTER TABLE lavanderias ADD CONSTRAINT lavanderias_pk PRIMARY KEY ( id_servicio );

CREATE TABLE piscinas (
    id_servicio INTEGER NOT NULL,
    capacidad   INTEGER,
    profundidad FLOAT,
    horainicio  DATE,
    horafinal   DATE
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id_servicio );

CREATE TABLE planes (
    plan VARCHAR2(4000) NOT NULL,
    id   VARCHAR2(20) NOT NULL
);

ALTER TABLE planes ADD CONSTRAINT planes_pk PRIMARY KEY ( id );

CREATE TABLE platos (
    nombre                   VARCHAR2(4000) NOT NULL,
    costo                    NUMBER NOT NULL,
    restaurantes_id_servicio INTEGER NOT NULL,
    id                       INTEGER NOT NULL
);

ALTER TABLE platos ADD CONSTRAINT platos_pk PRIMARY KEY ( id );

CREATE TABLE prod_super (
    nombre                   VARCHAR2(4000) NOT NULL,
    costo                    NUMBER NOT NULL,
    supermercado_id_servicio INTEGER NOT NULL,
    id                       INTEGER NOT NULL
);

ALTER TABLE prod_super ADD CONSTRAINT prod_super_pk PRIMARY KEY ( id );

CREATE TABLE productos_tienda (
    nombre              VARCHAR2(20),
    costo               INTEGER,
    tiendas_id_servicio INTEGER NOT NULL,
    id                  INTEGER NOT NULL
);

ALTER TABLE productos_tienda ADD CONSTRAINT productos_tienda_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    fecha_entrada         VARCHAR2(4000) NOT NULL,
    tipo                  VARCHAR2(4000) NOT NULL,
    fecha_salida          VARCHAR2(4000) NOT NULL,
    responsable           VARCHAR2(4000),
    hoteles_nombre        VARCHAR2(4000) NOT NULL,
    id                    INTEGER NOT NULL,
    checkins_id_checkin   INTEGER NOT NULL,
    checkouts_id_checkout INTEGER NOT NULL,
    planes_id             VARCHAR2(20) NOT NULL,
    clientes_id           INTEGER NOT NULL,
    cantidadpersonas      INTEGER
);

CREATE UNIQUE INDEX reservas__idx ON
    reservas (
        clientes_id
    ASC );

CREATE UNIQUE INDEX reservas__idxv1 ON
    reservas (
        checkouts_id_checkout
    ASC );

CREATE UNIQUE INDEX reservas__idxv2 ON
    reservas (
        checkins_id_checkin
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE resevs_serv (
    numeroreserva              INTEGER NOT NULL,
    fecha                      DATE,
    costo                      INTEGER,
    servicios_id_servicio      INTEGER NOT NULL,
    habitaciones_id_habitacion INTEGER NOT NULL
);

ALTER TABLE resevs_serv ADD CONSTRAINT resevs_serv_pk PRIMARY KEY ( numeroreserva );

CREATE TABLE restaurantes (
    id_servicio INTEGER NOT NULL,
    capacidad   VARCHAR2(4000) NOT NULL,
    estilo      VARCHAR2(4000),
    nombre      INTEGER
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id_servicio );

CREATE TABLE salon_conferencias (
    id_servicio INTEGER NOT NULL,
    costo       INTEGER NOT NULL,
    capacidad   INTEGER NOT NULL
);

ALTER TABLE salon_conferencias ADD CONSTRAINT salon_conferencias_pk PRIMARY KEY ( id_servicio );

CREATE TABLE salon_de_reuniones (
    id_servicio     INTEGER NOT NULL,
    capacidad       INTEGER,
    costo_adicional INTEGER,
    costo           INTEGER NOT NULL
);

ALTER TABLE salon_de_reuniones ADD CONSTRAINT salon_de_reuniones_pk PRIMARY KEY ( id_servicio );

CREATE TABLE servicios (
    id_servicio    INTEGER NOT NULL,
    hoteles_nombre VARCHAR2(4000) NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id_servicio );

CREATE TABLE spas (
    id_servicio INTEGER NOT NULL,
    duracion    INTEGER,
    costo       INTEGER NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id_servicio );

CREATE TABLE supermercado (
    id_servicio INTEGER NOT NULL,
    nombre      VARCHAR2(50)
);

ALTER TABLE supermercado ADD CONSTRAINT supermercado_pk PRIMARY KEY ( id_servicio );

CREATE TABLE tiendas (
    id_servicio INTEGER NOT NULL,
    nombre      VARCHAR2(50)
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( id_servicio );

CREATE TABLE tipohabitacion (
    id         INTEGER NOT NULL,
    nombretipo VARCHAR2(20) NOT NULL,
    capacidad  INTEGER NOT NULL,
    dotacion   VARCHAR2(500)
);

ALTER TABLE tipohabitacion ADD CONSTRAINT tipohabitacion_pk PRIMARY KEY ( id );

CREATE TABLE usuarios (
    id                INTEGER NOT NULL,
    hoteles_nombre    VARCHAR2(4000) NOT NULL,
    tipodocumento     VARCHAR2(3) NOT NULL,
    correoelectronico VARCHAR2(20) NOT NULL
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id );

CREATE TABLE utensilios (
    id_servicio INTEGER NOT NULL,
    devuelto    CHAR(1) NOT NULL
);

ALTER TABLE utensilios ADD CONSTRAINT utensilios_pk PRIMARY KEY ( id_servicio );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE bebidas_bar
    ADD CONSTRAINT bebidas_bar_bares_fk FOREIGN KEY ( bares_id_servicio )
        REFERENCES bares ( id_servicio );

ALTER TABLE checkins
    ADD CONSTRAINT checkins_clientes_fk FOREIGN KEY ( clientes_id )
        REFERENCES clientes ( id );

ALTER TABLE checkins
    ADD CONSTRAINT checkins_empleados_fk FOREIGN KEY ( empleados_id )
        REFERENCES empleados ( id );

ALTER TABLE checkins
    ADD CONSTRAINT checkins_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_clientes_fk FOREIGN KEY ( clientes_id )
        REFERENCES clientes ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_empleados_fk FOREIGN KEY ( empleados_id )
        REFERENCES empleados ( id );

ALTER TABLE checkouts
    ADD CONSTRAINT checkouts_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_usuarios_fk FOREIGN KEY ( id )
        REFERENCES usuarios ( id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habitaciones_fk FOREIGN KEY ( habitaciones_id_habitacion )
        REFERENCES habitaciones ( id_habitacion );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_servicios_fk FOREIGN KEY ( servicios_id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE empleados
    ADD CONSTRAINT empleados_usuarios_fk FOREIGN KEY ( id )
        REFERENCES usuarios ( id );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tipohabitacion_fk FOREIGN KEY ( tipohabitacion_id )
        REFERENCES tipohabitacion ( id );

ALTER TABLE internets
    ADD CONSTRAINT internets_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE lavanderias
    ADD CONSTRAINT lavanderias_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE platos
    ADD CONSTRAINT platos_restaurantes_fk FOREIGN KEY ( restaurantes_id_servicio )
        REFERENCES restaurantes ( id_servicio );

ALTER TABLE prod_super
    ADD CONSTRAINT prod_super_supermercado_fk FOREIGN KEY ( supermercado_id_servicio )
        REFERENCES supermercado ( id_servicio );

ALTER TABLE productos_tienda
    ADD CONSTRAINT productos_tienda_tiendas_fk FOREIGN KEY ( tiendas_id_servicio )
        REFERENCES tiendas ( id_servicio );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_checkins_fk FOREIGN KEY ( checkins_id_checkin )
        REFERENCES checkins ( id_checkin );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_checkouts_fk FOREIGN KEY ( checkouts_id_checkout )
        REFERENCES checkouts ( id_checkout );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_clientes_fk FOREIGN KEY ( clientes_id )
        REFERENCES clientes ( id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planes_fk FOREIGN KEY ( planes_id )
        REFERENCES planes ( id );

ALTER TABLE resevs_serv
    ADD CONSTRAINT resevs_serv_habitaciones_fk FOREIGN KEY ( habitaciones_id_habitacion )
        REFERENCES habitaciones ( id_habitacion );

ALTER TABLE resevs_serv
    ADD CONSTRAINT resevs_serv_servicios_fk FOREIGN KEY ( servicios_id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE salon_conferencias
    ADD CONSTRAINT salon_conferencias_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE salon_de_reuniones
    ADD CONSTRAINT salon_de_reuniones_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE supermercado
    ADD CONSTRAINT supermercado_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_hoteles_fk FOREIGN KEY ( hoteles_nombre )
        REFERENCES hoteles ( nombre );

ALTER TABLE utensilios
    ADD CONSTRAINT utensilios_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );
