package com.ilyasd.examples.viewpagerexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.LoginFilter;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

    private int M_pageNumber =1 ;
    final private Bundle M_ILYASD =new Bundle();
    private Bundle M_data;
    final static int S_REQ_CODE =1212;
    private ViewPager M_viewPager;
    private fragmentAdapter M_fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        M_ILYASD.putString("FirstName","ILYASD");
        M_ILYASD.putString("LastName","Krizou");
        M_ILYASD.putString("Age","20");
        M_ILYASD.putString("IDNum","123456789");
        M_ILYASD.putString("PhoneNumber","0772957821");
        M_viewPager = findViewById(R.id.main_viewPager);
        M_fragmentAdapter = new fragmentAdapter(getSupportFragmentManager());
        M_viewPager.setAdapter(M_fragmentAdapter);
    }

    public void addPerson (View v)
    {
        M_data=null;
        Intent L_person =new Intent(this,PersonAdder.class);
       startActivityForResult(L_person, S_REQ_CODE);
    }

    @Override
    public void onBackPressed() {

        if(M_viewPager.getCurrentItem() >0) {
            M_viewPager.setCurrentItem(M_viewPager.getCurrentItem() - 1);
        }else{
        AlertDialog.Builder L_alertDialog = new AlertDialog.Builder(this);
        L_alertDialog.setTitle("Confirmation");
        L_alertDialog.setMessage("Are U Sure to EXIT !");
        L_alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();   }
        });
        L_alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        L_alertDialog.show();}

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("result&reqCode","result : "+resultCode+" reqCode : "+ requestCode);
        if(data!= null && requestCode== S_REQ_CODE) {
            M_data = data.getExtras();
            Log.i("onActivityResult Check",M_data.getString("FirstName"));
            addFragment();
        }
    }

    public void addFragment ()
    {
        M_pageNumber++;
        M_viewPager.setAdapter(M_fragmentAdapter);
        Log.i("Fragment Check","addFragment");


    }

    public void nextFrag(View view) {
        if(M_viewPager.getCurrentItem()<M_pageNumber)
        M_viewPager.setCurrentItem(M_viewPager.getCurrentItem()+1);
    }

    public void prevFrag(View view) {
        if(M_viewPager.getCurrentItem() >=0)
            M_viewPager.setCurrentItem(M_viewPager.getCurrentItem()-1);
    }

    public class fragmentAdapter extends FragmentPagerAdapter
    {


        public fragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.i("Position Check", String.valueOf(position));

            switch (position) {
                case 0:
                    return Fragment1.getInstance(M_ILYASD);
                default: {
                        return Fragment1.getInstance(M_data);
                }
            }
                }
                @Override
                public int getCount () {
                    return M_pageNumber;
                }
            }


        }

