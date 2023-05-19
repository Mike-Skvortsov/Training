package com.termpaper.TermPaper.services;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> getUser(int id)
    {
        return userRepository.findById(id);
    }
    public Iterable<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
