package kg.backend.meniki.controller;

import kg.backend.meniki.model.security.User;
import kg.backend.meniki.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
        // Получить всех пользователей
        @GetMapping("/get-all")
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

        // Получить пользователя по id
        @GetMapping("/find/{id}")
        public ResponseEntity<User> findUserById(@PathVariable Long id) {
            return userService.findUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        // Создать нового пользователя
        @PostMapping("/create")
        public User createUser(@RequestBody User user) {
            return userService.createUser(user);
        }

        // Обновить существующего пользователя
        @PutMapping("/update/{id}")
        public void updateUser(@RequestBody User user,@PathVariable Long id) {
            userService.updateUser(user, id);
        }

        // Удалить пользователя
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }



    }




