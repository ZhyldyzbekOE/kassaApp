package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.Operation;
import kg.megacom.kassaapp.services.impl.OperationServiceImpl;

public interface OperationService {

    OperationService INSTANCE = new OperationServiceImpl();

    Operation closeAndSaveOperation(double totalPrice, int userId);
}
