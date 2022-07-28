package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.User;
import kg.megacom.kassaapp.services.impl.UserServiceImpl;

import java.util.List;

public interface UserService {


    UserService INSTANCE = new UserServiceImpl();

    boolean addOrEditUser(User user);

    List<User> findAllUsers();

    User findOneUserById(int userId);

    boolean deleteUser(int id);
}
