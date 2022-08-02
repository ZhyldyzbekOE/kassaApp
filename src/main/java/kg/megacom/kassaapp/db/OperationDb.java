package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.OperationDbImpl;
import kg.megacom.kassaapp.models.Operation;

public interface OperationDb {

    OperationDb INSTANCE =new OperationDbImpl();

    Operation saveOperation(Operation operation, int userId);

    Operation findOperationByTotalPriceAndOperDate(double totalPrice, String operDate);


}
