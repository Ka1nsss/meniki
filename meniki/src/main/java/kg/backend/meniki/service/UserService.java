package kg.backend.meniki.service;

import kg.backend.meniki.model.security.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void updateUser(User user, Long id);

    void deleteUser(Long id);

    User createUser(User user);


    List<User> getAllUsers();
    Optional<User> findUserById(Long id);




}
