package com.hicham.stockmanagment.controller.auth;


import com.hicham.stockmanagment.DTO.auth.AuthRequestDTO;
import com.hicham.stockmanagment.DTO.auth.AuthResponseDTO;
import com.hicham.stockmanagment.DTO.auth.RegisterRequestDTO;
import com.hicham.stockmanagment.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hicham.stockmanagment.Shared.Consts.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT+"/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO requestDTO){
        return  ResponseEntity.ok(authService.register(requestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO requestDTO){
        return ResponseEntity.ok(authService.authenticate(requestDTO));
    }
}
