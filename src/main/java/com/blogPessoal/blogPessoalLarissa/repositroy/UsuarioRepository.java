package com.blogPessoal.blogPessoalLarissa.repositroy;

import com.blogPessoal.blogPessoalLarissa.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario>findByUsuario(String usuario);
}
