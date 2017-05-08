/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.api.usuarios;

import com.test.model.usuarios.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.test.model.usuarios.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author elder
 */
@Controller
public class UsuariosResource {

    private UsuarioRepository repository;

    @Autowired
    public UsuariosResource() {

    }

    public UsuariosResource(UsuarioRepository livroRepository) {
        this.repository = repository;
    }
    
    @RequestMapping(value = "/api/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> adicionaUsuario(@PathVariable("nome") String nome, @PathVariable("email") String email, @PathVariable("telefone") String telefone, @PathVariable("sexo") String sexo, Usuarios usuario) {
        String response = "";
        try {
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setTelefone(telefone);
            usuario.setSexo(sexo);
            repository.InsertUsuario(usuario);
            response = "{\"StatusReponse\": {\"success\":\"true\"}}";
            response += "{\"usuario\": {\"id\":" + String.valueOf(usuario.getId()) + " , \"nome\":\"" + usuario.getNome() + "\", \"email\":\"" + usuario.getEmail() + "\", \"telefone\":\"" + usuario.getTelefone() + "\", \"sexo\":\"" + usuario.getSexo() + "\"}}";
            return ResponseEntity.accepted().body(response);
        } catch (Exception ex) {
            response = "{\"StatusReponse\": {\"success\":\"false\"}}";
            response += "{\"Message\":{\"msg\":\"" + ex.getMessage().toString() + "\"}}";
            return ResponseEntity.badRequest().body(response);
        }
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> listarUsuarios() {
        String response = "";
        try {
            response = "{\"StatusReponse\": {\"success\":\"true\"}}";
            response += "{usuario: [";

            for (Usuarios usuario : repository.findAll()) {
                response += "{\"id\":" + String.valueOf(usuario.getId()) + " , \"nome\":\"" + usuario.getNome() + "\", \"email\":\"" + usuario.getEmail() + "\", \"telefone\":\"" + usuario.getTelefone() + "\", \"sexo\":\"" + usuario.getSexo() + "\"}";
            }
            response += " ]}";
            return ResponseEntity.ok().body(response);
        } catch (Exception ex) {
            response = "{\"StatusReponse\": {\"success\":\"false\"}}";
            response += "{\"Message\":{\"msg\":\"" + ex.getMessage().toString() + "\"}}";
            return ResponseEntity.badRequest().body(response);
        }
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getUsuario(@PathVariable("nome") int id) {
        String response = "";
        try {
            response = "{\"StatusReponse\": {\"success\":\"true\"}}";
            response += "{usuario: [";
            for (Usuarios usuario : repository.findById(id)) {
                response += "{\"id\":" + String.valueOf(usuario.getId()) + " , \"nome\":\"" + usuario.getNome() + "\", \"email\":\"" + usuario.getEmail() + "\", \"telefone\":\"" + usuario.getTelefone() + "\", \"sexo\":\"" + usuario.getSexo() + "\"}";
            }
            response += " ]}";
            return ResponseEntity.ok().body(response);
        } catch (Exception ex) {
            response = "{\"StatusReponse\": {\"success\":\"false\"}}";
            response += "{\"Message\":{\"msg\":\"" + ex.getMessage().toString() + "\"}}";
            return ResponseEntity.badRequest().body(response);
        }
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") int id) {
        String response = "";
        try {            
            response = "{\"StatusReponse\": {\"success\":\"true\"}}";
            response += "{usuario: [";
            for (Usuarios usuario : repository.findById(id)) {
                response += "{\"id\":" + String.valueOf(usuario.getId()) + " , \"nome\":\"" + usuario.getNome() + "\", \"email\":\"" + usuario.getEmail() + "\", \"telefone\":\"" + usuario.getTelefone() + "\", \"sexo\":\"" + usuario.getSexo() + "\"}";
            }
            response += " ]}";
            repository.DeleteUsuario(id);
            return ResponseEntity.ok().body(response);
        } catch (Exception ex) {
            response = "{\"StatusReponse\": {\"success\":\"false\"}}";
            response += "{\"Message\":{\"msg\":\"" + ex.getMessage().toString() + "\"}}";
            return ResponseEntity.badRequest().body(response);
        }
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> updateUsuario(@PathVariable("id") int id, @PathVariable("nome") String nome, @PathVariable("email") String email, @PathVariable("telefone") String telefone, @PathVariable("sexo") String sexo) {
        String response = "";
        try {            
            response = "{\"StatusReponse\": {\"success\":\"true\"}}";
            response += "{usuario: [";
            for (Usuarios usuario : repository.findById(id)) {
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setTelefone(telefone);
                usuario.setSexo(sexo);
                repository.UpdateUser(usuario);
                response += "{\"id\":" + String.valueOf(usuario.getId()) + " , \"nome\":\"" + usuario.getNome() + "\", \"email\":\"" + usuario.getEmail() + "\", \"telefone\":\"" + usuario.getTelefone() + "\", \"sexo\":\"" + usuario.getSexo() + "\"}";
            }
            response += " ]}";            
            response = "{StatusReponse: {success:\"true\"}}";            
            return ResponseEntity.accepted().body(response);
        } catch (Exception ex) {
            response = "{\"StatusReponse\": {\"success\":\"false\"}}";
            response += "{\"Message\":{\"msg\":\"" + ex.getMessage().toString() + "\"}}";
            return ResponseEntity.badRequest().body(response);
        }
    }

    @RequestMapping(value = "/api/elder", method = RequestMethod.POST)
    public ResponseEntity<String> testando() {
        String response = "{\"StatusReponse\": {\"success\":\"elder\"}}";
        //String response = "{ \"name\":\"John\", \"age\":30, \"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ] }";
        return ResponseEntity.ok().body(response);
    }

}
