package ua.android.cozy.myapplication.thread_manager;

import java.util.List;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 15:24
 */

public interface GetSortedList<T> {
    void get(String id, List<T> t);
}
