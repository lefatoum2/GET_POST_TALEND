USE DATABASE ICOMMERCE;
CREATE SCHEMA I_OPE;

-- Définir le schéma à utiliser 
USE SCHEMA I_OPE;

-- 	Afficher la liste des tables
SHOW TABLES;

SELECT * FROM TB_CATEGORIE;
SELECT * FROM TB_SOUS_CATEGORIE;
SELECT * FROM TB_PRODUIT;


/*----------------------------------------------------------------------------------
  --------------------- Table N°2 : ICOMMERCE.I_OPE.TB_CATEGORIE -------------------
  ----------------------------------------------------------------------------------*/
CREATE TABLE TB_CATEGORIE 
(
	CD_CATEGORIE VARCHAR(50) NOT NULL,
	LB_CATEGORIE VARCHAR(100) NOT NULL,
	CONSTRAINT TB_CATEGORIE_PKEY PRIMARY KEY(CD_CATEGORIE)
);

/*----------------------------------------------------------------------------------
  ------------------ Table N°2 : ICOMMERCE.I_OPE.TB_SOUS_CATEGORIE -----------------
  ----------------------------------------------------------------------------------*/
CREATE TABLE TB_SOUS_CATEGORIE 
(
	CD_SOUS_CATEGORIE VARCHAR(50) NOT NULL,
	LB_SOUS_CATEGORIE VARCHAR(100) NOT NULL,
	CD_CATEGORIE VARCHAR(50) NOT NULL,
	CONSTRAINT TB_SOUS_CATEGORIE_PKEY PRIMARY KEY(CD_SOUS_CATEGORIE), 											
	CONSTRAINT TB_CATEGORIE_FKEY FOREIGN KEY (CD_CATEGORIE) 
		REFERENCES TB_CATEGORIE(CD_CATEGORIE)
);


/*----------------------------------------------------------------------------------
  --------------------- Table N°3 : ICOMMERCE.I_OPE.TB_PRODUIT ---------------------
  ----------------------------------------------------------------------------------*/
CREATE TABLE TB_PRODUIT 
(
	CD_PRODUIT VARCHAR(50) NOT NULL,
	NOM_PRODUIT VARCHAR(100) NOT NULL,
	PRIX_ACHAT_PRODUIT NUMBER(38,4) NOT NULL,
	PRIX_VENTE_PRODUIT NUMBER(38,4) NOT NULL,
	CD_SOUS_CATEGORIE VARCHAR(50) NOT NULL,
	CONSTRAINT TB_PRODUIT_PKEY PRIMARY KEY(CD_PRODUIT), 											
	CONSTRAINT TB_PRODUIT_FKEY FOREIGN KEY (CD_SOUS_CATEGORIE) 
		REFERENCES TB_SOUS_CATEGORIE(CD_SOUS_CATEGORIE)
);