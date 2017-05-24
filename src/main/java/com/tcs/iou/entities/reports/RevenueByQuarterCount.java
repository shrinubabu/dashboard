package com.tcs.iou.entities.reports;

import org.springframework.data.annotation.Id;

/**
 * Created by 26HW011447-PC on 5/23/2017.
 */
public class RevenueByQuarterCount {
    @Id
    private String quarter;
    private Double sumAmountUSDBEACON;

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Double getSumAmountUSDBEACON() {
        return sumAmountUSDBEACON;
    }

    public void setSumAmountUSDBEACON(Double sumAmountUSDBEACON) {
        this.sumAmountUSDBEACON = sumAmountUSDBEACON;
    }
}
