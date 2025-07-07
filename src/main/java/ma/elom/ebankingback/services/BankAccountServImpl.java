package ma.elom.ebankingback.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.elom.ebankingback.entities.BankAccount;
import ma.elom.ebankingback.entities.CurrentAccount;
import ma.elom.ebankingback.entities.Customer;
import ma.elom.ebankingback.entities.SavingAccount;
import ma.elom.ebankingback.exeption.CustomerNotFoundExeption;
import ma.elom.ebankingback.repositories.AccountOperationRepository;
import ma.elom.ebankingback.repositories.BankAccountRepository;
import ma.elom.ebankingback.repositories.CustomerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
@Slf4j

public class BankAccountServImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private CustomerRepository customerRepository;
    private AccountOperationRepository accountOperationRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new Customer");
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String types, Long custemerId) throws CustomerNotFoundExeption {
        Customer customer=customerRepository.findById(custemerId).orElse(null);
        if (customer == null)
            throw new CustomerNotFoundExeption ("Customer not found");
        BankAccount bankAccount;
        if(types.equals("current")){
            bankAccount=new CurrentAccount();
        }else {
            bankAccount=new SavingAccount();
        }
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setBalance(initialBalance);


        return null;
    }

    @Override
    public List<Customer> listCustemer() {
        return List.of();
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debi(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {

    }
}
