package com.RentBikApp.RentBik.DataLoader;

import com.RentBikApp.RentBik.Model.Account;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Repository.AccountRepository;
import com.RentBikApp.RentBik.Repository.GplxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final GplxRepository gplxRepository;

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
            Gplx gplxA1 = new Gplx();
            gplxA1.setRank("A1");
            gplxRepository.save(gplxA1);

            Gplx gplxA2 = new Gplx();
            gplxA2.setRank("A2");
            gplxRepository.save(gplxA2);

            Gplx gplxA3 = new Gplx();
            gplxA3.setRank("A3");
            gplxRepository.save(gplxA3);

            Gplx gplxA4 = new Gplx();
            gplxA4.setRank("A4");
            gplxRepository.save(gplxA4);

            Gplx gplxB1 = new Gplx();
            gplxB1.setRank("B1");
            gplxRepository.save(gplxB1);

            Gplx gplxB2 = new Gplx();
            gplxB2.setRank("B2");
            gplxRepository.save(gplxB2);

            Gplx gplxC = new Gplx();
            gplxC.setRank("C");
            gplxRepository.save(gplxC);

            Gplx gplxD = new Gplx();
            gplxD.setRank("D");
            gplxRepository.save(gplxD);

            Gplx gplxE = new Gplx();
            gplxE.setRank("E");
            gplxRepository.save(gplxE);

            Gplx gplxF = new Gplx();
            gplxF.setRank("F");
            gplxRepository.save(gplxF);
        }
    }
}
