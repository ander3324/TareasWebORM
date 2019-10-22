/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.iterart.tareas.service;

import java.util.List;
import net.iterart.tareas.entities.Tarea;

/**
 *
 * @author ander
 */
public interface ITareaService {
    
    //Métodos a implementar
    public List<Tarea> findAll();
    
    public Tarea findOne(int id);
    
    public void save(Tarea tarea);
}
