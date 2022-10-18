package com.portfolio.demo.Interface;

import com.portfolio.demo.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guardamos un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario pero lo buscamos por id
    public void deletePersona(Long id);
   
    //Buscar una persona por id
    public Persona findPersona(Long id);
    
}

