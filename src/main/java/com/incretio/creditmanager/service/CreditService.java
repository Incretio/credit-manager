package com.incretio.creditmanager.service;

import com.incretio.creditmanager.entity.Credit;
import com.incretio.creditmanager.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    private CreditRepository creditRepository;

    @Autowired
    public void setCreditRepository(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit findById(long id) {
        return creditRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Credit did not find"));
    }

    public void deleteById(Long id) {
        creditRepository.deleteById(id);
    }

    public Credit saveCredit(String creditName) {
        Credit credit = new Credit(creditName);
        System.out.println(credit);
        credit = creditRepository.save(new Credit(creditName));
        System.out.println(credit);
        return credit;
    }

    public Credit saveCredit(Credit credit) {

        Credit credit1 = creditRepository.save(credit);
        System.out.println(credit1);
        return credit1;
    }
}
