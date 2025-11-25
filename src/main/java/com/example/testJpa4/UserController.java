package com.example.testJpa4;

import com.example.testJpa4.entity.User;

import com.example.testJpa4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired  // Spring автоматически предоставит repository
    private UserRepository userRepository;

    // GET /api/users — получить всех пользователей
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Запрос к БД!
    }

    // GET /api/users/1 — получить пользователя с id=1
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // POST /api/users — добавить нового пользователя
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);  // Запрос к БД!
    }

    // PUT /api/users/1 — изменить пользователя
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    // DELETE /api/users/1 — удалить пользователя
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}