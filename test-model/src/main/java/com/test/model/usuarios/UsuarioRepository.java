/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.model.usuarios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author elder
 */
@Repository
   public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{   
    List<Usuarios> findAll();
    List<Usuarios> findById(int id);
    boolean InsertUsuario(Usuarios usuario);
    boolean UpdateUser(Usuarios usuario);
    boolean DeleteUsuario(int id);
    
}
