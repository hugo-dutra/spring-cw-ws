package com.corretoraweb.ws.interfaces;

import com.corretoraweb.ws.security.Cypher;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface ICypher {
    public PasswordEncoder getPasswordEncoder();
}
