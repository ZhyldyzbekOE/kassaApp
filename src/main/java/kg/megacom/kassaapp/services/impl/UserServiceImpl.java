package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.UserDB;
import kg.megacom.kassaapp.models.User;
import kg.megacom.kassaapp.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl INSTANCE;

    public static UserServiceImpl getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }

    public boolean addOrEditUser(User user) {
        return save(user);
    }

    private boolean save(User user) {
        if (user.getId() == null)
            return UserDB.getINSTANCE().insert(user);
        else
            return UserDB.getINSTANCE().update(user);

    }

    public List<User> findAllUsers() {
        return UserDB.getINSTANCE().getAllUsersFromDb();
    }

    public User findOneUserById(int userId) {
        return UserDB.getINSTANCE().getUserById(userId);
    }

    public boolean deleteUser(int id) {
        return UserDB.getINSTANCE().deleteUserById(id);
    }


}
