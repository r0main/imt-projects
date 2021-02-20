package fr.romaingervais.imt.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class BankServiceSpringJdbcTemplate {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BankServiceSpringJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(rollbackFor = Exception.class)
    public void transfertMoney(String accountIdFrom, String accountIdTo, double amount) throws SQLException {
        System.out.println("begin - tranfert money");
        try {
            jdbcTemplate.update("update accounts set total = (total - ?) where accountId = ?", amount, accountIdFrom);
//            if (true)
//                throw new SQLException("juste for the demo");
            jdbcTemplate.update("update accounts set total = (total + ?) where accountId = ?", amount, accountIdTo);
        } finally {
            System.out.println("end - tranfert money");
        }
    }

    public void showAccounts() {
        List<Account> allAccounts = findAllAccounts();
        for (Account account : allAccounts) {
            System.out.println(account.getAccountId() + " = " + account.getTotal());
        }
    }

    public List<Account> findAllAccounts() {
        return jdbcTemplate.query("select * from accounts", (resultSet, rowNum) -> {
            String accountId = resultSet.getString("accountId");
            double total = resultSet.getDouble("total");
            return new Account(accountId, total);
        });
    }
}
