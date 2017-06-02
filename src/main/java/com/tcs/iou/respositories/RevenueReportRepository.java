package com.tcs.iou.respositories;

import com.tcs.iou.entities.reports.RevenueByQuarterByAccountLocationName;
import com.tcs.iou.entities.reports.RevenueByQuarterByHorizontal;
import com.tcs.iou.entities.reports.RevenueByQuarterBySP;
import com.tcs.iou.entities.reports.RevenueByQuarterCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Shrinubabu on 5/23/2017.
 */
@Repository
public class RevenueReportRepository  {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<RevenueByQuarterCount> getRevenueByQuarter() {

        Aggregation agg = newAggregation(
                group("quarter").sum("amountUSDBEACON").as("sumAmountUSDBEACON"),sort(ASC, previousOperation(), "sumAmountUSDBEACON"));

        //Convert the aggregation result into a List
        AggregationResults<RevenueByQuarterCount> groupResults
                = mongoTemplate.aggregate(agg, "revenue", RevenueByQuarterCount.class);
        List<RevenueByQuarterCount> result = groupResults.getMappedResults();

        return result;
    }

    public List<RevenueByQuarterBySP> getRevenueByQuarterBySP(String quarter){

        Aggregation agg;
        if(quarter.equalsIgnoreCase("all")){
            agg = newAggregation(
                    group("SP").sum("amountUSDBEACON").as("sumAmountUSDBEACON"));

        }else{
            agg = newAggregation(match(where("quarter").is(quarter)),
                    group("SP").sum("amountUSDBEACON").as("sumAmountUSDBEACON"));

        }

        //Convert the aggregation result into a List
        AggregationResults<RevenueByQuarterBySP> groupResults
                = mongoTemplate.aggregate(agg, "revenue", RevenueByQuarterBySP.class);
        List<RevenueByQuarterBySP> result = groupResults.getMappedResults();

        return result;

    }

    public Iterable<RevenueByQuarterByHorizontal> getRevenuByQuarterByHorizontal(String quarter){
        Aggregation agg;
        if(quarter.equalsIgnoreCase("all")){
            agg = newAggregation(
                    group("serviceLine").sum("amountUSDBEACON").as("sumAmountUSDBEACON"));

        }else{
            agg = newAggregation(match(where("quarter").is(quarter)),
                    group("serviceLine").sum("amountUSDBEACON").as("sumAmountUSDBEACON"));

        }

        //Convert the aggregation result into a List
        AggregationResults<RevenueByQuarterByHorizontal> groupResults
                = mongoTemplate.aggregate(agg, "revenue", RevenueByQuarterByHorizontal.class);
        List<RevenueByQuarterByHorizontal> result = groupResults.getMappedResults();

        return result;
    }

    public Iterable<RevenueByQuarterByAccountLocationName> getRevenueByQuarterByAccountLocationName(String quarter){

        Aggregation agg;
        if(quarter.equalsIgnoreCase("all")){
            agg = newAggregation(
                    group("accountLocationName").sum("amountUSDBEACON").as("sumAmountUSDBEACON"));
        }else{
            agg = newAggregation(match(where("quarter").is(quarter)),
                    group("accountLocationName").sum("amountUSDBEACON").as("sumAmountUSDBEACON"));
        }

        //Convert the aggregation result into a List
        AggregationResults<RevenueByQuarterByAccountLocationName> groupResults
                = mongoTemplate.aggregate(agg, "revenue", RevenueByQuarterByAccountLocationName.class);
        List<RevenueByQuarterByAccountLocationName> result = groupResults.getMappedResults();

        return result;
    }
}


