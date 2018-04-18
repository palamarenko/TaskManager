package ua.android.cozy.myapplication.pojo.sorted;

import java.util.ArrayList;
import java.util.List;

import ua.android.cozy.myapplication.pojo.Mechanism;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 15:21
 */

public abstract class BaseSortedClass<T extends Mechanism> {

    protected List<Mechanism> list = new ArrayList<>();

    public BaseSortedClass(List<Mechanism> list) {
        this.list = list;
    }

    public List<Mechanism> getList(){
        return list;
    }

    public abstract void sort() throws InterruptedException;
}
