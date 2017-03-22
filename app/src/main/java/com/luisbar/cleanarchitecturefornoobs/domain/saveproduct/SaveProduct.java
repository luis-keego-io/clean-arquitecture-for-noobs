package com.luisbar.cleanarchitecturefornoobs.domain.saveproduct;

import com.luisbar.cleanarchitecturefornoobs.data.repository.main.MainRepository;
import com.luisbar.cleanarchitecturefornoobs.domain.UseCase;
import com.luisbar.cleanarchitecturefornoobs.presentation.scene.main.MainModel;

/**
 * es un caso de uso, toda la logica se aplicaria aqui
 */
public class SaveProduct implements UseCase {

    private Mapper mapper;
    private MainRepository mMainRepository;

    public SaveProduct() {
        mapper = new Mapper();
        mMainRepository = new MainRepository();
    }

    @Override
    public void execute(Object object) {
        com.luisbar.cleanarchitecturefornoobs.domain.saveproduct.MainModel mainModel = mapper.MainModelPToMainModelD((MainModel) object);
        int priceWithDiscount = mainModel.getPrice() - mainModel.getDiscount();

        mMainRepository.saveProduct(mainModel.getProduct(), mainModel.getQuantity(), mainModel.getPrice()
        , mainModel.getDiscount(), priceWithDiscount);
    }
}
