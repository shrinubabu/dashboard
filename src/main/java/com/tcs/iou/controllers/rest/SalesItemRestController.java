package com.tcs.iou.controllers.rest;

import com.tcs.iou.entities.login.ItemSales;
import com.tcs.iou.respositories.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 26HW011447-PC on 5/21/2017.
 */
@RestController
public class SalesItemRestController {
    @Autowired
    private SalesItemRepository salesItemRepository;

    @RequestMapping("/getSalesData")
    public Iterable<ItemSales> getSalesData(){
        return salesItemRepository.findAll();
    }

}
