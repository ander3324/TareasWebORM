/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.iterart.tareas.service;

import java.util.List;
import net.iterart.tareas.entities.Tarea;
import net.iterart.tareas.repository.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ander
 */
@Service
public class TareaServiceImpl implements ITareaService{

    //Dependence Injection
    @Autowired
    ITareaRepo repo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        return (List<Tarea>) repo.findAll();
    }

    @Override
    public Tarea findOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Tarea tarea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
