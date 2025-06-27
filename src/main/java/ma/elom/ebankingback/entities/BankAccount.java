package ma.elom.ebankingback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elom.ebankingback.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",length=4)


public abstract class BankAccount {
    @Id
    private String id;
    private  double balance;
    private Date createdAt;
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;
}
