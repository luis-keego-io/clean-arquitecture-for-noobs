package com.luisbar.cleanarchitecturefornoobs.presentation.scene.main;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * aqui solo se contruye la vista
 */
public class MainView extends MainViewImpl {

    private LinearLayout mMain;
    private TextView textProduct;
    private TextView textQuantity;
    private TextView textPrice;
    private TextView textDiscount;
    private EditText inputProduct;
    private EditText inputQuantity;
    private EditText inputPrice;
    private EditText inputDiscount;
    private Button btnSave;
    // este array es para poder trabajarlo como en react
    public static ArrayList<EditText> refs;

    /**
     * metodo render
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());

        refs = new ArrayList();
        refs.add(inputProduct);
        refs.add(inputQuantity);
        refs.add(inputPrice);
        refs.add(inputDiscount);
    }

    /**
     * retorna la vista
     */
    private View getView() {
        mMain = new LinearLayout(this);

        mMain.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mMain.setOrientation(LinearLayout.VERTICAL);

        textProduct = new TextView(this);
        textQuantity = new TextView(this);
        textPrice = new TextView(this);
        textDiscount = new TextView(this);

        textProduct.setText("Nombre producto");
        textQuantity.setText("Cantidad");
        textPrice.setText("Precio");
        textDiscount.setText("Desuento");

        inputProduct = new EditText(this);
        inputQuantity = new EditText(this);
        inputPrice = new EditText(this);
        inputDiscount = new EditText(this);

        inputQuantity.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputPrice.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputDiscount.setInputType(InputType.TYPE_CLASS_NUMBER);

        btnSave = new Button(this);
        btnSave.setText("Guardar");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct(inputProduct.getText().toString(),
                        inputQuantity.getText().toString(),
                        inputPrice.getText().toString(),
                        inputDiscount.getText().toString());
            }
        });

        mMain.addView(textProduct);
        mMain.addView(inputProduct);
        mMain.addView(textQuantity);
        mMain.addView(inputQuantity);
        mMain.addView(textPrice);
        mMain.addView(inputPrice);
        mMain.addView(textDiscount);
        mMain.addView(inputDiscount);
        mMain.addView(btnSave);

        return mMain;
    }
}

