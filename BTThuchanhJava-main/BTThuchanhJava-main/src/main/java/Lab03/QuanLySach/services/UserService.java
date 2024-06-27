package Lab03.QuanLySach.services;

import Lab03.QuanLySach.entity.User;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user);
}
