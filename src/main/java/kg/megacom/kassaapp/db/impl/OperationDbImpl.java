package kg.megacom.kassaapp.db.impl;

import kg.megacom.kassaapp.db.ConnectionDB;
import kg.megacom.kassaapp.db.OperationDb;
import kg.megacom.kassaapp.models.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OperationDbImpl implements OperationDb {

    @Override
    public Operation saveOperation(Operation operation) {
        Connection connection = null;
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            String query = "insert into operation(oper_date, total_price) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, operation.getAddDate().toString());
            ps.setDouble(2, operation.getTotal());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.INSTANCE.close(connection);
        }
        return null;
    }
}
