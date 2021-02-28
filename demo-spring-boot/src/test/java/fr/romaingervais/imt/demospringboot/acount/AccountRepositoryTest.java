package fr.romaingervais.imt.demospringboot.acount;

import fr.romaingervais.imt.demospringboot.account.Account;
import fr.romaingervais.imt.demospringboot.account.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static fr.romaingervais.imt.demospringboot.utils.ListUtils.asList;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void test_database_is_created_with_2_accounts() {
        assertEquals(2, asList(accountRepository.findAll()).size());
    }

    @Test
    void test_credit_account() {
        // ACT
        accountRepository.creditAccount(100.0, "rgervais");

        // ASSERT
        Optional<Account> romainsAccount = accountRepository.findById("rgervais");
        assertTrue(romainsAccount.isPresent());
        assertEquals(200.0, romainsAccount.get().getTotal());
    }

    @Test
    void test_debit_account() {
        // ACT
        accountRepository.debitAccount(100.0, "rgervais");

        // ASSERT
        Optional<Account> romainsAccount = accountRepository.findById("rgervais");
        assertTrue(romainsAccount.isPresent());
        assertEquals(0.0, romainsAccount.get().getTotal());
    }
}
