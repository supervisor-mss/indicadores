package com.supervisor.indicadores.repository;

import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.entity.Plantilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPlantillaRepository extends JpaRepository<Plantilla, String> {

    @Query("select distinct new com.supervisor.indicadores.dtos.Party(party_number, party_desc) from Plantilla p")
    List<Party> findDistinctParties();

    @Query("select distinct p.device from Plantilla p where p.party_number = ?1")
    List<String> findDistinctDevices(String party);

    @Query("select distinct p.ticket_description from Plantilla p where p.device = ?1 and p.activity_type = ?2")
    List<String> findDistinctTiketDescription(String device, String activity_type);

    @Query("select p.tech_description from Plantilla p where p.ticket_description = ?1 and p.device = ?2")
    List<String> findByTicketDescription(String ticket_description, String device);

}
