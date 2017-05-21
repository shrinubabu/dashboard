package com.tcs.iou.entities.login;

import javax.persistence.*;

/**
 * Created by 26HW011447-PC on 5/21/2017.
 */
@Entity(name = "item_sales")
public class ItemSales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "sales_count")
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
