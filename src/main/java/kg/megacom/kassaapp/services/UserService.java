package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.db.PositionDB;
import kg.megacom.kassaapp.db.UserDB;
import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.User;

import java.sql.SQLException;

public class UserService {

    private static UserService INSTANCE;

    public static UserService getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }


    /*
        1. Создать позицию далее создать user
        2. Сделать редактирование
    * */
    public boolean addOrEditUser(User user) {
        if (user.getId() == null) {
            System.out.println("add");
        } else {
            System.out.println("edit");
        }

        return true;
    }

    public void save(User user) {
        if (user.getId() == null)
            UserDB.getINSTANCE().insert(user);
        else
            UserDB.getINSTANCE().update(user);
    }




}
