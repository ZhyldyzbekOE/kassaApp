package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.PositionDBImpl;
import kg.megacom.kassaapp.models.Position;

import java.util.List;

public interface PositionDB {


    PositionDB INSTANCE = new PositionDBImpl();
    void insert(Position position);

    void update(Position position);

    List<Position> finAllPostions();

}
