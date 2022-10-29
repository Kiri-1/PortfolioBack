
package com.portfolio.demo.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoTecnologia {
    
    @NotBlank
    private String nombreT;
    @NotBlank
    private String descripcionT;
    @NotBlank
    private int porcentajeT;
    
//Constructores
    public dtoTecnologia() {
        
    }

    public dtoTecnologia(String nombreT, String descripcionT, int porcentajeT) {
        this.nombreT = nombreT;
        this.descripcionT = descripcionT;
        this.porcentajeT = porcentajeT;
    }


    
}