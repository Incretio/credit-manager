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
        return creditRepository.getAllCredits();
    }

    public Credit getByUid(long uid) {
        return creditRepository.getByUid(uid);
    }

    public Credit addAndGetCredit(String creditName) {
        return creditRepository.addAndGetCredit(creditName);
    }

    public void deleteByUid(Long uid) {
        creditRepository.deleteByUid(uid);
    }
}
