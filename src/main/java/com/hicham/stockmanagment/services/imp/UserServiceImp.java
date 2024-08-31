package com.hicham.stockmanagment.services.imp;

import com.hicham.stockmanagment.DTO.UserDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.exception.ErrorCode;
import com.hicham.stockmanagment.exception.InvalidEntityException;
import com.hicham.stockmanagment.model.User;
import com.hicham.stockmanagment.repository.UserRepository;
import com.hicham.stockmanagment.services.UserService;
import com.hicham.stockmanagment.validator.UserValidator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(UserDTO dto) {
        List<String> errors= UserValidator.validate(dto);
        if(!errors.isEmpty())
        {
            log.error("user invalid");
            throw new InvalidEntityException("user invalid", ErrorCode.ARTICLE_NOT_Valid,errors);
        }
        if(userRepository.findByUsername(dto.getUsername()).isPresent()){
            log.error("User already exsit");
            throw new InvalidEntityException("username already exist");
        }
        User savedUser=UserDTO.toEntity(dto);
        savedUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        return UserDTO.fromEntity(userRepository.save(savedUser));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::fromEntity).toList();
    }

    @Override
    public UserDTO findById(Integer id) {
        if(id==null){
            log.error("please insert an id");
            throw new InvalidEntityException("user id is null");
        }
        return UserDTO.fromEntity(userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("user not found")));
    }

    @Override
    public void deleteById(Integer id) {
        UserDTO userToDelete =findById(id);
        userRepository.deleteById(userToDelete.getId());
    }
}
