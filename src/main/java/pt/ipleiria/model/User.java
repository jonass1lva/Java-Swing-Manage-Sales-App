package pt.ipleiria.model;

/*
*Classe Utilizador, os utilizadores são criados pelo gestor da empresa
*
* Intent: Guardar o Nome de Utilizador, Verificar a Hash da password com a
* password inserida na interface, utilizado BCrypt.
*
*
* */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {

    private final String username;
    private final String passwordHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, CharSequence password) {
        this.username = username;
        this.passwordHash = encoder.encode(password);
    }

    //? USER GETTERS
    public String getUsername() {
        return username;
    }

    //? HASHING
    public boolean isMatchingPassword( CharSequence rawPassword) {
        return encoder.matches(rawPassword, passwordHash);
    }
}

