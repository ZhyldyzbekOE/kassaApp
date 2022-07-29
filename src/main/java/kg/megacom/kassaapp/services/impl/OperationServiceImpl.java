package kg.megacom.kassaapp.services.impl;

import kg.megacom.kassaapp.db.OperationDb;
import kg.megacom.kassaapp.models.Operation;
import kg.megacom.kassaapp.models.OperationProducts;
import kg.megacom.kassaapp.services.OperationProductService;
import kg.megacom.kassaapp.services.OperationService;

import java.time.LocalDateTime;
import java.util.List;

public class OperationServiceImpl implements OperationService {

    @Override
    public boolean closeAndSaveOperation(double totalPrice, int userId, List<OperationProducts> operationProductsList) {
        Operation operation = OperationDb.INSTANCE.saveOperation(new Operation(LocalDateTime.now(), totalPrice));
        return OperationProductService.INSTANCE.saveOperationProducts(operation.getId(), operationProductsList);
    }
}
