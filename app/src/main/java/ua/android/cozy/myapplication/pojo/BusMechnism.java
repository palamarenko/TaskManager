package ua.android.cozy.myapplication.pojo;

import ua.android.cozy.myapplication.R;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 16:27
 */

public class BusMechnism extends Mechanism {

    private String name;


    public BusMechnism(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getIcon() {
        return R.drawable.ic_bus;
    }
}
