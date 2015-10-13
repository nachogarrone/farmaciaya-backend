package com.farmaciaya.repositories;

import com.farmaciaya.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nachogarrone on 11/10/15.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    User findByToken(String token);
}
