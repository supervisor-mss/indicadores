package com.supervisor.indicadores.controller;

import com.supervisor.indicadores.entity.Plantilla;
import com.supervisor.indicadores.repository.IPlantillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createPlantilla(@RequestBody Plantilla plantilla){
        plantillaRepository.save(plantilla);
    }
}
