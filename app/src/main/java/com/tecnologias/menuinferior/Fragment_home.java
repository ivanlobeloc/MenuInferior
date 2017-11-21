package com.tecnologias.menuinferior;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_home extends Fragment {

    //ViewPager
    ViewPager viewPager;
    CustomSwipeAadapter adapter;

    public Fragment_home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        //ViewPager
        viewPager = (ViewPager)v.findViewById(R.id.view_pager);
        adapter = new CustomSwipeAadapter(getContext());
        viewPager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 3000, 4000);

        return v;
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            if(getActivity() != null) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(viewPager.getCurrentItem()==0){
                            viewPager.setCurrentItem(1);
                            //viewPager.setCurrentItem(1, true);
                        }else if(viewPager.getCurrentItem()==1){
                            viewPager.setCurrentItem(2);
                            //viewPager.setCurrentItem(2, true);
                        }else if(viewPager.getCurrentItem()==2){
                            viewPager.setCurrentItem(0);
                            //viewPager.setCurrentItem(0, true);
                        }
                    }
                });

            }

        }
    }

}
