package com.supervisor.indicadores.repository;

import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUbicacionRepository extends JpaRepository<Ubicacion, String> {

    @Query("select distinct a.area_conocida from Ubicacion a  order by a.area_conocida ASC")
    List<String> findDistinctAreasConocidas();
}
