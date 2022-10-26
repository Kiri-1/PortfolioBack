package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoTecnologia;
import com.portfolio.demo.Entity.Tecnologia;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.STecnologia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tecnologia")
@CrossOrigin(origins = "https://portfoliobelen-4efcd.web.app")
public class CTecnologia {

    @Autowired
    STecnologia sTecnologia;

    @GetMapping("/lista")
    public ResponseEntity<List<Tecnologia>> list() {
        List<Tecnologia> list = sTecnologia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Tecnologia> getById(@PathVariable("id") int id) {
        if (!sTecnologia.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.BAD_REQUEST);
        }
        Tecnologia tecnologia = sTecnologia.getOne(id).get();
        return new ResponseEntity(tecnologia, HttpStatus.OK);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sTecnologia.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese ID"), HttpStatus.NOT_FOUND);
        }
        sTecnologia.delete(id);
        return new ResponseEntity(new Mensaje("Tecnologia eliminada"), HttpStatus.OK);
    }

  //  @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTecnologia dtotec) {
        if (StringUtils.isBlank(dtotec.getNombreT())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sTecnologia.existsByNombreT(dtotec.getNombreT())) {
            return new ResponseEntity(new Mensaje("Esa tecnologia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Tecnologia tecnologia = new Tecnologia(dtotec.getNombreT(), dtotec.getDescripcionT(), dtotec.getPorcentajeT());
        sTecnologia.save(tecnologia);

        return new ResponseEntity(new Mensaje("Tecnologia agregada"), HttpStatus.OK);
    }

  //  @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTecnologia dtotec) {
        //Validamos si existe el ID
        if (!sTecnologia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de tecnologias
        if (sTecnologia.existsByNombreT(dtotec.getNombreT()) && sTecnologia.getByNombreT(dtotec.getNombreT()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa tecnologia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtotec.getNombreT())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Tecnologia tecnologia = sTecnologia.getOne(id).get();
        tecnologia.setNombreT(dtotec.getNombreT());
        tecnologia.setDescripcionT((dtotec.getDescripcionT()));
        tecnologia.setPorcentajeT(dtotec.getPorcentajeT());

        sTecnologia.save(tecnologia);
        return new ResponseEntity(new Mensaje("Tecnologia actualizada"), HttpStatus.OK);
    }
}
