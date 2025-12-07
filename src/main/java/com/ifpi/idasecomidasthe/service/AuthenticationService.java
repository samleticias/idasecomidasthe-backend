package com.ifpi.idasecomidasthe.service;

import com.ifpi.idasecomidasthe.dto.auth.AuthenticationDTO;
import com.ifpi.idasecomidasthe.dto.auth.LoginResponseDTO;
import com.ifpi.idasecomidasthe.dto.auth.RegisterDTO;
import com.ifpi.idasecomidasthe.model.User;
import com.ifpi.idasecomidasthe.model.UserRole;
import com.ifpi.idasecomidasthe.repository.UserRepository;
import com.ifpi.idasecomidasthe.service.exception.login.CustomAuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Injetamos o Bean

    public LoginResponseDTO login(AuthenticationDTO request) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            var auth = authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());
            return new LoginResponseDTO(token);
        }
        catch (BadCredentialsException exception) {
            throw new CustomAuthenticationException("Credenciais inválidas. Por favor, verifique o email e a senha.");
        }
        catch (AuthenticationException exception) {
            throw new CustomAuthenticationException("Usuário não encontrado");
        }
    }

    public void register(RegisterDTO request) {
        if (userRepository.findByEmail(request.email()) != null) {
            throw new CustomAuthenticationException("Email já cadastrado/em uso.");
        }
        String encryptedPassword = passwordEncoder.encode(request.password());
        User user = new User(request.name(), request.email(), encryptedPassword, UserRole.USER);

        userRepository.save(user);
    }
}
