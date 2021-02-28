-- les doubles quotes c'est pour que h2 n'interprète pas le nom de la table en majuscule
CREATE TABLE "accounts"
(
    account_id VARCHAR PRIMARY KEY,
    total     DOUBLE NOT NULL
);