package com.ilyasd.examples.viewpagerexample;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View L_view = inflater.inflate(R.layout.viewerpage_fragment1,container,false);



    TextView L_firstName = L_view.findViewById(R.id.first_name);
    TextView L_lastName = L_view.findViewById(R.id.last_name);
    TextView L_personID = L_view.findViewById(R.id.person_id);
    TextView L_age = L_view.findViewById(R.id.age);
    TextView L_phone = L_view.findViewById(R.id.phone_num);


    L_firstName.setText(getArguments().getString("FirstName"));
    L_lastName.setText(getArguments().getString("LastName"));
    L_age.setText(getArguments().getString("Age"));
    L_personID.setText(getArguments().getString("IDNum"));
    L_phone.setText(getArguments().getString("PhoneNumber"));
    Log.d("Fragment Class","Arguments Test : "+getArguments().getString("FirstName"));



        return L_view;

    }
    public static Fragment getInstance (Bundle data ){
        Log.d("Fragment Class","New Fragment");
        Fragment L_customFragment =new Fragment1();
        L_customFragment.setArguments(data);

        return L_customFragment;


    }
}
