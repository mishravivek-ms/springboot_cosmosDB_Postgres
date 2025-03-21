package demo.paypal.idp.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import demo.paypal.idp.model.Accounts;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CosmosRepository<Accounts, String> {
}
