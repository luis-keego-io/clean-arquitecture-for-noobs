package com.luisbar.cleanarchitecturefornoobs.data.repository.main;

import org.json.JSONObject;

public class Action {

    private int type;
    private JSONObject payload;
    private boolean error;

    public Action(int type, JSONObject payload, boolean error) {
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

    public JSONObject getPayload() {
        return payload;
    }

    public void setPayload(JSONObject payload) {
        this.payload = payload;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
