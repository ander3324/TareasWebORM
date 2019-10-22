/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.iterart.tareas.repository;

import net.iterart.tareas.entities.Tarea;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ander
 */
public interface ITareaRepo extends CrudRepository<Tarea, Integer> {
    
}
