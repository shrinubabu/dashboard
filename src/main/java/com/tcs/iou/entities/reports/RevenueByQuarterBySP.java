package com.tcs.iou.entities.reports;


import org.springframework.data.annotation.Id;

/**
 * Created by 26HW011447-PC on 5/24/2017.
 */
public class RevenueByQuarterBySP {
    @Id
    private String SP;
    private Double sumAmountUSDBEACON;

    public String getSP() {
        return SP;
    }

    public void setSP(String SP) {
        this.SP = SP;
    }

    public Double getSumAmountUSDBEACON() {
        return sumAmountUSDBEACON;
    }

    public void setSumAmountUSDBEACON(Double sumAmountUSDBEACON) {
        this.sumAmountUSDBEACON = sumAmountUSDBEACON;
    }
}
