package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.db.UnitDB;
import kg.megacom.kassaapp.models.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitService {

    private static UnitService INSTANCE;

    public static UnitService getINSTANCE(){
        if (INSTANCE == null)
            INSTANCE = new UnitService();

        return INSTANCE;
    }


    public List<Unit> getUnits(){
        return UnitDB.getINSTANCE().getUnits();
    }
}
