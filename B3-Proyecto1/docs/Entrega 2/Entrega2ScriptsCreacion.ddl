
CREATE TABLE bares (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(255),
    estilo     VARCHAR2(255),
    capacidad  INTEGER
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( idservicio );

CREATE TABLE bebidasbares (
    id     INTEGER NOT NULL,
    nombre VARCHAR2(255),
    costo  NUMBER,
    idbar  INTEGER NOT NULL
);

ALTER TABLE bebidasbares ADD CONSTRAINT bebidasbares_pk PRIMARY KEY ( id );

CREATE TABLE consumos (
    idconsumo   INTEGER NOT NULL,
    nhabitacion INTEGER NOT NULL,
    idservicio  INTEGER NOT NULL,
    identrada   INTEGER NOT NULL
);

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( idconsumo );

CREATE TABLE entradas (
    identrada INTEGER NOT NULL,
    idreserva INTEGER NOT NULL,
    idusuario INTEGER NOT NULL
);

ALTER TABLE entradas ADD CONSTRAINT entrada_pk PRIMARY KEY ( identrada );

CREATE TABLE gimnasios (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER,
    nmaquinas  INTEGER,
    horainicio VARCHAR2(255),
    horafinal  VARCHAR2(40)
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( idservicio );

CREATE TABLE habitaciones (
    nhabitacion    INTEGER NOT NULL,
    tipohabitacion VARCHAR2(255) NOT NULL, 
    costoHabitacion INTEGER NOT NULL
);

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( nhabitacion );

CREATE TABLE planes (
    nombre      VARCHAR2(255) NOT NULL,
    descripcion VARCHAR2(255),
    descuento   NUMBER
);

ALTER TABLE planes ADD CONSTRAINT planes_pk PRIMARY KEY ( nombre );

CREATE TABLE platos (
    id            INTEGER NOT NULL,
    nombre        VARCHAR2(255),
    costo         NUMBER,
    idrestaurante INTEGER NOT NULL
);

ALTER TABLE platos ADD CONSTRAINT platos_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    id             INTEGER NOT NULL,
    nombre         VARCHAR2(255),
    costo          NUMBER,
    idsupermercado INTEGER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

CREATE TABLE reservas (
    idreserva      INTEGER NOT NULL,
    numeropersonas INTEGER,
    fechaentrada   VARCHAR2(255),
    fechasalida    VARCHAR2(255),
    idusuario      INTEGER NOT NULL,
    nhabitacion    INTEGER NOT NULL,
    nombreplan     VARCHAR2(255) NOT NULL
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( idreserva );

CREATE TABLE reservasservicio (
    idreservaservicio INTEGER NOT NULL,
    fecha             VARCHAR2(100) NOT NULL,
    hora              VARCHAR2(100) NOT NULL,
    idservicio        INTEGER NOT NULL,
    nhabitacion       INTEGER NOT NULL
);

ALTER TABLE reservasservicio ADD CONSTRAINT reservaservicio_pk PRIMARY KEY ( idreservaservicio );

CREATE TABLE restaurantes (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(255),
    capacidad  INTEGER,
    estilo     VARCHAR2(255)
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurante_pk PRIMARY KEY ( idservicio );

CREATE TABLE salidas (
    idsalida   INTEGER NOT NULL,
    idusuario  INTEGER NOT NULL,
    idconsumo  INTEGER NOT NULL
);

ALTER TABLE salidas ADD CONSTRAINT salida_pk PRIMARY KEY ( idsalida );

CREATE TABLE salones (
    idservicio INTEGER NOT NULL,
    capacidad  INTEGER,
    costo      NUMBER
);

ALTER TABLE salones ADD CONSTRAINT salones_pk PRIMARY KEY ( idservicio );

CREATE TABLE servicios (
    idservicio INTEGER NOT NULL,
    tipo VARCHAR2(255),
    nombre VARCHAR2(255),
    costo INTEGER );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( idservicio );

CREATE TABLE spas (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(255),
    costo      INTEGER,
    duracion   INTEGER
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( idservicio );

CREATE TABLE supermercados (
    idservicio INTEGER NOT NULL,
    nombre     VARCHAR2(255)
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( idservicio );

CREATE TABLE tiposhabitacion (
    nombre    VARCHAR2(255) NOT NULL,
    dotacion  INTEGER,
    capacidad INTEGER
);

ALTER TABLE tiposhabitacion ADD CONSTRAINT tiposhabitacion_pk PRIMARY KEY ( nombre );

CREATE TABLE tiposusuario (
    id        INTEGER NOT NULL,
    tipo      VARCHAR2(255),
    funciones VARCHAR2(4000)
);

ALTER TABLE tiposusuario ADD CONSTRAINT tiposusuario_pk PRIMARY KEY ( id );

CREATE TABLE usuarios (
    idusuario   INTEGER NOT NULL,
    nombre      VARCHAR2(255),
    email       VARCHAR2(255),
    usuario     VARCHAR2(255),
    contraseña  VARCHAR2(255),
    tipousuario INTEGER NOT NULL
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( idusuario );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE bebidasbares
    ADD CONSTRAINT bebidasbares_bares_fk FOREIGN KEY ( idbar )
        REFERENCES bares ( idservicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_entrada_fk FOREIGN KEY ( identrada )
        REFERENCES entradas ( identrada );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habitaciones_fk FOREIGN KEY ( nhabitacion )
        REFERENCES habitaciones ( nhabitacion );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE entradas
    ADD CONSTRAINT entrada_reservas_fk FOREIGN KEY ( idreserva )
        REFERENCES reservas ( idreserva );

ALTER TABLE entradas
    ADD CONSTRAINT entrada_usuarios_fk FOREIGN KEY ( idusuario )
        REFERENCES usuarios ( idusuario );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasio_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE reservasservicio
    ADD CONSTRAINT habitacionservicio_fk FOREIGN KEY ( nhabitacion )
        REFERENCES habitaciones ( nhabitacion );

ALTER TABLE platos
    ADD CONSTRAINT platos_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES restaurantes ( idservicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_supermercados_fk FOREIGN KEY ( idsupermercado )
        REFERENCES supermercados ( idservicio );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_habitaciones_fk FOREIGN KEY ( nhabitacion )
        REFERENCES habitaciones ( nhabitacion );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_planes_fk FOREIGN KEY ( nombreplan )
        REFERENCES planes ( nombre );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_usuarios_fk FOREIGN KEY ( idusuario )
        REFERENCES usuarios ( idusuario );

ALTER TABLE reservasservicio
    ADD CONSTRAINT reservaservicio_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurante_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE salidas
    ADD CONSTRAINT salida_consumos_fk FOREIGN KEY ( idconsumo )
        REFERENCES consumos ( idconsumo );

ALTER TABLE salidas
    ADD CONSTRAINT salida_usuarios_fk FOREIGN KEY ( idusuario )
        REFERENCES usuarios ( idusuario );

ALTER TABLE salones
    ADD CONSTRAINT salones_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_servicios_fk FOREIGN KEY ( idservicio )
        REFERENCES servicios ( idservicio );

ALTER TABLE habitaciones
    ADD CONSTRAINT tipohabitacion_fk FOREIGN KEY ( tipohabitacion )
        REFERENCES tiposhabitacion ( nombre );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_tiposusuario_fk FOREIGN KEY ( tipousuario )
        REFERENCES tiposusuario ( id );





