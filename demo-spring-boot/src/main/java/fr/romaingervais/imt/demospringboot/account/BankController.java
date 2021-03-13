package fr.romaingervais.imt.demospringboot.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> findAllAccounts() {
        List<Account> accounts = bankService.findAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> findAccountById(@PathVariable("accountId") String accountId) {
        Optional<Account> accountById = bankService.findAccountById(accountId);
        if (accountById.isPresent()) {
            return ResponseEntity.ok(accountById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/transfert-money")
    public ResponseEntity<TransfertMoneyResponse> transfertMoney(@RequestBody TransfertMoneyRequest request) {
        bankService.transferMoney(request.getAccountIdFrom(), request.getAccountIdTo(), request.getAmount());
        return ResponseEntity.ok(TransfertMoneyResponse.ok());
    }
}
