package com.tcs.iou.respositories;

import com.tcs.iou.entities.login.ItemSales;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 26HW011447-PC on 5/21/2017.
 */
public interface SalesItemRepository extends CrudRepository<ItemSales,Long> {
}
