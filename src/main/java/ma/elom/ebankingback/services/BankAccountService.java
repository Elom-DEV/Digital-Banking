package ma.elom.ebankingback.services;

import ma.elom.ebankingback.entities.BankAccount;
import ma.elom.ebankingback.entities.Customer;
import ma.elom.ebankingback.exeption.CustomerNotFoundExeption;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveBankAccount(double initialBalance, String types, Long custemerId) throws CustomerNotFoundExeption;
    List<Customer> listCustemer();
    BankAccount getBankAccount(String accountId);
    void debi(String accountId, double amount,String description);
    void credit(String accountId, double amount,String description);
    void transfer(String accountIdSource,String accountIdDestination,double amount);



}

