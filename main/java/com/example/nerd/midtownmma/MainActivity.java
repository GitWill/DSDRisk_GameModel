package com.example.nerd.midtownmma;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    MainFragment mainFrag;
    SecondFragment secondFrag;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the view layout for the activity using XML
        setContentView(R.layout.activity_main);//THIS IS THE LINE I SCHANGED
        //frag = (MainFragment) getFragmentManager().findFragmentById();
        mainFrag = (MainFragment) getFragmentManager().findFragmentById(R.id.fragment_main);
        secondFrag = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment_Second);

    }
    public Activity getActivity(){
        return this;
    }

    public void setSecondFrag(int buttonID, String cost){
        secondFrag.setInfo(buttonID,cost);
    }



    public void onRadioButtonClicked(View view) {

        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.winterButton:
                if (checked)
                    mainFrag.setSelectedPrices("winter");
                    if(secondFrag != null){
                        secondFrag.winterClicked();
                    }
                    Toast.makeText(this, "winter", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.springButton:
                if (checked)
                    mainFrag.setSelectedPrices("spring");
                    if(secondFrag != null){
                        secondFrag.springClicked();
                    }
                    Toast.makeText(this, "spring", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.summerButton:
                if (checked)
                    mainFrag.setSelectedPrices("summer");
                    if(secondFrag != null) {                        //if on big screen
                        secondFrag.summerClicked();                 //update second fragment
                    }else{
                        mainFrag.setButtonID(R.id.summerButton);
                    }
                    Toast.makeText(this, "summer", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.fallButton:
                if (checked)
                    mainFrag.setSelectedPrices("fall");
                    if(secondFrag != null) {
                        secondFrag.fallClicked();
                    }
                    Toast.makeText(this, "fall", Toast.LENGTH_SHORT).show();
                    break;
        }
    }

}