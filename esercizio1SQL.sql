CREATE TABLE IF NOT EXISTS clienti (
	numero_clienti SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	data_nascita DATE NOT NULL,
	regione_residenza VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS fornitori(
	numero_fornitore SERIAL PRIMARY KEY,
	denominazione VARCHAR NOT NULL,
	regione_residenza VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS fatture(
	numero_fattura SERIAL PRIMARY KEY,
	tipologia VARCHAR NOT NULL,
	importo DECIMAL NOT NULL,
	iva VARCHAR NOT NULL DEFAULT '20%',
	id_cliente INTEGER NOT NULL,
	data_fattura DATE NOT NULL,
	numero_fornitore INTEGER NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES clienti (numero_cliente),
	FOREIGN KEY (numero_fornitore) REFERENCES fornitori (numero_fornitore)
);

CREATE TABLE IF NOT EXISTS prodotti(
	id_prodotto SERIA PRIMARY KEY,
	descrizione VARCHAR NOT NULL,
	in_produzione BOOLEAN NOT NULL DEFAULT false,
	in_commercio BOOLEAN NOT NULL DEFAULT false,
	data_attivazione DATE NOT NULL,
	data_disattivazione DATE NOT NULL
);

INSERT INTO clienti (nome, cognome, data_nascita, regione_residenza)
       VALUES ('Dekanis', 'Hani', '21/06/1998', 'Lazio'),
              ('Mario', 'Rossi', '12/02/1982', 'Liguria'),
	          ('Guido', 'Guidi', '27/12/1995', 'Lombardia'),
	          ('Franco', 'Franchi', '18/10/1993', 'Piemonte');
	   
INSERT INTO fornitori (denominazione, regione_residenza)
       VALUES ('Damatech SRL', 'Lazio'),
              ('Plenzich SPA', 'Lombardia');
	   
INSERT INTO fatture (tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore)
       VALUES ('A', '1554.36', '20%', 2, '10/02/2020', 1),
	          ('B', '1810.99', '10%', 3, '29/08/2018', 2),
			  ('B', '2106.52', '4%', 1, '14/05/2022', 1),
			  ('A', '911.01', '20%', 2, '12/03/2021', 1);
			  
INSERT INTO prodotti (descrizione, in_produzione, in_commercio, data_attivazione, data_disattivazione)
       VALUES ('Bonifiche', true, true, '21/06/2016', '21/06/2024'),
	          ('Cambi', true, false, '10/08/2018', '10/08/2022'),
			  ('Resine', false, false, '01/07/2017', '01/07/2020');

SELECT * FROM clienti;
SELECT * FROM fornitori;
SELECT * FROM fatture;
SELECT * FROM prodotti;


SELECT nome, cognome FROM clienti WHERE EXTRACT(YEAR FROM data_nascita) = 1982;

SELECT COUNT(*) AS numero_fatture_20 FROM fatture WHERE iva = '20%';

SELECT EXTRACT(YEAR FROM data_fattura) AS anno, COUNT(*) AS numero_fatture, SUM(importo) AS importo FROM fatture GROUP BY EXTRACT(YEAR FROM data_fattura);

SELECT * FROM prodotti  WHERE EXTRACT(YEAR FROM data_attivazione) = 2017 AND (in_produzione = true OR in_commercio = true);

SELECT EXTRACT(YEAR FROM data_fattura) AS anno, COUNT(*) AS numero_fatture_20 FROM fatture WHERE iva = '20%' GROUP BY EXTRACT(YEAR FROM data_fattura);
