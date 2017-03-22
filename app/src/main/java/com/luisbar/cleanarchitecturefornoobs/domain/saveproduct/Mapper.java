package com.luisbar.cleanarchitecturefornoobs.domain.saveproduct;

import com.luisbar.cleanarchitecturefornoobs.presentation.scene.main.MainModel;

public class Mapper {

    public com.luisbar.cleanarchitecturefornoobs.domain.saveproduct.MainModel MainModelPToMainModelD(MainModel mainModel) {

        return new com.luisbar.cleanarchitecturefornoobs.domain.saveproduct.MainModel(
                mainModel.getProduct(),
                mainModel.getQuantity(),
                mainModel.getPrice(),
                mainModel.getDiscount()
        );
    }
}
