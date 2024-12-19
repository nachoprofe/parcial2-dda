package com.example.dda.Service;

import com.example.dda.Entity.Tarea;
import com.example.dda.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    public Tarea guardar(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea completarTarea(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("RuntimeException"));
        tarea.setCompletada(true);
        return tareaRepository.save(tarea);
    }

    public Tarea obtenerTarea(Long id){
        return tareaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró la tarea."));
    }
}
