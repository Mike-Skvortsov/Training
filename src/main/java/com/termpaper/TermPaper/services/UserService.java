package com.termpaper.TermPaper.services;
import com.termpaper.TermPaper.models.User;
import com.termpaper.TermPaper.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
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
    public User createUser(User user)
    {
        userRepository.save(user);
        return user;
    }
    public User updateUser(int id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setGender(userDetails.getGender());
            user.setAge(userDetails.getAge());
            user.setHeight(userDetails.getHeight());
            user.setWeight(userDetails.getWeight());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public boolean deleteUserById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
