package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Position;
import kg.megacom.kassaapp.services.impl.PositionServiceImpl;

import java.util.List;

public interface PositionService {

    PositionService INSTANCE = new PositionServiceImpl();

    void save(Position position);

    Position findPositionById(int positionId);

    List<Position> findAllPostions();
}
