package com.example.user.cardstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 16/08/2016.
 */
public class Player extends AppCompatActivity{

    TextView mCards;
    TextView mCommunity;
    Button mPlay;
    Button mAgain;
    Button mSee;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mPlay = ( Button )findViewById( R.id.play_button );
        mAgain = ( Button )findViewById( R.id.try_again );
        mSee = ( Button )findViewById( R.id.see_button );
        mCommunity = ( TextView )findViewById( R.id.community_cards );
        mCards = ( TextView )findViewById( R.id.player_cards );

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final String firstCard = extras.getString("first_card");
        final String secondCard = extras.getString("second_card");

        final String thirdCard = extras.getString( "third_card" );
        final String fourthCard = extras.getString( "fourth_card" );
        final String fifthCard = extras.getString( "fifth_card" );
//        final String sixthCard = extras.getString( "sixth_card" );
//        final String seventhCard = extras.getString( "seventh_card" );


        String playerCards =  firstCard + " " + secondCard;
        mCards.setText(playerCards);

        mSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String flop = thirdCard + " " + fourthCard + " " + fifthCard;
                mCommunity.setText( flop );
            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Player.this, Logic.class);
                intent.putExtra("first_card", firstCard);
                intent.putExtra("second_card", secondCard);
                startActivity(intent);
            }
        });

        mAgain.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( Player.this, Cards.class);
                startActivity( intent );
            }
        });
    }

}
