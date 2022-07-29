package kg.megacom.kassaapp.db;

import kg.megacom.kassaapp.db.impl.OperationDbImpl;
import kg.megacom.kassaapp.db.impl.OperationProductDBImpl;
import kg.megacom.kassaapp.models.OperationProducts;

import java.util.List;

public interface OperationProductDB {


    OperationProductDB INSTANCE = new OperationProductDBImpl();



    boolean saveOperationProduct(int operationId, List<OperationProducts> operationProductsList);


}
