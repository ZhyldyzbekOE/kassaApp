package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.db.PositionDB;
import kg.megacom.kassaapp.db.ProductDB;
import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.models.Product;

public class PositionService {

    private static PositionService INSTANCE;

    public static PositionService getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new PositionService();
        }
        return INSTANCE;
    }

    public void save(Position position) {
        if (position.getId() == null)
            PositionDB.getINSTANCE().insert(position);
        else
            PositionDB.getINSTANCE().update(position);
    }

    public Position findPositionById(int positionId) {
        return null;
    }
}
