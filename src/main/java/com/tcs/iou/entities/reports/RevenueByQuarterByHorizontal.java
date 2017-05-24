package com.tcs.iou.entities.reports;

import org.springframework.data.annotation.Id;

/**
 * Created by 26HW011447-PC on 5/24/2017.
 */
public class RevenueByQuarterByHorizontal {
    @Id
    private String serviceLine;
    private Double sumAmountUSDBEACON;

    public String getServiceLine() {
        return serviceLine;
    }

    public void setServiceLine(String serviceLine) {
        this.serviceLine = serviceLine;
    }

    public Double getSumAmountUSDBEACON() {
        return sumAmountUSDBEACON;
    }

    public void setSumAmountUSDBEACON(Double sumAmountUSDBEACON) {
        this.sumAmountUSDBEACON = sumAmountUSDBEACON;
    }
}
