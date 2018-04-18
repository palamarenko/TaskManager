package ua.android.cozy.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import ua.android.cozy.myapplication.pojo.BusMechnism;
import ua.android.cozy.myapplication.pojo.CarMechnism;
import ua.android.cozy.myapplication.pojo.CargoMechnism;
import ua.android.cozy.myapplication.pojo.Mechanism;
import ua.android.cozy.myapplication.pojo.sorted.SortedClass;
import ua.android.cozy.myapplication.recycler.MyAdapter;
import ua.android.cozy.myapplication.thread_manager.GetSortedList;

public class ThreadManagerActivity extends AppCompatActivity implements GetSortedList<Mechanism> {


    private MyAdapter adapter = new MyAdapter();
    private TaskService taskService;
    private boolean mBound = false;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, TaskService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_manager);
        initRecycler();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mBound){
                    taskService.sortThis(UUID.randomUUID().toString(), new SortedClass(generationRandomList()));
                }
            }
        });
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private List<Mechanism> generationRandomList() {
        List<Mechanism> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(getRandomMechanism());
        }
        return list;
    }

    private Mechanism getRandomMechanism() {
        int random = new Random().nextInt(3);

        String randomText = "Название представленной марки машин происходит от имени дочери одного из спортивных гонщиков Емиля Еллиника, который регулярно заказывал модели у Daimler». Одна из первых машин того времени настолько понравилась Еллиника, что тот решил дать ей имя своей дочери Мерседес. Впоследствии две корпорации «Daimler» и «Benz» объединились, что привело к современному названию данной марки немецких автомобилей. Некоторые автомобильные логотипы родились гораздо раньше, чем началась эра процветания самих автомобильных марок. Считается, что логотип машин Mers(трехлучевая звезда) символизирует то, что двигатели этой компании используются на небе, на земле и в воде. Однако впервые автомобильная эмблема Mersedes упоминается в письме Готтлиба Даймблера к своей жене. Будущим автомобильным логотипом Готтлиб обозначил место нового дома в городе Дойтц и подписал, что когда-нибудь эта звезда будет красоваться над крышей его автомобильного завода, символизируя процветания. Так и случилось, может дело и не удачном логотипе на авто, но марка автомобилей Mersedes процветает и по сей день.";
        String randomTitle = randomText.split(" ")[new Random().nextInt(randomText.split(" ").length - 1)];

        switch (random) {
            case 0:
                return new BusMechnism(randomTitle);
            case 1:
                return new CargoMechnism(randomTitle);
            case 2:
                return new CarMechnism(randomTitle);
        }
        return new CarMechnism(randomTitle);

    }


    @Override
    public void get(String id, List<Mechanism> t) {
        adapter.updateList(t);
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            TaskService.LocalBinder binder = (TaskService.LocalBinder) service;
            taskService = binder.getService();
            taskService.sortIsReady(ThreadManagerActivity.this);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

}
