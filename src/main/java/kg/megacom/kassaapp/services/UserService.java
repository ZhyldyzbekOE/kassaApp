package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.db.UserDB;
import kg.megacom.kassaapp.models.User;

import java.util.List;

public class UserService {

    private static UserService INSTANCE;

    public static UserService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }


    /*
        1. Создать позицию далее создать user
        2. Сделать редактирование
    * */
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
        return null;
    }


}
