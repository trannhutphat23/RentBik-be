package com.RentBikApp.RentBik.DataLoader;

import com.RentBikApp.RentBik.Model.Account;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Repository.AccountRepository;
import com.RentBikApp.RentBik.Repository.GplxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final GplxRepository gplxRepository;
    private List<String> gplxs = List.of("A1", "A2", "A3", "A4", "B1", "B2", "C", "D", "E", "F");

    @Autowired
    public DataLoader(AccountRepository accountRepository, GplxRepository gplxRepository) {
        this.accountRepository = accountRepository;
        this.gplxRepository = gplxRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (accountRepository.count() == 0) {
            Account defaultAccount = new Account();
            defaultAccount.setPassword("admin");
            accountRepository.save(defaultAccount);
        }

        if (gplxRepository.count() == 0){
            for (String item : gplxs){
                Gplx gplx = new Gplx();
                gplx.setRank(item);
                gplxRepository.save(gplx);
            }
        }
    }
}
