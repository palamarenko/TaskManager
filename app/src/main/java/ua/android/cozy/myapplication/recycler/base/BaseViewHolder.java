package ua.android.cozy.myapplication.recycler.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Palamarenko Andrey on
 * 31.03.2018 12:46
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private Context context;
    private ViewGroup parent;

    public BaseViewHolder(ViewGroup parent, @LayoutRes int id) {
        super(LayoutInflater.from(parent.getContext()).inflate(id, parent, false));
        this.context = itemView.getContext();
        this.parent = parent;
    }

    public BaseRecyclerAdapter getAdapter() {

        if(getRecyclerView().getAdapter() instanceof BaseRecyclerAdapter){
            return (BaseRecyclerAdapter) getRecyclerView().getAdapter();
        }else {
            throw new IllegalStateException("Use one of implementation of BaseRecyclerAdapter");
        }

    }

    public RecyclerView getRecyclerView() {
        return (RecyclerView) parent;
    }


    protected Context getContext() {
        return context;
    }

    public void bind(Object object) {
        try {
            T t = (T) object;
            bindData(t);
        } catch (ClassCastException ignore) {
        }

    }

    protected abstract void bindData(T data);

    public void itemClick(final Runnable runnable) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runnable.run();
            }
        });
    }


}
