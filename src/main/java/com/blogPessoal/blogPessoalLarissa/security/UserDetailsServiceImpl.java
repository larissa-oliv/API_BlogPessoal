package com.blogPessoal.blogPessoalLarissa.security;

import com.blogPessoal.blogPessoalLarissa.model.*;
import com.blogPessoal.blogPessoalLarissa.repositroy.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<Usuario> user = userRepository.findByUsuario(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + "Not Found."));

        return user.map(UserDetailsImpl::new).get();
    }
}
