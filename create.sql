create table categorias (id integer not null auto_increment, descripcion varchar(255), nombre varchar(255), primary key (id)) type=MyISAM
create table perfiles (id integer not null auto_increment, perfil varchar(255), primary key (id)) type=MyISAM
create table solicitudes (id integer not null auto_increment, archivo varchar(255), comentarios varchar(255), fecha datetime, idUsuario integer, idVacante integer, primary key (id)) type=MyISAM
create table usuarioperfil (idUsuario integer not null, idPerfil integer not null) type=MyISAM
create table usuarios (id integer not null auto_increment, email varchar(255), estatus integer, fechaRegistro datetime, nombre varchar(255), password varchar(255), username varchar(255), primary key (id)) type=MyISAM
create table vacantes (id integer not null auto_increment, descripcion varchar(255), destacado integer, detalles varchar(255), estatus varchar(255), fecha datetime, imagen varchar(255), nombre varchar(255), salario double precision, idCategoria integer, primary key (id)) type=MyISAM
alter table solicitudes add constraint FK6uc60tj1vme5ugicb3wsbty5n foreign key (idUsuario) references usuarios (id)
alter table solicitudes add constraint FKpfblrp23tga0yol9jqu8l1imv foreign key (idVacante) references vacantes (id)
alter table usuarioperfil add constraint FK5lbomr7ojdnqy8qx8pmyqad9q foreign key (idPerfil) references perfiles (id)
alter table usuarioperfil add constraint FK9kpw5och2qdm6mc58pxe2tdyk foreign key (idUsuario) references usuarios (id)
alter table vacantes add constraint FKklr5s1msbhe0s7soxvwyhl5k9 foreign key (idCategoria) references categorias (id)
create table categorias (id integer not null auto_increment, descripcion varchar(255), nombre varchar(255), primary key (id)) type=MyISAM
create table perfiles (id integer not null auto_increment, perfil varchar(255), primary key (id)) type=MyISAM
create table solicitudes (id integer not null auto_increment, archivo varchar(255), comentarios varchar(255), fecha datetime, idUsuario integer, idVacante integer, primary key (id)) type=MyISAM
create table usuarioperfil (idUsuario integer not null, idPerfil integer not null) type=MyISAM
create table usuarios (id integer not null auto_increment, email varchar(255), estatus integer, fechaRegistro datetime, nombre varchar(255), password varchar(255), username varchar(255), primary key (id)) type=MyISAM
create table vacantes (id integer not null auto_increment, descripcion varchar(255), destacado integer, detalles varchar(255), estatus varchar(255), fecha datetime, imagen varchar(255), nombre varchar(255), salario double precision, idCategoria integer, primary key (id)) type=MyISAM
alter table solicitudes add constraint FK6uc60tj1vme5ugicb3wsbty5n foreign key (idUsuario) references usuarios (id)
alter table solicitudes add constraint FKpfblrp23tga0yol9jqu8l1imv foreign key (idVacante) references vacantes (id)
alter table usuarioperfil add constraint FK5lbomr7ojdnqy8qx8pmyqad9q foreign key (idPerfil) references perfiles (id)
alter table usuarioperfil add constraint FK9kpw5och2qdm6mc58pxe2tdyk foreign key (idUsuario) references usuarios (id)
alter table vacantes add constraint FKklr5s1msbhe0s7soxvwyhl5k9 foreign key (idCategoria) references categorias (id)
create table categorias (id integer not null auto_increment, descripcion varchar(255), nombre varchar(255), primary key (id)) engine=InnoDB
create table perfiles (id integer not null auto_increment, perfil varchar(255), primary key (id)) engine=InnoDB
create table solicitudes (id integer not null auto_increment, archivo varchar(255), comentarios varchar(255), fecha datetime(6), idUsuario integer, idVacante integer, primary key (id)) engine=InnoDB
create table usuarioperfil (idUsuario integer not null, idPerfil integer not null) engine=InnoDB
create table usuarios (id integer not null auto_increment, email varchar(255), estatus integer, fechaRegistro datetime(6), nombre varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table vacantes (id integer not null auto_increment, descripcion varchar(255), destacado integer, detalles varchar(255), estatus varchar(255), fecha datetime(6), imagen varchar(255), nombre varchar(255), salario double precision, idCategoria integer, primary key (id)) engine=InnoDB
alter table solicitudes add constraint FK6uc60tj1vme5ugicb3wsbty5n foreign key (idUsuario) references usuarios (id)
alter table solicitudes add constraint FKpfblrp23tga0yol9jqu8l1imv foreign key (idVacante) references vacantes (id)
alter table usuarioperfil add constraint FK5lbomr7ojdnqy8qx8pmyqad9q foreign key (idPerfil) references perfiles (id)
alter table usuarioperfil add constraint FK9kpw5och2qdm6mc58pxe2tdyk foreign key (idUsuario) references usuarios (id)
alter table vacantes add constraint FKklr5s1msbhe0s7soxvwyhl5k9 foreign key (idCategoria) references categorias (id)
