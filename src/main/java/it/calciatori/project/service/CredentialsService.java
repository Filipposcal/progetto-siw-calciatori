package it.calciatori.project.service;

import java.util.Optional;

import it.calciatori.project.model.Credentials;
import it.calciatori.project.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service @Transactional
public class CredentialsService {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected CredentialsRepository credentialsRepository;



    @Transactional
    public Credentials getCredentials(String username) {
        Optional<Credentials> result = this.credentialsRepository.findByUsername(username);
        return result.orElse(null);
    }

    @Transactional
    public Credentials saveCredentials(Credentials credentials) {
        credentials.setRole(Credentials.DEFAULT_ROLE);
        credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
        return this.credentialsRepository.save(credentials);
    }

    @Transactional
    public Credentials saveCredentialsAdmin(Credentials credentials) {
        credentials.setRole(Credentials.ADMIN_ROLE);
        credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
        return this.credentialsRepository.save(credentials);
    }
}