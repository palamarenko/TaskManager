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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SortWrapper<?> wrapper = (SortWrapper<?>) o;

        return id != null ? id.equals(wrapper.id) : wrapper.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
