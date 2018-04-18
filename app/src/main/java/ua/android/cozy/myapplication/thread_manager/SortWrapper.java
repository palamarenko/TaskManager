package ua.android.cozy.myapplication.thread_manager;

import ua.android.cozy.myapplication.pojo.sorted.BaseSortedClass;
import ua.android.cozy.myapplication.pojo.Mechanism;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 15:43
 */

public class SortWrapper<T extends Mechanism> {

    private String id;
    private BaseSortedClass<T> baseSortedClass;


    public SortWrapper(String id, BaseSortedClass<T> baseSortedClass) {
        this.id = id;
        this.baseSortedClass = baseSortedClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BaseSortedClass<T> getBaseSortedClass() {
        return baseSortedClass;
    }

    public void setBaseSortedClass(BaseSortedClass<T> baseSortedClass) {
        this.baseSortedClass = baseSortedClass;
    }
}
