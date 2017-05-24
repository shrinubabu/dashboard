package com.tcs.iou.respositories;

import com.tcs.iou.entities.login.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 26HW011447-PC on 5/19/2017.
 */
public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
}
