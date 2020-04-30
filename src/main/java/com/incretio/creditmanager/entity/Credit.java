package com.incretio.creditmanager.entity;

import java.time.LocalDate;

public class Credit {

    private final long uid;
    private String name;
    private double objectPrice;
    private double firstPayment;
    private double startCreditRate;
    private LocalDate startDate = LocalDate.now();
    private int payoutPeriodMonths;

    public Credit(long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Credit setName(String name) {
        this.name = name;
        return this;
    }

    public long getUid() {
        return uid;
    }

    public Credit setObjectPrice(double objectPrice) {
        this.objectPrice = objectPrice;
        return this;
    }

    public Credit setFirstPayment(double firstPayment) {
        this.firstPayment = firstPayment;
        return this;
    }

    public Credit setStartCreditRate(double startCreditRate) {
        this.startCreditRate = startCreditRate;
        return this;
    }

    public Credit setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public Credit setPayoutPeriodMonths(int payoutPeriodMonths) {
        this.payoutPeriodMonths = payoutPeriodMonths;
        return this;
    }

    public double getObjectPrice() {
        return objectPrice;
    }

    public double getFirstPayment() {
        return firstPayment;
    }

    public double getStartCreditRate() {
        return startCreditRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getPayoutPeriodMonths() {
        return payoutPeriodMonths;
    }
}
