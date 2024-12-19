package com.example.dda.Service;

import com.example.dda.Entity.Tarea;

import java.util.List;

public interface ITareaService {
    List<Tarea> obtenerTodas();
    Tarea guardar(Tarea user);
    Tarea completarTarea(Long id);
    Tarea obtenerTarea(Long id);
}
