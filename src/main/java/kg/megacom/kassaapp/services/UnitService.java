package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Unit;
import kg.megacom.kassaapp.services.impl.UnitServiceImpl;

import java.util.List;

public interface UnitService {

    UnitService INSTANCE = new UnitServiceImpl();

    List<Unit> getUnits();
}
