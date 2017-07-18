package com.example.nerd.midtownmma;

import android.app.Activity;
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
        setContentView(R.layout.activity_main);//set the content view for the layout
        mainFrag = (MainFragment) getFragmentManager().findFragmentById(R.id.fragment_main);
        secondFrag = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment_Second);

    }

    public void setSecondFrag(int buttonID){    //called from first frag when the screen is big
        secondFrag.setInfo(buttonID);           //tell the second frag what to display
    }



    public void onRadioButtonClicked(View view) {               //this changes the prices according to the season

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.winterButton:
                if (checked)
                    mainFrag.setSelectedPrices("winter");
                 break;
            case R.id.springButton:
                if (checked)
                    mainFrag.setSelectedPrices("spring");
                    break;
            case R.id.summerButton:
                if (checked)
                    mainFrag.setSelectedPrices("summer");
                    break;
            case R.id.fallButton:
                if (checked)
                    mainFrag.setSelectedPrices("fall");
                    break;
        }
    }

}