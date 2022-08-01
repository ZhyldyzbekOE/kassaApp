package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.UserDBImpl;
import kg.megacom.kassaapp.models.User;

import java.util.List;

public interface UserDB {

    UserDB INSTANCE = new UserDBImpl();
    boolean insert(User user);

    boolean update(User user);

    User getUserById(int id);

    List<User> getAllUsersFromDb();

    boolean deleteUserById (int id);

    User findUserByLoginAndPassword(String login, String password);
}
