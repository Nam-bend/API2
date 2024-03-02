package org.ailbles.demo4.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public Optional<User> updateUser(Long id, User updateUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUsername(updateUser.getUsername());
            existingUser.setEmail(updateUser.getEmail());

            return userRepository.save(existingUser);
        });
    /*
        map(existingUser -> {...}):
    -map là một phương thức của Optional được sử dụng để ánh xạ (transform)
    giá trị bên trong Optional nếu nó tồn tại. Nếu Optional trống, nó sẽ giữ nguyên trạng thái.
        Lambda Expression existingUser -> {...}:
    -Nếu Optional không trống, lambda expression này sẽ được thực thi.
    Trong trường hợp này, existingUser là đối tượng người dùng từ cơ sở dữ liệu.
     */
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
