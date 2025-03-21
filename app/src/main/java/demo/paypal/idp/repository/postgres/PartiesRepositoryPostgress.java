package demo.paypal.idp.repository.postgres;

import demo.paypal.idp.model.oracle.Parties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartiesRepositoryPostgress extends JpaRepository<Parties, Long> {


}
