/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.service;

import com.test.model.usuarios.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author elder
 * 
 */

public class UsuariosDAO {
    
    protected EntityManager entityManager;
    private static UsuariosDAO instance;
    
    public static UsuariosDAO getInstance() {
        if (instance == null) {
            instance = new UsuariosDAO();
        }
        return instance;
    }
    
    @Bean
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarioDB");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    private UsuariosDAO() {
        entityManager = getEntityManager();
    }
    
    public Usuarios getById(int id) {
        return entityManager.find(Usuarios.class, id);
    }

    @SuppressWarnings("unchecked")    
    public List<Usuarios> findAll() {
        return entityManager.createQuery("FROM " + Usuarios.class.getName()).getResultList();
    }
    
    public Usuarios InsertUsuario(Usuarios usuario) {        
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            return usuario;
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.printStackTrace();
            entityManager.getTransaction().rollback();            
        }
        return usuario;
    }
    
    public boolean UpdateUser(Usuarios usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean DeleteUsuario(int id) {
        try {
            entityManager.getTransaction().begin();
            Usuarios usuario = entityManager.find(Usuarios.class, id);
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }    

    
}
