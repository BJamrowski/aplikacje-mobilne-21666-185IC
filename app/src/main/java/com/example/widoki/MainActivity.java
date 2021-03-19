package com.example.widoki;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void switchClicked(View view){
        boolean on = ((Switch) view).isChecked();

        if (on){
            TextView cat = (TextView)findViewById(R.id.kot);
            cat.setVisibility(View.INVISIBLE);

            TextView dog = (TextView)findViewById(R.id.pies);
            dog.setVisibility(View.VISIBLE);
        }
        else{
            TextView dog = (TextView)findViewById(R.id.pies);
            dog.setVisibility(View.INVISIBLE);

            TextView cat = (TextView)findViewById(R.id.kot);
            cat.setVisibility(View.VISIBLE);
        }

    }

    CharSequence textOn = "Przycisk jest włączony";
    CharSequence textOff = "Przycisk jest wyłączony";
    int duration = Toast.LENGTH_LONG;
    Toast toast;

    public void onToggleClicked(View view){
        boolean on = ((ToggleButton) view).isChecked();

        if (on){
            toast = Toast.makeText(this, textOn, duration);
        }
        else{
            toast = Toast.makeText(this, textOff, duration);
        }

        toast.show();
    }
}