package com.hicham.stockmanagment.controller.api;

import com.hicham.stockmanagment.DTO.UserDTO;
import com.hicham.stockmanagment.DTO.auth.RegisterRequestDTO;
import com.hicham.stockmanagment.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hicham.stockmanagment.Shared.Consts.APP_ROOT;

@RequestMapping(APP_ROOT+"/user")
public interface UserApi {

    @GetMapping("/all")
    public List<UserDTO> findAllUsers();

    @GetMapping("/{id}")
    public UserDTO findUser(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id);

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserDTO userDTO);


}
