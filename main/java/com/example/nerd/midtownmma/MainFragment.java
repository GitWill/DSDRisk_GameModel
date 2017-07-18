package com.example.nerd.midtownmma;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nerd on 7/16/2017.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    ///  GET REFS TO UI ELEMENTS
    //p1NameTextView = (TextView) activity.findViewById(R.id.playerOneTextView);

    private boolean twoPaneLayout;
    private TextView mainEventPriceTextView;
    private TextView coMainPriceTextView;
    private TextView logoPriceTextView;
    private TextView boothPriceTextView;
    private Button mainButton;
    private Button coMainButton;
    private Button logoButton;
    private Button boothButton;
    private RadioGroup radioGroup;
    private Intent intent;
    private int buttonID;
    MainActivity mainActivity;

    public void setButtonID(int buttonIDIn){
        buttonID = buttonIDIn;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the view for this fragment
       final  View view = inflater.inflate(R.layout.fragment_main, container, false);

        //set this fragment to listen to the new game button
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        mainButton = (Button)view.findViewById(R.id.mainButton);
        coMainButton = (Button)view.findViewById(R.id.coMainButton);
        logoButton = (Button)view.findViewById(R.id.logoButton);
        boothButton = (Button)view.findViewById(R.id.boothButton);
        mainButton.setOnClickListener(this);  // this class implements the listener
        coMainButton.setOnClickListener(this);  // this class implements the listener
        logoButton.setOnClickListener(this);  // this class implements the listener
        boothButton.setOnClickListener(this);  // this class implements the listener


        //Log.d(WILLS, "in onActivityCreated in first frag");

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Log.d(WILLS, "in onActivityCreated in first frag");

        // Get a references from the host activity
        mainActivity = (MainActivity)getActivity();
        mainEventPriceTextView = (TextView) mainActivity.findViewById(R.id.mainEventCostTextView);
        coMainPriceTextView = (TextView) mainActivity.findViewById(R.id.coMainEventCostTextView);
        logoPriceTextView = (TextView) mainActivity.findViewById(R.id.logoCostTextView);
        boothPriceTextView = (TextView) mainActivity.findViewById(R.id.boothCostTextView);

        // Check to see if FirstActivity has loaded a single or dual pane layout
        twoPaneLayout = mainActivity.findViewById(R.id.fragment_Second) != null;
    }

    public void setSelectedPrices(String season){
        if(season.equals("winter")){
            mainEventPriceTextView.setText(R.string.main_price_winter);
            coMainPriceTextView.setText(R.string.co_main_price_winter);
            logoPriceTextView.setText(R.string.logo_price_winter);
            boothPriceTextView.setText(R.string.booth_price_winter);
        }else if(season.equals("summer")){
            mainEventPriceTextView.setText(R.string.main_price_summer);
            coMainPriceTextView.setText(R.string.co_main_price_summer);
            logoPriceTextView.setText(R.string.logo_price_summer);
            boothPriceTextView.setText(R.string.booth_price_summer);
        }else if(season.equals("spring")){
            mainEventPriceTextView.setText(R.string.main_price_spring);
            coMainPriceTextView.setText(R.string.co_main_price_spring);
            logoPriceTextView.setText(R.string.logo_price_spring);
            boothPriceTextView.setText(R.string.booth_price_spring);
        }else if(season.equals("fall")){
            mainEventPriceTextView.setText(R.string.main_price_fall);
            coMainPriceTextView.setText(R.string.co_main_price_fall);
            logoPriceTextView.setText(R.string.logo_price_fall);
            boothPriceTextView.setText(R.string.booth_price_fall);
        }
    }

    public void saveIntentStartActivity(){
        intent = new Intent(getActivity(), SecondActivity.class);
        intent.putExtra("buttonID", buttonID);  // send state to 2nd activity
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        buttonID = v.getId();
        if(buttonID == R.id.mainButton){                       //if the user clickes the new game button
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setSecondFrag(buttonID);
            }else{
                saveIntentStartActivity();
            }
        }else if(buttonID == R.id.coMainButton){
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setSecondFrag(buttonID);
            }else{
                saveIntentStartActivity();
            }
        }else if(buttonID == R.id.logoButton){
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setSecondFrag(buttonID);
            }else{
                saveIntentStartActivity();
            }
        }else if(buttonID == R.id.boothButton){
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setSecondFrag(buttonID);
            }else{
                saveIntentStartActivity();
            }
        }
    }
}

