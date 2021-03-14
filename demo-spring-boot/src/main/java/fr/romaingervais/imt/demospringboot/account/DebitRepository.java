package fr.romaingervais.imt.demospringboot.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends CrudRepository<Debit, Long> {
}
