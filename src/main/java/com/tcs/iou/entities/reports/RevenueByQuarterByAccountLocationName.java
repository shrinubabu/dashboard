package com.tcs.iou.entities.reports;

import org.springframework.data.annotation.Id;

/**
 * Created by 26HW011447-PC on 5/24/2017.
 */
public class RevenueByQuarterByAccountLocationName {
    @Id
    private String accountLocationName;
    private Double sumAmountUSDBEACON;

    public String getAccountLocationName() {
        return accountLocationName;
    }

    public void setAccountLocationName(String accountLocationName) {
        this.accountLocationName = accountLocationName;
    }

    public Double getSumAmountUSDBEACON() {
        return sumAmountUSDBEACON;
    }

    public void setSumAmountUSDBEACON(Double sumAmountUSDBEACON) {
        this.sumAmountUSDBEACON = sumAmountUSDBEACON;
    }
}
