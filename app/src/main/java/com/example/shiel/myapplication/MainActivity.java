package com.example.shiel.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView gcfView;
    EditText text1, text2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        this.gcfView = (TextView) findViewById( R.id.gcfView );
        this.text1 = (EditText) findViewById( R.id.number1Text);
        this.text2 = (EditText) findViewById( R.id.number2Text);
        this.button = (Button) findViewById( R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int m1 = Integer.parseInt( text1.getText().toString() );
                    int m2 = Integer.parseInt( text2.getText().toString() );
                    int r;

                    if( m1<m2 ) { r = m1; m1 = m2; m2 = r; }
                    System.out.println("("+m1+", "+m2+")");

                    while( m1%m2!=0 ) {
                        r = m1%m2;
                        m1 = m2;
                        m2 = r;
                        System.out.println("("+m1+", "+m2+")");
                    }

                    gcfView.setText( Integer.toString(m2) );

                } catch(Exception exception) {
                    System.out.println(exception.getMessage());
                    gcfView.setText( "Invalid Input" );
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
