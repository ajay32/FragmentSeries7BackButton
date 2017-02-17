package com.hackingbuzz.fragmentseries7;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // What this code really show is when you reach at 2nd fragment and press back button it just goes off the screen (like we are on our only acitivty and pressed back button)
    // means our 2nd fragment is on top of main activty..so it just dont conside the any fragment and goes off from activity

    // it shoud first remove fragment2  then shoud come down to fragment1 and then at activitiy and when we press back again at acitivity it shoud go off the screen




  // When we use AppCompatActivity we get Fragment manger from getSupportFragmentManager
    // fragment from support v4 library

    Fragment fragment;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        button.setVisibility(View.GONE);


        fragment = new Fragment1();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.base_layout, fragment, "frag1");   // third parament -- giving tag to our fragment so that we can use it in future to add or remove this fragment
        fragmentTransaction.commit();
    }
}
