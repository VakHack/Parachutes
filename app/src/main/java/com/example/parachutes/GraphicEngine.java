package com.example.parachutes;

import android.app.Activity;

public abstract class GraphicEngine {
    protected Activity mainActivity;

    public GraphicEngine(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    abstract void render();
}
