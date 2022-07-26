package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.models.Unit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDB {


    private static UnitDB INSTANCE;

    public static UnitDB getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new UnitDB();
        }

        return INSTANCE;
    }

    public List<Unit> getUnits(){
        List<Unit> units = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionDB.getConnection();
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
            ConnectionDB.close(connection);
            return units;
        }
    }


}
