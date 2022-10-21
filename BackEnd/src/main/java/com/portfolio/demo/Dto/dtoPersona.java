
package com.portfolio.demo.Dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class dtoPersona implements Serializable {
   
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String descripcion; 
    
    @NotBlank
    private String imagen;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcion, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

}
