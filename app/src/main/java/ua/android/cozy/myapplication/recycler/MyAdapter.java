package ua.android.cozy.myapplication.recycler;

import android.view.ViewGroup;

import ua.android.cozy.myapplication.pojo.Mechanism;
import ua.android.cozy.myapplication.recycler.base.BaseViewHolder;
import ua.android.cozy.myapplication.recycler.base.SimpleRecyclerAdapter;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 16:16
 */

public class MyAdapter extends SimpleRecyclerAdapter<Mechanism> {


    @Override
    public BaseViewHolder<Mechanism> getViewHolder(ViewGroup parent) {
        return new MechanismViewHolder(parent);
    }
}
