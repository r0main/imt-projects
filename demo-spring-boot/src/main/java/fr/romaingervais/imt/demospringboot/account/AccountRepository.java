package fr.romaingervais.imt.demospringboot.account;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    @Modifying
    @Query("update \"accounts\" set total = (total - :amount) where account_id = :accountId")
    int debitAccount(@Param("amount") Double amount, @Param("accountId") String accountId);

    @Modifying
    @Query("update \"accounts\" set total = (total + :amount) where account_id = :accountId")
    int creditAccount(@Param("amount") Double amount, @Param("accountId") String accountId);

    List<Account> findByTotalGreaterThanEqualOrderByTotalDesc(Double amount);
}
