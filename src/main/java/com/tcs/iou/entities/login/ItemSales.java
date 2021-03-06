package com.tcs.iou.entities.login;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by 26HW011447-PC on 5/21/2017.
 */

public class ItemSales {
    @Id
    private long id;

    private String itemName;

    private String salesCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(String salesCount) {
        this.salesCount = salesCount;
    }
}
