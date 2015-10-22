package com.farmaciaya.repositories;

import com.farmaciaya.entities.Compra;
import com.farmaciaya.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nachogarrone on 20/10/15.
 */
public interface CompraRepository extends CrudRepository<Compra, Integer> {

    List<Compra> findByUser(User user);
}
