package com.supervisor.indicadores.controller;

import com.supervisor.indicadores.entity.Ubicacion;
import com.supervisor.indicadores.repository.IUbicacionRepository;
import com.supervisor.indicadores.services.UbicacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
@RequiredArgsConstructor
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @Autowired
    private IUbicacionRepository ubicacionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ubicacion> getAllUbicaciones(){
        return ubicacionRepository.findAll();
    }

    @GetMapping("/areas_conocidas")
    public List<String> getAllAreasConocidas(){
        return ubicacionRepository.findDistinctAreasConocidas();
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Integer> uploadUbicaciones(
            @RequestPart("file") MultipartFile file) throws IOException{
                return ResponseEntity.ok(ubicacionService.uploadUbicaciones(file));
    }

}
