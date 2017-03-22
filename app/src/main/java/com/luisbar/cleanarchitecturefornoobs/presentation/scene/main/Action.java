package com.luisbar.cleanarchitecturefornoobs.presentation.scene.main;

import com.luisbar.cleanarchitecturefornoobs.presentation.scene.main.MainModel;

public class Action {

    private int type;
    private MainModel payload;
    private boolean error;

    public Action(int type, MainModel payload, boolean error) {
        this.type = type;
        this.payload = payload;
        this.error = error;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MainModel getPayload() {
        return payload;
    }

    public void setPayload(MainModel payload) {
        this.payload = payload;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
