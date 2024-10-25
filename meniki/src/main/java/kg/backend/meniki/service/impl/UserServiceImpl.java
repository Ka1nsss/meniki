package kg.backend.meniki.service.impl;

import kg.backend.meniki.model.security.User;
import kg.backend.meniki.repo.CartRepository;
import kg.backend.meniki.repo.ProductRepository;
import kg.backend.meniki.repo.UserRepository;
import kg.backend.meniki.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final ProductRepository productRepository;
    private final CartServiceImpl cartServiceImpl;
    private final CartRepository cartRepository;
    private UserRepository userRepository;

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public Optional<User> findUserById(Long id) {
            return userRepository.findById(id);
        }

        public User createUser(User user) {
            return userRepository.save(user);
        }


    public void updateUser(User user, Long id) {
            User newUser = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

                newUser.setUsername(newUser.getUsername());
                newUser.setEmail(newUser.getEmail());
            userRepository.save(user);
        }

    public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }
    }



