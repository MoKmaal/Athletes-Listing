package com.blink.mohammed.athleteslisting;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 *  Activity that show the listView
 *  init widgets, Setting URL, start Asynctask, and retrieve data from it through AsyncResponce interface
 *  adding itemclicklistener to list to show fragment that contains player details
 *  passing details encapsulated in bundle as argument to Fragment
 *
 */
public class MainActivity extends Activity {
    ListView lvItems;
    ListAdapter listAdapter;
    ArrayList<Athletes> athletesArrayList;

    MyAsyncTask task;

    final static String  URL = "https://gist.githubusercontent.com/Bassem-Samy" +
                               "/f227855df4d197d3737c304e9377c4d4/raw/" +
                               "ece2a30b16a77ee58091886bf6d3445946e10a23/athletes.josn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        runService(URL);




        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager= getFragmentManager();
                PopupFragment playerDetails = new PopupFragment();

                Bundle bundle = new Bundle();
                bundle.putString("name",athletesArrayList.get(position).getAthleteName());
                bundle.putString("img",athletesArrayList.get(position).getAthleteImage());
                bundle.putString("brief",athletesArrayList.get(position).getAthleteBrief());
                playerDetails.setArguments(bundle);

                playerDetails.show(fragmentManager,"data");

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        task.cancel(true);

    }

    public void initializeComponents() {
        lvItems = (ListView) findViewById(R.id.listView);

    }

    public void runService(String URL) {

         task = new MyAsyncTask(getApplicationContext(), new AsyncResponse() {
            @Override
            public void processFinish(Object output) {
                athletesArrayList = (ArrayList<Athletes>) output;
                listAdapter = new ListAdapter(getApplicationContext(),athletesArrayList);
                lvItems.setAdapter(listAdapter);

            }
        });
        task.execute(URL);
    }




}
