package demo.paypal.idp.controller;

import com.azure.cosmos.models.PartitionKey;
import demo.paypal.idp.model.Accounts;
import demo.paypal.idp.repository.AccountsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    final private AccountsRepository accountsRepository;
    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    public AccountsController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @GetMapping("/{id}")
    public Accounts find(@PathVariable String id) {
        logger.info("Received request to get account for id {}", id);
        return accountsRepository.findById(id, new PartitionKey(id)).get();
    }

    @GetMapping
    public List<Accounts> findAll() {
        logger.info("Received request to get all accounts");
        List<Accounts> accountsList = new ArrayList<>();
        accountsRepository.findAll().forEach(accountsList::add);
        return accountsList;
    }

    @PostMapping
    public Accounts create(@RequestBody Accounts account) {
        logger.info("Received request to create a new account");
        return accountsRepository.save(account);
    }

    @PutMapping("/{id}")
    public Accounts update(@PathVariable String id, @RequestBody Accounts account) {
        logger.info("Received request to upsert account with id {}", id);
        account.setAccountId(id);
        return accountsRepository.save(account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        logger.info("Received request to delete account with id {}", id);
        accountsRepository.deleteById(id, new PartitionKey(id));
    }
}
