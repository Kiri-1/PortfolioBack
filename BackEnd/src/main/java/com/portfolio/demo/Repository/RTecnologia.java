/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.Tecnologia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTecnologia extends JpaRepository<Tecnologia, Integer>{
    public Optional<Tecnologia> findByNombreT(String nombreT);
    public boolean existsByNombreT(String nombreT);
    
}
