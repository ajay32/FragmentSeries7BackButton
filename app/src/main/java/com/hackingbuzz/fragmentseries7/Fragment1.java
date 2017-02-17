package com.hackingbuzz.fragmentseries7;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Avi Hacker on 2/17/2017.
 */

public class Fragment1 extends Fragment {

    // We should remove a fragment before adding other fragment to our base layout (Activity)
    // in our fragment class we always import fragment from support v4 library...
    // dont take fragmentf rom android.app.Fragment -- always go for v4 library
    // we give tag to a fragment when we call it..
    // in fragment we take getFragmentManager



    private FragmentManager fragmentManager;
    private Fragment fragment;
    Button btn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_1, container, false);  // we got view (our layout in v variable
        init(v);   // creating a method init and passing v ..so now we got view v n with the help of it we can initilize our view components
        return v;
    }


    public void init(View v) {

        fragmentManager = getFragmentManager();  // initilizing in init coz..if we are calling several fragments ..we have to initize fragment manger for all ..callings

         btn = (Button) v.findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // removing fragment 1 before adding 2nd
                fragment = fragmentManager.findFragmentByTag("frag1");         // you gonna find a fragment by a tag ..u defined that in acitivty when you called that fragment
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (fragment != null) {
                    fragmentTransaction.remove(fragment);    // remove Transaction
                }

                // now calling and adding another fragment after remove its parent fragment (where you are calling fragmetn from)  fragment to fragment call
                fragment = new Fragment2();
                fragmentTransaction.add(R.id.base_layout, fragment, "frag2");    //giving tag to fragment
                fragmentTransaction.commit();
            }
        });
    }


}
