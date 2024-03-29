package fr.romaingervais.imt.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceSpring {

    private DataSource dataSource;

    @Autowired
    public BankServiceSpring(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(String accountIdFrom, String accountIdTo, double amount) throws SQLException {
        System.out.println("begin - tranfert money");

        try {
            // pour bien récupérer la même connexion que le transactionManager et pas une nouvelle connexion
            Connection con = DataSourceUtils.getConnection(dataSource);
            // pas besoin de mettre autocommit à false, le transctionManager s'en occupe

            String updateAccountFromSql = "update accounts set total = (total - ?) where accountId = ?";
            String updateAccountToSql = "update accounts set total = (total + ?) where accountId = ?";
            try (PreparedStatement updateAccountFrom = con.prepareStatement(updateAccountFromSql);
                 PreparedStatement updateAccountTo = con.prepareStatement(updateAccountToSql)) {
                updateAccountFrom.setDouble(1, amount);
                updateAccountFrom.setString(2, accountIdFrom);
                updateAccountFrom.executeUpdate();

//                if(true)
//                    throw new SQLException("juste for the demo");

                updateAccountTo.setDouble(1, amount);
                updateAccountTo.setString(2, accountIdTo);
                updateAccountTo.executeUpdate();
            }
        } finally {
            System.out.println("end - tranfert money");
        }
    }

    public void showAccounts() throws SQLException {
        List<Account> allAccounts = findAllAccounts();
        for (Account account : allAccounts) {
            System.out.println(account.getAccountId() + " = " + account.getTotal());
        }
    }

    public List<Account> findAllAccounts() throws SQLException {
        List<Account> allAccounts = new ArrayList<>();
        try (Connection con = dataSource.getConnection()) {
            String sql = "select * from accounts";
            try (PreparedStatement selectAllFromAccounts = con.prepareStatement(sql)) {
                try (ResultSet resultSet = selectAllFromAccounts.executeQuery()) {
                    while (resultSet.next()) {
                        String accountId = resultSet.getString("accountId");
                        double total = resultSet.getDouble("total");
                        allAccounts.add(new Account(accountId, total));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allAccounts;
    }
}
