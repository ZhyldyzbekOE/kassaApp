package kg.megacom.kassaapp.db.impl;

import kg.megacom.kassaapp.db.ConnectionDB;
import kg.megacom.kassaapp.db.OperationDb;
import kg.megacom.kassaapp.models.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OperationDbImpl implements OperationDb {

    @Override
    public Operation saveOperation(Operation operation) {
        Connection connection = null;
        Operation operationFromDb = null;
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            String query = "insert into operation(oper_date, total_price) values (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, operation.getAddDate().toString());
            ps.setDouble(2, operation.getTotal());
            ps.execute();
            operationFromDb = findOperationByTotalPriceAndOperDate(operation.getTotal(), operation.getAddDate().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.INSTANCE.close(connection);
        }
        return operationFromDb;
    }
    public Operation findOperationByTotalPriceAndOperDate(double totalPrice, String operDate) {
        Connection connection = null;
        try {
            connection = ConnectionDB.INSTANCE.getConnection();
            String query = "select * from operation where oper_date = ? and total_price = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, operDate);
            ps.setDouble(2, totalPrice);

            ResultSet rs = ps.executeQuery();
            Operation operation = new Operation();
            operation.setId(rs.getInt(1));
            //System.out.println((rs.getDate(2)));
            //operation.setAddDate(rs.getDate(2));
            operation.setTotal(rs.getInt(3));

            return operation;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.INSTANCE.close(connection);
        }
        return null;
    }


}
