package com.farmaciaya.repositories;

import com.farmaciaya.entities.Farmacia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by nachogarrone on 12/10/15.
 */
public interface FarmaciaRepository extends CrudRepository<Farmacia, Integer> {
    Page<Farmacia> findAll(Pageable pageable);

    @Query("SELECT m from Farmacia m where m.nombre like :nombre")
    List<Farmacia> findByNombre(@Param("nombre") String nombre);
}
