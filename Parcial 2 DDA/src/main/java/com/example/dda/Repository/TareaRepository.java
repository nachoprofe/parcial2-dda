package com.example.dda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dda.Entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Write code here
}
