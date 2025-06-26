package ma.elom.ebankingback.repositories;

import ma.elom.ebankingback.entities.AccountOperation;
import ma.elom.ebankingback.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
