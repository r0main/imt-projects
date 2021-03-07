package fr.romaingervais.imt.demospringboot.account;

/**
 * Réponse à une demande de transfert d'argent
 */
public class TransfertMoneyResponse {

    /**
     * "OK" en cas de succès, null ou "KO" en cas d'erreur
     */
    private String result;

    public TransfertMoneyResponse() {
    }

    public TransfertMoneyResponse(String result) {
        this.result = result;
    }

    public static TransfertMoneyResponse ok(){
        return new TransfertMoneyResponse("OK");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
