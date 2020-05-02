package com.incretio.creditmanager.business;

import com.incretio.creditmanager.entity.Credit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CreditCalculate {

    private final Credit credit;

    public CreditCalculate(Credit credit) {
        this.credit = credit;
    }

    // Сумма кредита
    public double getCreditAmount() {
        return credit.getObjectPrice() - credit.getFirstPayment();
    }

    // Ежемесячный платёж
    public double getMonthlyPayment() {
        return getMonthlyPayment(getCreditAmount(), 1);
    }

    // Общая сумма платежа
    public double getTotalAmountPayment() {
        return getMonthlyPayment() * ((double) credit.getPayoutPeriodMonths());
    }

    // Сумма переплаты
    public double getOverpaymentAmount() {
        return getTotalAmountPayment() - getCreditAmount();
    }

    // Дата закрытия кредита
    public LocalDate getStopDateCredit() {
        return credit.getStartDate().plus(credit.getPayoutPeriodMonths(), ChronoUnit.MONTHS);
    }

    private double getMonthlyPayment(double principalBanalce, int monthNumber) {
        return (getMonthCreditRate() * principalBanalce) / (1.0d - Math.pow(getMonthCreditRate() + 1.0d, (-((credit.getPayoutPeriodMonths() - monthNumber) + 1))));
    }

    // Ставка в месяц
    private double getMonthCreditRate() {
        return credit.getStartCreditRate() / 1200.0d;
    }

}
