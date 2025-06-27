package ma.elom.ebankingback.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("SA")
@Getter
@Setter

public class SavingAccount extends BankAccount {
    private double interestRate;
}
