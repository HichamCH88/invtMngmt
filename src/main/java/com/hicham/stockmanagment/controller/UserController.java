package com.hicham.stockmanagment.controller;
import com.hicham.stockmanagment.DTO.UserDTO;
import com.hicham.stockmanagment.controller.api.UserApi;
import com.hicham.stockmanagment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private  UserService userService;

    @Override
    public List<UserDTO> findAllUsers() {
        return userService.findAll();
    }

    @Override
    public UserDTO findUser(Integer id) {
        return userService.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userService.deleteById(id);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        return userService.save(userDTO);
    }
}
