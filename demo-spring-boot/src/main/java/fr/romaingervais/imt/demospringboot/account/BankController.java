package fr.romaingervais.imt.demospringboot.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/transfert-money")
    public TransfertMoneyResponse transfertMoney(@RequestBody TransfertMoneyRequest request) {
        bankService.transferMoney(request.getAccountIdFrom(), request.getAccountIdTo(), request.getAmount());
        return TransfertMoneyResponse.ok();
    }
}
