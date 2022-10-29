package com.portfolio.demo.Security.Service;

import com.portfolio.demo.Security.Entity.Usuario;
import com.portfolio.demo.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
/* si una operacion falla hace un rolback y que no impacte en la base de datos, que siga como estaba antes */
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    /*chequea que exista ese usuario*/
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    /*chequea si existe ese email*/
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    /*guardar un usuario nuevo*/
    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
