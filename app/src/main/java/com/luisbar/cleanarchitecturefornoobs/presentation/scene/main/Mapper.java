package com.luisbar.cleanarchitecturefornoobs.presentation.scene.main;

import org.json.JSONException;
import org.json.JSONObject;

public class Mapper {

    public MainModel jsonToMainModel(JSONObject object) {
        try {
            return new MainModel(object.getString("product"),
                    object.getInt("quantity"),
                    object.getInt("price"),
                    object.getInt("discount"),
                    object.getInt("priceWithDiscount"),
                    object.getString("message"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
