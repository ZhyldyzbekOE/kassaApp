package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.PositionDB;
import kg.megacom.kassaapp.db.impl.PositionDBImpl;
import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.services.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {

    public void save(Position position) {
        if (position.getId() == null)
            PositionDB.INSTANCE.insert(position);
        else
            PositionDB.INSTANCE.update(position);
    }

    public Position findPositionById(int positionId) {
        return null;
    }

    @Override
    public List<Position> findAllPostions() {
        return PositionDB.INSTANCE.finAllPostions();
    }
}
