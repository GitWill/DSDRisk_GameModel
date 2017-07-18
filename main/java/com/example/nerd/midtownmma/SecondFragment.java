package com.example.nerd.midtownmma;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nerd on 7/16/2017.
 */

public class SecondFragment extends Fragment {
    private ImageView eventImg;
    private ImageView seasonImg;
    private TextView venuDeets;
    private TextView ticketDeets;
    private TextView outsideDeets;
    private TextView disclaimerDeets;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        //coMainButton = (Button)view.findViewById(R.id.coMainButton);

        eventImg = (ImageView) view.findViewById(R.id.imageViewEvent);
        seasonImg = (ImageView) view.findViewById(R.id.imageViewSeason);
        ticketDeets = (TextView) view.findViewById(R.id.textViewTicketDeets);
        outsideDeets = (TextView) view.findViewById(R.id.textViewOutsideDeets);
        venuDeets = (TextView) view.findViewById(R.id.textViewVenueDeets);
        disclaimerDeets = (TextView) view.findViewById(R.id.textViewDisclaimerDeets);


        // Log.d(WILLS, "in oncreatview second fragment");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

}

    public void winterClicked(){
        //if(twoPain)
        //packageDeets.setText(R.string.winter_text_second_frag);
    }
    public void springClicked(){
        //packageDeets.setText(R.string.spring_text_second_frag);
    }
    public void summerClicked(){
        //packageDeets.setText(R.string.summer_text_second_frag);
    }
    public void fallClicked(){
        //packageDeets.setText(R.string.fall_text_second_frag);
    }
    public void setImg(){
        Activity activity = getActivity();
        //imageView = (ImageView) activity
    }

    public void setInfo(int buttonID, String cost){                 //this is only called for small screen, or from the second activity
        if(buttonID == R.id.mainButton){                            //if the main event button was selected
            eventImg.setImageResource(R.drawable.main);
            venuDeets.setText(R.string.main_venu_deets);
            ticketDeets.setText(R.string.main_ticket_deets);
            outsideDeets.setText(R.string.main_outside_deets);
            disclaimerDeets.setText(R.string.disclaimer_deets);
        }else if (buttonID == R.id.coMainButton){                   //else if the co-main event button was selected
            eventImg.setImageResource(R.drawable.comain);
            venuDeets.setText(R.string.co_main_venu_deets);
            ticketDeets.setText(R.string.co_main_ticket_deets);
            outsideDeets.setText(R.string.co_main_outside_deets);
            disclaimerDeets.setText(R.string.disclaimer_deets);
        }else if (buttonID == R.id.logoButton){                     //else if the logo button was selected
            eventImg.setImageResource(R.drawable.logo);
            venuDeets.setText(R.string.logo_venu_deets);
            ticketDeets.setText(R.string.logo_ticket_deets);
            outsideDeets.setText(R.string.logo_outside_deets);
            disclaimerDeets.setText(R.string.disclaimer_deets);
        }else if (buttonID == R.id.boothButton){
            eventImg.setImageResource(R.drawable.booth);
            venuDeets.setText(R.string.booth_venu_deets);
            ticketDeets.setText(R.string.booth_ticket_deets);
            outsideDeets.setText(R.string.booth_outside_deets);
            disclaimerDeets.setText(R.string.bring_booth_deets);//else if the booth button was selected

        }

        //use cases for this shizzle

    }
}
