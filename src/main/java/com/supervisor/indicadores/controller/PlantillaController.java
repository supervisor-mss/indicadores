package com.supervisor.indicadores.controller;

import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.entity.Plantilla;
import com.supervisor.indicadores.repository.IPlantillaRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantillas")
public class PlantillaController {

    @Autowired
    private IPlantillaRepository plantillaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Plantilla> getAllPlantillas(){
        return plantillaRepository.findAll();
    }

    @GetMapping("/partidas")
    @ResponseStatus(HttpStatus.OK)
    public List<Party> getAllParties() { return plantillaRepository.findDistinctParties(); }

    @PostMapping("/devices")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getDevicesForParty(@RequestBody Party party ) {return plantillaRepository.findDistinctDevices(party.party_number); }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createPlantilla(@Valid @RequestBody Plantilla plantilla){
        plantillaRepository.save(plantilla);
    }
}
