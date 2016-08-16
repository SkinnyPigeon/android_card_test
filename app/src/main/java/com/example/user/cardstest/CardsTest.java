package com.example.user.cardstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 16/08/2016.
 */
public class CardsTest extends AppCompatActivity{

    Button mDeal;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);

        mDeal = ( Button )findViewById( R.id.deal_button );

        mDeal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d( "CardTest: ", "Deal button clicked");

                Intent intent = new Intent( CardsTest.this, Cards.class );
                startActivity( intent );
            }

        });
    }





}
