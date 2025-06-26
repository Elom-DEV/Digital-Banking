package ma.elom.ebankingback.repositories;

import ma.elom.ebankingback.entities.BankAccount;
import ma.elom.ebankingback.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
