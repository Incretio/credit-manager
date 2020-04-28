package com.incretio.creditmanager.repository;

import com.incretio.creditmanager.entity.Credit;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockMock {

    private List<Credit> creditList;

    @PostConstruct
    public void init() {
        creditList = new ArrayList<>();
        creditList.add(new Credit(1, "credit1"));
        creditList.add(new Credit(2, "credit2"));
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public Credit createCredit(String creditName) {
        Credit credit = new Credit(creditList.size() + 1, creditName);
        creditList.add(credit);
        return credit;
    }

}
