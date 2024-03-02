package org.ailbles.demo4.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getUsers();

    Optional<User> getUserById(Long id);

    // method định nghĩa cách lấy người dùng theo id
    User addUser(User user);

    Optional<User> updateUser(Long id, User updateUser);

    void deleteUser(Long id);


}
