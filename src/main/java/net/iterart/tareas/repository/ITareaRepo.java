/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.iterart.tareas.repository;

import java.util.List;
import net.iterart.tareas.entities.Tarea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ander
 */
public interface ITareaRepo extends CrudRepository<Tarea, Integer> {

    @Query("select t from Tarea t where t.descripcion like %?1%")
    public List<Tarea> buscarPorDescripcion(String descripcion);
}
