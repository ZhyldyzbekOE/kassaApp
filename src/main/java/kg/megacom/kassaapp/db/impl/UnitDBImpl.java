package kg.megacom.kassaapp.db.impl;

import kg.megacom.kassaapp.db.ConnectionDB;
import kg.megacom.kassaapp.db.UnitDB;
import kg.megacom.kassaapp.models.Unit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDBImpl implements UnitDB {


    public List<Unit> getUnits(){
        List<Unit> units = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from units");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                Unit unit = new Unit();
                unit.setId(resultSet.getInt(1));
                unit.setName(resultSet.getString(2));
                units.add(unit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.INSTANCE.close(connection);
            return units;
        }
    }


}
