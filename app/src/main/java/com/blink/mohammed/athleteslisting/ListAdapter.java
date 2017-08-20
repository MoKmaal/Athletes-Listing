package com.blink.mohammed.athleteslisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammed on 20/08/17.
 *
 * Adapter to create views of list according to its size
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    TextView tvName;
    ImageView ivImg;

    ArrayList<Athletes> athletesAdapter;

    public ListAdapter(Context context, ArrayList<Athletes> athletesAdapter) {
        this.context=context;
        this.athletesAdapter = athletesAdapter;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return athletesAdapter.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_athletes,null);
        Athletes athletes = athletesAdapter.get(position);

        tvName =(TextView) v.findViewById(R.id.tv_athlete_name);
        ivImg = (ImageView) v.findViewById(R.id.iv_athlete_img);

        tvName.setText(athletes.getAthleteName());
        if(athletes.getAthleteImage().length()>0) {
            Picasso.with(context).load(athletes.getAthleteImage()).into(ivImg);
        }
        return v;
    }


}
