package com.example.dda.Controller;

import com.example.dda.Entity.Tarea;
import com.example.dda.Service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private ITareaService tareaService;

    @GetMapping
    public List<Tarea> listarTareas() {
        return tareaService.obtenerTodas();
    }

    @PostMapping
    public String agregarTarea(@RequestBody Tarea tarea) {
        tareaService.guardar(tarea);
        return "Tarea agregada con éxito.";
    }

    @PutMapping("/{id}/completar")
    public String completarTarea(@PathVariable Long id) {
        Tarea tarea = tareaService.completarTarea(id);
        tarea.setCompletada(true);
        tareaService.guardar(tarea);
        return "Tarea completada.";
    }

    @GetMapping("/{id}")
    public Tarea obtenerTarea(@PathVariable Long id) {
        return tareaService.obtenerTarea(id);
    }
}
