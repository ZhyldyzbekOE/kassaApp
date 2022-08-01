package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.UserDB;
import kg.megacom.kassaapp.models.User;
import kg.megacom.kassaapp.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    public boolean addOrEditUser(User user) {
        return save(user);
    }

    private boolean save(User user) {
        if (user.getId() == null)
            return UserDB.INSTANCE.insert(user);
        else
            return UserDB.INSTANCE.update(user);

    }

    public List<User> findAllUsers() {
        return UserDB.INSTANCE.getAllUsersFromDb();
    }

    public User findOneUserById(int userId) {
        return UserDB.INSTANCE.getUserById(userId);
    }

    public boolean deleteUser(int id) {
        return UserDB.INSTANCE.deleteUserById(id);
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        return UserDB.INSTANCE.findUserByLoginAndPassword(login, password);
    }


}
