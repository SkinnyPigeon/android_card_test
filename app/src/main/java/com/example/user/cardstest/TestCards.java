package com.example.user.cardstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 16/08/2016.
 */
public class TestCards extends AppCompatActivity{

    private String dealtCard;
    private ArrayList<String>cards;
    private ArrayList<String>shuffledCards;



    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_cards);
        TextView cards = (TextView)findViewById( R.id.cardview );


        this.cards = new ArrayList<String>();

        this.cards.add( "AS" );
        this.cards.add( "AH" );
        this.cards.add( "AC" );
        this.cards.add( "AD" );

        this.dealtCard = dealtCard;

        shuffle();
        cards.setText( deal() );

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



}
