package ma.elom.ebankingback;

import ma.elom.ebankingback.entities.AccountOperation;
import ma.elom.ebankingback.entities.CurrentAccount;
import ma.elom.ebankingback.entities.Customer;
import ma.elom.ebankingback.entities.SavingAccount;
import ma.elom.ebankingback.enums.AccountStatus;
import ma.elom.ebankingback.enums.OperationType;
import ma.elom.ebankingback.repositories.AccountOperationRepository;
import ma.elom.ebankingback.repositories.BankAccountRepository;
import ma.elom.ebankingback.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackApplication.class, args);
    }
    @Bean
        CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository,
                                AccountOperationRepository accountOperationRepository) {
            return args ->{
                Stream.of("Hassan","Yassine","Aicha").forEach(name -> {
                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setEmail(name + "@gmail.com");
                    customerRepository.save(customer);
                });
                customerRepository.findAll().forEach(cust->{
                    CurrentAccount currentAccount = new CurrentAccount();
                    currentAccount.setId(UUID.randomUUID().toString());
                    currentAccount.setBalance(Math.random()*90000);
                    currentAccount.setCreatedAt(new Date());
                    currentAccount.setStatus(AccountStatus.CREATED);
                    currentAccount.setCustomer(cust);
                    currentAccount.setOverdraft(9000);
                    bankAccountRepository.save(currentAccount);

                    SavingAccount savingAccount = new SavingAccount();
                    savingAccount.setId(UUID.randomUUID().toString());
                    savingAccount.setBalance(Math.random()*90000);
                    savingAccount.setCreatedAt(new Date());
                    savingAccount.setStatus(AccountStatus.CREATED);
                    savingAccount.setCustomer(cust);
                    savingAccount.setInterestRate(5.5);
                    bankAccountRepository.save(savingAccount);
                });
                bankAccountRepository.findAll().forEach(acc->{
                    for (int i=0;i<10 ; i++){
                        AccountOperation accountOperation = new AccountOperation();
                        accountOperation.setOperationDate(new Date());
                        accountOperation.setAmount(Math.random()*12000);
                        accountOperation.setType(Math.random()>0.5? OperationType.DEBIT : OperationType.CREDIT);
                        accountOperation.setBankAccount(acc);
                        accountOperationRepository.save(accountOperation);
                    }
                });

            };

    }

}
