package fr.romaingervais.imt.transactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        BankServiceSpring bankService = applicationContext.getBean(BankServiceSpring.class);

        bankService.showAccounts();
        try {
            bankService.transfertMoney("imt-nantes", "rgervais", 100000);
        } finally {
            bankService.showAccounts();
        }
    }


}
