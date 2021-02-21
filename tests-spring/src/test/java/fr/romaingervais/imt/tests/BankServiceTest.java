package fr.romaingervais.imt.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class, DatabaseTestConfig.class})
@ActiveProfiles("test")
@Transactional
public class BankServiceTest {

    @Autowired
    BankService bankService;

    @Test
    void test_database_is_created_with_2_accounts() {
        List<Account> allAccounts = bankService.findAllAccounts();
        Assertions.assertEquals(2, allAccounts.size());
    }

    @Test
    void test_transferMoney_with_all_money_from_account() throws SQLException {
        // Act
        bankService.transferMoney("imt-nantes", "rgervais", 100000);

        // Assert
        List<Account> allAccounts = bankService.findAllAccounts();
        Account imtAccount = allAccounts.get(0);
        Account romainAccount = allAccounts.get(1);

        Assertions.assertEquals(0, imtAccount.getTotal());
        Assertions.assertEquals(100100, romainAccount.getTotal());
    }

    @Test
    void test_transferMoney_with_more_money_than_account_total() throws SQLException {
        // Act
        bankService.transferMoney("imt-nantes", "rgervais", 200000);

        // Assert
        List<Account> allAccounts = bankService.findAllAccounts();
        Account imtAccount = allAccounts.get(0);
        Account romainAccount = allAccounts.get(1);

        Assertions.assertEquals(-100000, imtAccount.getTotal());
        Assertions.assertEquals(200100, romainAccount.getTotal());
    }
}
