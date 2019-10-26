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
    @Transactional(readOnly = true)
    public Tarea findOne(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tarea tarea) {
        repo.save(tarea);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> buscar(String texto) {
        return repo.buscarPorDescripcion(texto);
    }
    
}
