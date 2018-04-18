package ua.android.cozy.myapplication.pojo;

import android.support.annotation.DrawableRes;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 15:22
 */

public abstract class Mechanism {


    public abstract String getName();
    @DrawableRes
    public abstract int getIcon();
}
