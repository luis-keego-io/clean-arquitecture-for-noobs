package com.luisbar.cleanarchitecturefornoobs.presentation.scene.main;

import com.luisbar.cleanarchitecturefornoobs.domain.saveproduct.SaveProduct;
import com.luisbar.cleanarchitecturefornoobs.domain.UseCase;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * aqui se valida los datos capturados por la vista, se retorna los datos actualizados a la vista pero
 * antes se los mapea a un objeto entendible (Model) para la vista
 */
public class MainPresenter {

    private UseCase mUseCase;
    private Mapper mMapper;

    private final int SAVE_PRODUCT = 1;
    private final int SAVE_PRODUCT_P = 2;

    /**
     * registra los escuchadores
     */
    public void onStart() {
        mUseCase = new SaveProduct(); // se utiliza polimorfismo
        // para tener una dependencia mas generica
        // seria mejor si se utiliza inyeccion de dependencia dicen unos, otros que complica mas el codigo
        mMapper = new Mapper();

        EventBus.getDefault().register(this);
    }

    /**
     * elimina los escuchadores
     */
    public void onStop() {
        EventBus.getDefault().unregister(this);
    }

    /**
     * validad los parametros y se comunica con la capa domain
     * @param product
     * @param quantity
     * @param price
     * @param discount
     */
    public void saveProduct(String product, String quantity, String price, String discount) {
        if (isNotEmpty(product, quantity, price)) {

            mUseCase.execute(new MainModel(product,
                    Integer.valueOf(quantity),
                    Integer.valueOf(price),
                    discount.isEmpty() ? 0 : Integer.valueOf(discount)));
        } else
            EventBus.getDefault().post(new Action(SAVE_PRODUCT, new MainModel("Campos incorrectos"), true));
    }

    private boolean isNotEmpty(String product, String quantity, String price) {
        return !product.isEmpty() && !quantity.isEmpty() && !price.isEmpty();
    }

    @Subscribe
    public void runAction(com.luisbar.cleanarchitecturefornoobs.data.repository.main.Action action) {
        switch (action.getType()) {
            case SAVE_PRODUCT_P:
                EventBus.getDefault().post(new Action(SAVE_PRODUCT,
                        mMapper.jsonToMainModel(action.getPayload()),
                        action.isError()));
                break;
        }
    }
}
