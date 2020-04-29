package com.incretio.creditmanager.repository;

import com.incretio.creditmanager.entity.Credit;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockMock {

    private List<Credit> creditList;

    @PostConstruct
    public void init() {
        creditList = new ArrayList<>();
        creditList.add(
            new Credit(1, "credit1")
                .setObjectPrice(3000)
                .setFirstPayment(800)
                .setPayoutPeriodMonths(180)
                .setStartCreditRate(0.11)
                .setStartDate(LocalDate.of(2016, 10, 5)));
        creditList.add(
            new Credit(2, "credit2")
                .setObjectPrice(4000)
                .setFirstPayment(900)
                .setPayoutPeriodMonths(190)
                .setStartCreditRate(0.10)
                .setStartDate(LocalDate.of(2018, 10, 5)));
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
