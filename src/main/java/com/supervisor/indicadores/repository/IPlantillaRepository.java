package com.supervisor.indicadores.repository;

import com.supervisor.indicadores.entity.Plantilla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlantillaRepository extends JpaRepository<Plantilla, String> {
}
