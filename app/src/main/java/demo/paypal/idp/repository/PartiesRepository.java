package demo.paypal.idp.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import demo.paypal.idp.model.Parties;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiesRepository extends CosmosRepository<Parties, String> {
}
