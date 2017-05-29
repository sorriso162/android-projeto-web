use sistemachamado;

select * from chamado;
insert into chamado values (1,'Vem arrumar logo porra','2015/05/11','2015/05/12','fechad','software',1);

insert into chamado values (2,'Vem arrumar logo porra','2015/05/11','2015/05/12','fechad','software',1);
insert into usuario  values(null,'123456789012345','jose bruno', 'senha', 'reclamante');

select * from usuario where cpf = '123456789012345' and senha = 'senha';

update usuario set cpf = '666' where id = 2;
create table usuario
(
	idUsuario integer(11) auto_increment not null primary key,
    cpf varchar (15) not null,
    nome varchar(100) not null,
    senha varchar(100) not null,
    tipo varchar(15) not null
);

create table administrador
(
	id integer(11) auto_increment not null primary key,
    cpf varchar (15) not null,
    nome varchar(100) not null,
    senha varchar(100) not null,
    tipo varchar(15) not null
);
insert into administrador  values(null,'1234','brunoeveryonemaster', '1234', 'administrador');
create table solucionador
(
	idSolucionador integer(11) auto_increment not null primary key,
    cpf varchar (15) not null,
    nome varchar(100) not null,
    senha varchar(100) not null,
    tipo varchar(15) not null
);
SELECT c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,u.nome,s.nome  FROM chamado c INNER JOIN usuario u on c.idUsuario = u.id INNER  JOIN solucionador s on  s.idSolucionador = c.idSolucionador WHERE c.id = 1;

create table chamado(
id integer(11) auto_increment not null primary key,
descricao varchar(100),
dataFim varchar(20),
dataInicio varchar(20) ,
status varchar(15) ,
tipo varchar(20) ,
idUsuario integer(11),
idSolucionador integer(11),
constraint pk_chamado_usuario foreign key(idUsuario) references usuario (idUsuario),
constraint pk_chamado_solucionador foreign key(idSolucionador) references solucionador (idSolucionador)
 );
 
 select * from administrador;
 select * from solucionador;
 select c.id,c.descricao,c.dataFim,c.dataInicio,c.status,c.tipo,s.nome,u.nome from chamado c inner join usuario u on c.idUsuario = u.idUsuario left join solucionador s on c.idSolucionador = s.idSolucionador;
 
 select * from usuario;
 drop table chamado;
 drop table usuario;
 drop table solucionador;
 drop table administrador;
 delete from chamado where id = 1; 
 insert into chamado values(null,'primeiro chamado','2017/12/05','2017/12/04','aberto','hardware',1,null);
  insert into chamado values(null,'primeiro chamado','2017/12/05','2017/12/04','aberto','hardware',4,1);
Select c.id, c.descricao, c.dateInicio,c.dataFim, c.status, u.nome, s.nome from chamado c Inner Join usuario u on c.idUsuario = u.id  where status = 'aberto';
Select c.id,  c.descricao, c.dataInicio, c.status, u.nome from chamado c Inner Join usuario u where status = 'aberto'; 
describe usuario;
describe administrador;
describe solucionador;
describe chamado;

Select c.id, c.descricao, c.tipo, c.dataInicio,c.dataFim, c.status, u.nome, c.idUsuario from chamado c Inner Join usuario u on c.idUsuario = u.idUsuario left join solucionador s on s.idSolucionador = c.idSolucionador where c.idUsuario = 1;