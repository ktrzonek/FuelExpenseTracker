package pl.coderslab.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already taken");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User updatedUser = userRepository.findById(id).orElse(null);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        return userRepository.save(updatedUser);
    }


    public User updateUserCar(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
