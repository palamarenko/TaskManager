package ua.android.cozy.myapplication.pojo.sorted;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.android.cozy.myapplication.pojo.Mechanism;

/**
 * Created by Palamarenko Andrey on
 * 18.04.2018 15:52
 */

public class SortedClass  extends BaseSortedClass<Mechanism>{


    public SortedClass(List<Mechanism> list) {
        super(list);
    }

    @Override
    public void sort() throws InterruptedException {

        Collections.sort(list, new Comparator<Mechanism>() {
            @Override
            public int compare(Mechanism mechanism, Mechanism t1) {
                return mechanism.getName().compareToIgnoreCase(t1.getName());
            }
        });

    }
}
