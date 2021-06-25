CREATE SEQUENCE IF NOT EXISTS conta_bancaria_id_seq;

CREATE TABLE IF NOT EXISTS conta_bancaria (
	id INT8 NOT NULL,
	nome VARCHAR(100) NOT NULL,
	numero_conta INT8 NOT NULL,
	agencia INT8 NOT NULL,
    cheque_especial_liberado boolean NOT NULL,
    saldo numeric(11,2) NOT NULL,
    cheque_especial numeric(11,2) NOT NULL,
    taxa numeric(11,2) NOT NULL,
	CONSTRAINT pk_conta_bancaria PRIMARY KEY (id)
);

ALTER TABLE conta_bancaria ALTER COLUMN id SET DEFAULT NEXTVAL('conta_bancaria_id_seq');
