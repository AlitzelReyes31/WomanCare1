package com.example.womancare;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class TresActivity extends AppCompatActivity {

    GridLayout mainGridddd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);

        mainGridddd = (GridLayout) findViewById(R.id.mainGridddd);

        //Set Event
        setSingleEvent(mainGridddd);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGridddd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGridddd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGridddd.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor( Color.parseColor("#FF6F00"));
                        Toast.makeText( TresActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText( TresActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGridddd) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGridddd.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGridddd.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if ( finalI ==  0 )
                    {

                        Intent intent = new Intent( TresActivity.this,Paginasuno.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  1 )
                    {

                        Intent intent = new Intent( TresActivity.this,Paginados.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  2)
                    {

                        Intent intent = new Intent( TresActivity.this,Paginatres.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  3)
                    {

                        Intent intent = new Intent( TresActivity.this,Paginacuatro.class);
                        startActivity( intent );
                    }
                    else
                    if ( finalI ==  4 )
                    {

                        Intent intent = new Intent( TresActivity.this,policia.class);
                        startActivity( intent );
                    }else
                    if ( finalI ==  5 )
                    {

                        Intent intent = new Intent( TresActivity.this,psicologo.class);
                        startActivity( intent );
                    }



                }
            });

        }}}