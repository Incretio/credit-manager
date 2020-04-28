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
        creditList.add(new Credit("credit1"));
        creditList.add(new Credit("credit2"));
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

}
