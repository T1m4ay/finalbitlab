package com.example.finalproject.service;

import com.example.finalproject.model.Game;
import com.example.finalproject.model.Role;
import com.example.finalproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role getRole(Long id){
        return roleRepository.findById(id).orElse(new Role());
    }

}
