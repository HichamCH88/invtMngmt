package com.hicham.stockmanagment.services;

import com.hicham.stockmanagment.DTO.UserDTO;

import java.util.List;


public interface UserService {

    public UserDTO save(UserDTO dto);

    public List<UserDTO> findAll();

    public UserDTO findById(Integer id);

    public void deleteById(Integer id);
}
