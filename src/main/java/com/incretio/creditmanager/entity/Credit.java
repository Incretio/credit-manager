package com.incretio.creditmanager.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Table(name = "credits")
public class Credit implements Serializable {

    private static final long serialVersionUID = -4409338744735911101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "object_price")
    private Double objectPrice = 0.0;

    @Column(name = "first_payment")
    private Double firstPayment = 0.0;

    @Column(name = "start_credit_rate")
    private Double startCreditRate = 0.0;

    @Column(name = "start_date")
    private LocalDate startDate = LocalDate.now(ZoneId.of("UTC"));

    @Column(name = "payout_period_months")
    private Integer payoutPeriodMonths = 0;

    public Credit() {
        // noop
    }

    public Credit(String name) {
        this.name = name;
    }

    public Credit setId(Long id) {
        this.id = id;
        return this;
    }

    public Credit setName(String name) {
        this.name = name;
        return this;
    }

    public Credit setObjectPrice(Double objectPrice) {
        this.objectPrice = objectPrice;
        return this;
    }

    public Credit setFirstPayment(Double firstPayment) {
        this.firstPayment = firstPayment;
        return this;
    }

    public Credit setStartCreditRate(Double startCreditRate) {
        this.startCreditRate = startCreditRate;
        return this;
    }

    public Credit setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public Credit setPayoutPeriodMonths(Integer payoutPeriodMonths) {
        this.payoutPeriodMonths = payoutPeriodMonths;
        return this;
    }

    public Double getObjectPrice() {
        return objectPrice;
    }

    public Double getFirstPayment() {
        return firstPayment;
    }

    public Double getStartCreditRate() {
        return startCreditRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Integer getPayoutPeriodMonths() {
        return payoutPeriodMonths;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Credit{" + "id=" + id + ", name='" + name + '\'' + ", objectPrice=" + objectPrice + ", firstPayment="
            + firstPayment + ", startCreditRate=" + startCreditRate + ", startDate=" + startDate
            + ", payoutPeriodMonths=" + payoutPeriodMonths + '}';
    }
}
