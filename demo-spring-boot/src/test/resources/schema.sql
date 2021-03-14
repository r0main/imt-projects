-- les doubles quotes c'est pour que h2 n'interprète pas le nom de la table en majuscule
CREATE TABLE "accounts"
(
    account_id VARCHAR PRIMARY KEY,
    total      DOUBLE NOT NULL
);

CREATE TABLE "debits"
(
    id      int(11) PRIMARY KEY AUTO_INCREMENT,
    montant DOUBLE NOT NULL
);

CREATE TABLE "account_debit"
(
    "debit_id"  int(11),
    "account_id" VARCHAR,
    PRIMARY KEY ("debit_id", "account_id"),
    CONSTRAINT "BRANCH_SUB_ID_FK" FOREIGN KEY ("debit_id") REFERENCES "debits" (id),
    CONSTRAINT "SUBJECT_SUB_ID_FK" FOREIGN KEY ("account_id") REFERENCES "accounts" (account_id)
);