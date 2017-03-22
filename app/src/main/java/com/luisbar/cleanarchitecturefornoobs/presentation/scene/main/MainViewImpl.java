package com.luisbar.cleanarchitecturefornoobs.presentation.scene.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * aqui se manejan los eventos del ciclo de vida, excepto el render
 * se establecen escuchadores para actualizar la vista
 * se comunica con el presenter que le corresponde
 */
public class MainViewImpl extends AppCompatActivity {

    private MainPresenter mMainPresenter;

    private final int SAVE_PRODUCT = 1;

    /**
     * este trabaja solo como constructor
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = new MainPresenter();
    }

    /**
     * metodo componentDidMounted
     */
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this); // registra escuchadores
        mMainPresenter.onStart();
    }

    /**
     * metodo componentDidUnmounted
     */
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this); // elimina los escuchadores
        mMainPresenter.onStop();
    }

    /**
     * esto es para que MainView no tenga una dependencia con MainPresenter
     */
    public void saveProduct(String product, String quantity, String price, String discount) {
        mMainPresenter.saveProduct(product, quantity, price, discount);
    }

    /**
     * este seria el reducer que viene a ser mi escuchador
     */
    @Subscribe
    public void runAction(Action action) {
        switch (action.getType()) {
            case SAVE_PRODUCT:
                productWasSaved(action.getPayload(), action.isError());
                break;
        }
    }

    /**
     * se encarga de actualizar la vista para el caso de uso guardar producto
     */
    private void productWasSaved(MainModel payload, boolean error) {
        if (!error) {
            cleanGUI();
            showMessageOfSuccessful(payload.getMessage());
        } else
            showMessageOfFail(payload.getMessage());
    }

    /**
     * limpia la vista
     */
    private void cleanGUI() {
        EditText inputProduct = MainView.refs.get(0);
        EditText inputQuantity = MainView.refs.get(1);
        EditText inputPrice = MainView.refs.get(2);
        EditText inputDiscount = MainView.refs.get(3);

        inputProduct.getText().clear();
        inputQuantity.getText().clear();
        inputPrice.getText().clear();
        inputDiscount.getText().clear();
    }

    private void showMessageOfSuccessful(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showMessageOfFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
