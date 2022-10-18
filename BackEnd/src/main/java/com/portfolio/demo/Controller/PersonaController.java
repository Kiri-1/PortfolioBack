package com.portfolio.demo.Controller;

import com.portfolio.demo.Entity.Persona;
import com.portfolio.demo.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")

public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer") //traiga de la base de datos al front
    public List<Persona> getPersona(){ //traemos una lista de personas
        return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear") //guarda algo en la base de datos una persona en particular
    public String createPersona(@RequestBody Persona persona) {//creando un usuario
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @GetMapping("/personas/traer/perfil")//traemos una persona
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id); //borrar persona
        return "La persona fue eliminada correctamente";
    }
    //ejemplo de url:puerto/personas/editar/4/nombre & apellido & img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")  //editar un usuario
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre); //cambia las variables
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);   //guardando
        return persona;
    }
}
