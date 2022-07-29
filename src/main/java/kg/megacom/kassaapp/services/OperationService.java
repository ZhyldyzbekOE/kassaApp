package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Operation;
import kg.megacom.kassaapp.models.OperationProducts;
import kg.megacom.kassaapp.services.impl.OperationServiceImpl;

import java.util.List;

public interface OperationService {

    OperationService INSTANCE = new OperationServiceImpl();

    boolean closeAndSaveOperation(double totalPrice, int userId, List<OperationProducts> operationProductsList);
}
