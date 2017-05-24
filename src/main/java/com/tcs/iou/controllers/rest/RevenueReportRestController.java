package com.tcs.iou.controllers.rest;

import com.tcs.iou.entities.reports.RevenueByQuarterByAccountLocationName;
import com.tcs.iou.entities.reports.RevenueByQuarterByHorizontal;
import com.tcs.iou.entities.reports.RevenueByQuarterBySP;
import com.tcs.iou.entities.reports.RevenueByQuarterCount;
import com.tcs.iou.respositories.RevenueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 26HW011447-PC on 5/21/2017.
 */
@RestController
public class RevenueReportRestController {
    @Autowired
    private RevenueReportRepository revenueReportRepository;

    @RequestMapping("/getRevenueByQuarter")
    public Iterable<RevenueByQuarterCount> getSalesData(){
        return revenueReportRepository.getRevenueByQuarter();
    }

    @RequestMapping("/getRevenueByQuarterBySP")
    public Iterable<RevenueByQuarterBySP> getRevenueByQuarterBySP(@RequestParam String quarter){
        return revenueReportRepository.getRevenueByQuarterBySP(quarter);
    }

    @RequestMapping("/getRevenueByQuarterByHorizontal")
    public Iterable<RevenueByQuarterByHorizontal> getRevenueByQuarterByHorizontal(@RequestParam String quarter){
        return revenueReportRepository.getRevenuByQuarterByHorizontal(quarter);
    }
    @RequestMapping("/getRevenueByQuarterByAccountLocationName")
    public Iterable<RevenueByQuarterByAccountLocationName> getRevenueByQuarterByAccountLocationName(@RequestParam String quarter){
        return revenueReportRepository.getRevenueByQuarterByAccountLocationName(quarter);
    }
}
