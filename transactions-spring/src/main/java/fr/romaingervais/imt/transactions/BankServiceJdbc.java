package fr.romaingervais.imt.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

@Service
public class BankServiceJdbc {

    private DataSource dataSource;

    @Autowired
    public BankServiceJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void transfertMoney(String accountIdFrom, String accountIdTo, double amount) throws SQLException {
        System.out.println("begin - tranfert money");
        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);

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

                con.commit();
            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (SQLException sqlException) {
                    // print or rethrow exception ?
                    sqlException.printStackTrace();
                }
                // print or rethrow exception ?
                e.printStackTrace();
            }
        } finally {
            System.out.println("end - tranfert money");
        }
    }

    public void showAccounts() throws SQLException {
        try (Connection con = dataSource.getConnection()) {
            String sql = "select * from accounts";
            try (PreparedStatement selectAllFromAccounts = con.prepareStatement(sql)) {
                try (ResultSet resultSet = selectAllFromAccounts.executeQuery()) {
                    while (resultSet.next()) {
                        String accountId = resultSet.getString("accountId");
                        double amount = resultSet.getDouble("total");
                        System.out.println(accountId + " = " + amount);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
