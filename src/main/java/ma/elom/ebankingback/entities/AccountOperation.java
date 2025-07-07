package ma.elom.ebankingback.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.elom.ebankingback.enums.OperationType;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private Double amount;
    private OperationType type;
    private String description;
    @ManyToOne
    private BankAccount bankAccount;
}
