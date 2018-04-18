package ua.android.cozy.myapplication.recycler;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ua.android.cozy.myapplication.R;
import ua.android.cozy.myapplication.pojo.Mechanism;
import ua.android.cozy.myapplication.recycler.base.BaseViewHolder;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 16:19
 */

public class MechanismViewHolder extends BaseViewHolder<Mechanism>{

    private TextView title;
    private ImageView icon;

    public MechanismViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_mechanism);
        title = itemView.findViewById(R.id.title);
        icon = itemView.findViewById(R.id.icon);
    }

    @Override
    protected void bindData(Mechanism data) {
        title.setText(data.getName());
        icon.setImageResource(data.getIcon());
    }
}
