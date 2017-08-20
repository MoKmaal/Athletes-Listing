package com.blink.mohammed.athleteslisting;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by mohammed on 20/08/17.
 *
 * initialize widgets, create fragment view
 * getting argument sent by MainActivity according to item position
 * using picasso Image loader library
 * and make brief textView scrollable
 *
 */

public class PopupFragment extends DialogFragment {
    TextView tv_name;
    TextView tv_desc;
    ImageView iv_img;
    String name;
    String image;
    String brief;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.detail_fragment,null);
        initializeComponents(v);

         name = getArguments().getString("name");
         image = getArguments().getString("img");
         brief = getArguments().getString("brief");

         tv_name.setText(name);

        if(image.length()>0) {
            Picasso.with(getActivity().getApplicationContext()).load(image).into(iv_img);
        }

        tv_desc.setText(brief);
        tv_desc.setMovementMethod(new ScrollingMovementMethod());


        return v;
    }


    public void initializeComponents(View v) {
        tv_name = (TextView) v.findViewById(R.id.frag_athlete_name);
        tv_desc = (TextView) v.findViewById(R.id.frag_details);
        iv_img  = (ImageView) v.findViewById(R.id.frag_athlete_img);
    }
}
