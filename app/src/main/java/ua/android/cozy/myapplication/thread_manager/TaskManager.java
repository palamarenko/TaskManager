package ua.android.cozy.myapplication.thread_manager;

import ua.android.cozy.myapplication.pojo.sorted.BaseSortedClass;
import ua.android.cozy.myapplication.pojo.Mechanism;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 15:19
 */

public interface TaskManager<T extends Mechanism> {

    void sortThis(String id, BaseSortedClass<T> sortedClass);

    void sortIsReady(GetSortedList<T> getSortedList);
}
