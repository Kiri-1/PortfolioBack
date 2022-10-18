/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
 //Constructores
    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
    }
    
    
}
