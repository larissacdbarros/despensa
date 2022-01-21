create schema despensa;

--  ./down.sh
-- ./up.sh

set schema 'despensa';

create sequence sq_tb_alimento increment 1  minvalue 1 no maxvalue start 1 cache 1;

create table tb_alimento
(
    id_alimento   bigint default nextval('sq_tb_alimento') not null
        constraint pk_alimento primary key, --constraint é tipo uma restrição. aqui esta informando a primary key
    ds_nome       varchar(100)                             not null,
    qtd_gramatura integer
);

create sequence sq_tb_controle_alimento increment 1  minvalue 1 no maxvalue start 1 cache 1;

create table tb_controle_alimento
(
    id_controle_alimento  bigint default nextval('sq_tb_controle_alimento') not null
        constraint pk_controle_alimento primary key,
    id_alimento           bigint                                            not null
        constraint fk_alimento_controlealimento references tb_alimento, -- fk: foreign key -> informa que  a chave a ser usada deve ter na tabela que faz referencia
    -- fk_alimento_controlealimento -> alimento : é a tabela que tem esse id; controlealiemento: é a tabela em que estavamos
    qtd_quantidade_minima integer                                           not null,
    qtd_quantidade_ideal  integer                                           not null,
    qtd_quantidade_atual  integer                                           not null
);

create sequence sq_tb_controle_alimento_validade increment 1  minvalue 1 no maxvalue start 1 cache 1;

create table tb_controle_alimento_validade
(
    id_controle_alimento_validade bigint default nextval('sq_tb_controle_alimento_validade') not null
        constraint pk_controle_alimento_validade primary key,
    id_controle_alimento          bigint                                                     not null
        constraint fk_controlealimento_controlealimentovalidade references tb_controle_alimento,
    dt_validade                   date
);

create sequence sq_tb_lista_compra increment 1  minvalue 1 no maxvalue start 1 cache 1;

create table tb_lista_compra
(
    id_lista_compra bigint default nextval('sq_tb_lista_compra') not null
        constraint pk_lista_compra primary key,
    ds_nome         varchar(100)                                 not null
);

create table RL_LISTA_COMP_CTRL_ALIMENTOS
(
    id_controle_alimento bigint not null
        constraint fk_controlealimento_listacompctrlalimentos references tb_controle_alimento,
    id_lista_compra      bigint not null
        constraint fk_listacompra_listacompctrlalimentos references tb_lista_compra,
    unique (id_controle_alimento, id_lista_compra)
)


-- padrão de banco de dados
--
-- TABELAS:
--     _ começar com "tb_"
--     _ adicionar descrição da tabela
-- CAMPOS:
--     _ ds_nome_campo: descrição
--     _ co_nome_campo: código
--     _ id_nome_campo: identificador único
--     _ st_nome_campo : boolean
--     _ tp_nome_campo: tipo
--     _ qtd_nome_campo: quantidade
--     OBS: Adicionar comentários aos campos
--
--
-- SEQUENCE:
--     _ começar com "sq_nome_tabela"


-- CRIAR RELACIONAMENTOS:
--     _ fk_tabela1_tabela2

-- CONSTRAINTS:
--     _ regras exclusivas de cada tabela
--     _ começar com "ck_"
--     _ unique constranint começar "uk_"
