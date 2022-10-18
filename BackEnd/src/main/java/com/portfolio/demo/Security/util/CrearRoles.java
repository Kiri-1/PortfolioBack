/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.portfolio.demo.Security.util;

import com.portfolio.demo.Security.Entity.Rol;
import com.portfolio.demo.Security.Enums.RolNombre;
import com.portfolio.demo.Security.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CrearRoles implements CommandLineRunner {
    @Autowired
    RolService rolService;
   @Override
   public void run(String... args) throws Exception {
       Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
       rolService.save(rolAdmin);
       rolService.save(rolUser);
   }
}*/
