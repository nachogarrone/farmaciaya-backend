package com.farmaciaya.repositories;

import com.farmaciaya.entities.Medicamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by nachogarrone on 12/10/15.
 */
public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {
    Page<Medicamento> findAll(Pageable pageable);

    @Query("SELECT m from Medicamento m where m.nombre like :nombre")
    List<Medicamento> findByNombre(@Param("nombre") String nombre);
}
