package fr.romaingervais.imt.demospringboot.account;

/**
 * Classe contenat toutes les données nécessaires pour réaliser un transfert d'argent entre deux comptes
 */
public class TransfertMoneyRequest {

    private String accountIdFrom;
    private String accountIdTo;
    private double amount;

    public TransfertMoneyRequest() {
    }

    public TransfertMoneyRequest(String accountIdFrom, String accountIdTo, double amount) {
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
        this.amount = amount;
    }

    public String getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(String accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public String getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(String accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
