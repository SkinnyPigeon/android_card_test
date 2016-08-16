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
public class TestCards extends AppCompatActivity{

    private String dealtCard;
    private ArrayList<String>cards;
    private ArrayList<String>shuffledCards;
    Button mMatch;



    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
        TextView cards = (TextView)findViewById( R.id.cardview );
        mMatch = ( Button )findViewById( R.id.match_button );


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

        final String playerCardOne = deal();
        final String playerCardTwo = deal();
        String playerCards =  playerCardOne + " " + playerCardTwo;
        cards.setText( playerCards );

        mMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TestCards.this, Logic.class );
                intent.putExtra( "first_card", playerCardOne );
                intent.putExtra( "second_card", playerCardTwo );
                startActivity( intent );
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
