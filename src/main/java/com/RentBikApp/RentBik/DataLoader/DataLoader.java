package com.RentBikApp.RentBik.DataLoader;

import com.RentBikApp.RentBik.Model.Account;
import com.RentBikApp.RentBik.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;

    @Autowired
    public DataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (accountRepository.count() == 0) {
            Account defaultAccount = new Account();
            defaultAccount.setPassword("admin");
            accountRepository.save(defaultAccount);
        }
    }
}
