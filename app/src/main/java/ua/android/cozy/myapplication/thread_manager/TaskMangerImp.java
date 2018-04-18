package ua.android.cozy.myapplication.thread_manager;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import ua.android.cozy.myapplication.pojo.sorted.BaseSortedClass;
import ua.android.cozy.myapplication.pojo.Mechanism;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 14:46
 */

public class TaskMangerImp implements TaskManager<Mechanism> {

    private List<SortWrapper<Mechanism>> taskHolder = new ArrayList<>();
    private int taskRunNow = 0;
    private final int MAX_TASK_COUNT = 3;

    private GetSortedList<Mechanism> getSortedList;


    private void checkIfNeedStart() {
        if (taskRunNow > 0) {
            return;
        }

        if (taskHolder.size() >= MAX_TASK_COUNT) {
            startTasks();
        }
    }


    private void startTasks() {
        taskRunNow = MAX_TASK_COUNT;
        for (int i = 0; i < MAX_TASK_COUNT; i++) {
            final SortWrapper<Mechanism> wrapper = taskHolder.get(i);
            startTask(taskHolder.get(i).getBaseSortedClass(), new Runnable() {
                @Override
                public void run() {
                    getSortedList.get(wrapper.getId(),wrapper.getBaseSortedClass().getList());
                    taskHolder.remove(wrapper);
                    taskRunNow--;
                    checkIfNeedStart();
                }
            });
        }
    }


    private void startTask(final BaseSortedClass baseSortedClass, final Runnable finish) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    baseSortedClass.sort();
                }catch (Exception ignored){}
                new Handler(Looper.getMainLooper()).post(finish);

            }
        }).start();
    }


    @Override
    public void sortThis(String id, BaseSortedClass<Mechanism> sortedClass) {
        taskHolder.add(new SortWrapper<>(id, sortedClass));
        checkIfNeedStart();
    }

    @Override
    public void sortIsReady(GetSortedList<Mechanism> getSortedList) {
        this.getSortedList = getSortedList;
    }


}
