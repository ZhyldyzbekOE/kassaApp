package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.UnitDBImpl;
import kg.megacom.kassaapp.models.Unit;

import java.util.List;

public interface UnitDB {

    UnitDB INSTANCE = new UnitDBImpl();

    List<Unit> getUnits();


}
