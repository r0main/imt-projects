package fr.romaingervais.imt.demospringboot.acount;

import fr.romaingervais.imt.demospringboot.account.Account;
import fr.romaingervais.imt.demospringboot.account.BankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Transactional
public class BankServiceTest {

    @Autowired
    BankService bankService;

    @Test
    void test_transferMoney_with_all_money_from_account() throws SQLException {
        // Act
        bankService.transferMoney("imt-nantes", "rgervais", 100000);

        // Assert
        Account imtAccount = bankService.findAccountById("imt-nantes").get();
        Account romainAccount = bankService.findAccountById("rgervais").get();

        Assertions.assertEquals(0, imtAccount.getTotal());
        Assertions.assertEquals(100100, romainAccount.getTotal());
    }

    @Test
    void test_transferMoney_with_more_money_than_account_total() throws SQLException {
        // Act
        bankService.transferMoney("imt-nantes", "rgervais", 200000);

        // Assert
        Account imtAccount = bankService.findAccountById("imt-nantes").get();
        Account romainAccount = bankService.findAccountById("rgervais").get();

        Assertions.assertEquals(-100000, imtAccount.getTotal());
        Assertions.assertEquals(200100, romainAccount.getTotal());
    }
}
