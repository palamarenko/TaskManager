package ua.android.cozy.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.UUID;

import ua.android.cozy.myapplication.pojo.Mechanism;
import ua.android.cozy.myapplication.pojo.sorted.BaseSortedClass;
import ua.android.cozy.myapplication.pojo.sorted.SortedClass;
import ua.android.cozy.myapplication.thread_manager.GetSortedList;
import ua.android.cozy.myapplication.thread_manager.TaskManager;
import ua.android.cozy.myapplication.thread_manager.TaskMangerImp;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 16:44
 */

public class TaskService extends Service {

    private final IBinder mBinder = new LocalBinder();
    private TaskManager<Mechanism> manager = new TaskMangerImp();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;

    }


    public class LocalBinder extends Binder {
        TaskService getService() {return TaskService.this;}
    }


    public void sortThis(String id, BaseSortedClass<Mechanism> baseSortedClass){
        manager.sortThis(id, baseSortedClass);
    }

    public void sortIsReady(GetSortedList<Mechanism> getSortedList){
        manager.sortIsReady(getSortedList);
    }





}
