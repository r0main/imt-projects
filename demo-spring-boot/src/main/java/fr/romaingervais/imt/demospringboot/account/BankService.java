package fr.romaingervais.imt.demospringboot.account;

import fr.romaingervais.imt.demospringboot.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private AccountRepository accountRepository;

    @Autowired
    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(String accountIdFrom, String accountIdTo, double amount) throws SQLException {
        System.out.println("begin - tranfert money");
        try {
            accountRepository.debitAccount(amount,accountIdFrom);
            accountRepository.creditAccount(amount, accountIdTo);
        } finally {
            System.out.println("end - tranfert money");
        }
    }


    public Optional<Account> findAccountById(String id) {
        return accountRepository.findById(id);
    }

    public List<Account> findAllAccounts() {
        return ListUtils.asList(accountRepository.findAll());
    }
}
