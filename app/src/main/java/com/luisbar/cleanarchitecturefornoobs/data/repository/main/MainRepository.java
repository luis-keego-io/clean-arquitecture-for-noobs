package com.luisbar.cleanarchitecturefornoobs.data.repository.main;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * acceso a nuestra fuente de datos, y retorno de respuesta al presenter para que el presenter
 * actualize la vista
 */
public class MainRepository {

    private final int SAVE_PRODUCT_P = 2;

    public void saveProduct(String product, int quantity, int price, int discount, int priceWithDiscount) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JSONObject object = new JSONObject();
        try {
            object.put("product", product);
            object.put("quantity", quantity);
            object.put("price", price);
            object.put("discount", discount);
            object.put("priceWithDiscount", priceWithDiscount);
            object.put("message", "El producto fue guardado, su precio con descuento es: " + priceWithDiscount);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        EventBus.getDefault().post(new Action(SAVE_PRODUCT_P, object, false));
    }
}
