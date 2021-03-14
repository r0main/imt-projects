package fr.romaingervais.imt.demospringboot.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void test_database_is_created_with_2_accounts() {
        Iterable<Account> all = accountRepository.findAll();
        assertThat(all).hasSize(2);
    }

    @Test
    void test_credit_account() {
        // ACT
        accountRepository.creditAccount(100.0, "rgervais");

        // ASSERT
        Optional<Account> romainsAccount = accountRepository.findById("rgervais");
        assertThat(romainsAccount).isPresent();
        assertThat(romainsAccount.get().getTotal()).isEqualTo(200.0);
    }

    @Test
    void test_debit_account() {
        // ACT
        accountRepository.debitAccount(100.0, "rgervais");

        // ASSERT
        Optional<Account> romainsAccount = accountRepository.findById("rgervais");
        assertThat(romainsAccount).isPresent();
        assertThat(romainsAccount.get().getTotal()).isZero();
    }

    @Test
    void test_find_greater_than_returning_multiple_accounts() {
        List<Account> result = accountRepository.findByTotalGreaterThanEqualOrderByTotalDesc(100.0);
        assertThat(result)
                .extracting("accountId")
                .containsOnly("rgervais", "imt-nantes");
    }

    @Test
    void test_find_greater_than_returning_only_one_account() {
        List<Account> result = accountRepository.findByTotalGreaterThanEqualOrderByTotalDesc(1000.0);
        assertThat(result)
                .extracting("accountId")
                .containsOnly("imt-nantes");
    }

    @Test
    void test_update_account() {
        // ACT
        Optional<Account> optionalAccount = accountRepository.findById("rgervais");
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setTotal(0);
            accountRepository.save(account); // déclenche un UPDATE car isNew() retourne false
        }

        // ASSERT
        Optional<Account> romainsAccount = accountRepository.findById("rgervais");
        assertThat(romainsAccount).isPresent();
        assertThat(romainsAccount.get().getTotal()).isZero();
    }

    @Test
    void test_create_new_account() {
        // ACT
        Account account = new Account();
        account.setNew(true);
        account.setAccountId("tledoux");
        account.setTotal(1000);
        accountRepository.save(account); // déclenche un INSERT car isNew() retourne true

        // ASSERT
        Optional<Account> thomasLedoux = accountRepository.findById("tledoux");
        assertThat(thomasLedoux).isPresent();
        assertThat(thomasLedoux.get().getTotal()).isEqualTo(1000);
    }
}
