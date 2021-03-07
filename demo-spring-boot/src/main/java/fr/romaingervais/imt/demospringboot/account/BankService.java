package fr.romaingervais.imt.demospringboot.account;

import fr.romaingervais.imt.demospringboot.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankService.class);

    private AccountRepository accountRepository;

    @Autowired
    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(String accountIdFrom, String accountIdTo, double amount) {
        LOGGER.info("begin - tranfert money");
        try {
            accountRepository.debitAccount(amount,accountIdFrom);
            accountRepository.creditAccount(amount, accountIdTo);
        } finally {
            LOGGER.info("end - tranfert money");
        }
    }


    public Optional<Account> findAccountById(String id) {
        return accountRepository.findById(id);
    }

    public List<Account> findAllAccounts() {
        return ListUtils.asList(accountRepository.findAll());
    }
}
