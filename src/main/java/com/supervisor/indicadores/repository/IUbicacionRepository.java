package com.supervisor.indicadores.repository;

import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUbicacionRepository extends JpaRepository<Ubicacion, String> {

    @Query("select distinct a.area_conocida from Ubicacion a  order by a.area_conocida ASC")
    List<String> findDistinctAreasConocidas();

    @Query("select a from Ubicacion a where a.area_conocida = ?1 ")
    List<Ubicacion> findUnidadesPorAreaConocida(String area_conocida);
}
