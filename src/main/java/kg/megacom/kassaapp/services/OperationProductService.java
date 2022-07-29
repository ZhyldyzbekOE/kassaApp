package kg.megacom.kassaapp.services;

import kg.megacom.kassaapp.models.OperationProducts;
import kg.megacom.kassaapp.services.impl.OperationProductServiceImpl;

import java.util.List;

public interface OperationProductService {

    OperationProductService INSTANCE = new OperationProductServiceImpl();

    boolean saveOperationProducts(int operationId, List<OperationProducts> operationProductsList);

}
