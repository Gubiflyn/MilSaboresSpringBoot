package com.pasteleria.Milsabores.Repository;

import com.pasteleria.Milsabores.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   
    Usuario findByNombre(String nombre);

    
     Usuario findByCorreo(String correo);
}
