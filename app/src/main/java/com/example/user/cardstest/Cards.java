package com.example.user.cardstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 16/08/2016.
 */
public class Cards extends AppCompatActivity{

    private String dealtCard;
    private ArrayList<String>cards;
    private ArrayList<String>shuffledCards;
    Button mMatch;
    Button mAgain;



    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        TextView cards = (TextView)findViewById( R.id.cardview );
        mMatch = ( Button )findViewById( R.id.match_button );
        mAgain = ( Button )findViewById( R.id.try_again );


        this.cards = new ArrayList<String>();

        this.cards.add( "A" + getEmijoByUnicode( 0x2660 ) );
        this.cards.add("A" + getEmijoByUnicode(0x2665));
        this.cards.add("A" + getEmijoByUnicode(0x2663));
        this.cards.add( "A" + getEmijoByUnicode( 0x2666 ) );
        this.cards.add( "K" + getEmijoByUnicode( 0x2660 ) );
        this.cards.add( "K" + getEmijoByUnicode( 0x2665 ) );
        this.cards.add( "K" + getEmijoByUnicode( 0x2663 ) );
        this.cards.add( "K" + getEmijoByUnicode( 0x2666 ) );

        this.dealtCard = dealtCard;

        shuffle();

        final String firstCard = deal();
        final String secondCard = deal();
        String playerCards =  firstCard + " " + secondCard;
        cards.setText( playerCards );

        mMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cards.this, Player.class);
                intent.putExtra("first_card", firstCard);
                intent.putExtra("second_card", secondCard);
                startActivity(intent);
            }
        });

        mAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cards.this, Cards.class);
                startActivity(intent);
            }
        });

    }

    public String shuffle() {
        Collections.shuffle(this.cards);
        for( String card : this.cards ) {
            if(card != null) {
            }
        }
        return "Shuffled";
    }

    public void pickCard() {
        this.dealtCard = this.cards.remove(0);
    }

    public String deal() {
        pickCard();
        return this.dealtCard;
    }

    public String getEmijoByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

}
