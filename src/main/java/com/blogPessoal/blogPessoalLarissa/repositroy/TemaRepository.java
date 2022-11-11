package com.blogPessoal.blogPessoalLarissa.repositroy;

import com.blogPessoal.blogPessoalLarissa.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface TemaRepository extends JpaRepository <Tema, Long> {

    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

}
