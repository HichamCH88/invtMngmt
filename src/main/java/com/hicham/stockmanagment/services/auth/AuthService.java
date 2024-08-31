package com.hicham.stockmanagment.services.auth;


import com.hicham.stockmanagment.DTO.auth.AuthRequestDTO;
import com.hicham.stockmanagment.DTO.auth.AuthResponseDTO;
import com.hicham.stockmanagment.DTO.auth.RegisterRequestDTO;
import com.hicham.stockmanagment.exception.EntityNotFoundException;
import com.hicham.stockmanagment.model.User;
import com.hicham.stockmanagment.repository.UserRepository;
import com.hicham.stockmanagment.services.imp.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO register(RegisterRequestDTO requestDTO){
        var user=User.builder()
                .firstName(requestDTO.getFirstname())
                .lastName(requestDTO.getLastname())
                .password(passwordEncoder.encode(requestDTO.getPassword()))
                .email(requestDTO.getEmail())
                .role(requestDTO.getRole())
                .build();
        var savedUser=userRepository.save(user);
        var jwtToken=jwtService.generateJwToken(user);
        return AuthResponseDTO.builder()
                .jwToken(jwtToken)
                .build();

    }

    public AuthResponseDTO authenticate(AuthRequestDTO requestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDTO.getEmail(),
                        requestDTO.getPassword()
                )
        );
        var user = userRepository.findByEmail(requestDTO.getEmail()).orElseThrow();
        var jwtToken=jwtService.generateJwToken(user);
        return AuthResponseDTO
                .builder()
                .jwToken(jwtToken)
                .build();
    }
}
