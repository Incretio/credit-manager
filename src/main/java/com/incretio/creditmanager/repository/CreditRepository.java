package com.incretio.creditmanager.repository;

import com.incretio.creditmanager.entity.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreditRepository {

    private StockMock stockMock;

    @Autowired
    public void setCreditList(StockMock stockMock) {
        this.stockMock = stockMock;
    }

    public List<Credit> getAllCredits() {
        return new ArrayList<>(stockMock.getCreditList());
    }

    public Credit getByUid(long uid) {
        return stockMock.getCreditList().stream()
                        .filter(credit -> credit.getUid() == uid)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Credit did not find"));
    }

    public Credit addAndGetCredit(String creditName) {
        return stockMock.createCredit(creditName);
    }

    public void deleteByUid(Long uid) {
        stockMock.getCreditList().removeIf(credit -> credit.getUid() == uid);
    }
}
