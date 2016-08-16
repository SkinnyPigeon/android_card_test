package com.example.user.cardstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by user on 16/08/2016.
 */
public class Logic extends AppCompatActivity{

    TextView mMatched;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);

        mMatched = ( TextView )findViewById( R.id.matched );

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String firstCard = extras.getString( "first_card" );
        String secondCard = extras.getString( "second_card" );

        if( firstCard.charAt(0) == secondCard.charAt(0) ) {
            mMatched.setText( "Pair" );
        } else {
            mMatched.setText( "No Match" );
        }

//        mMatched.setText( firstCard + " " + secondCard );

    }
}
