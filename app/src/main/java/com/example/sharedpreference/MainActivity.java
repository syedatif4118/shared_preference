package com.example.sharedpreference;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button red,blue,green;
    ConstraintLayout layout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = findViewById(R.id.button);
        blue = findViewById(R.id.button2);
        green = findViewById(R.id.button3);
        layout = findViewById(R.id.cl);
        layout.setBackgroundColor(getColor());
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolor(getResources().getColor(R.color.red));
                layout.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolor(getResources().getColor(R.color.green));
                layout.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setcolor(getResources().getColor(R.color.blue));
                layout.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });
    }
    private void setcolor(int color) {
        sharedPreferences = getSharedPreferences("myPreference",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("colorkey",color);
        editor.apply();
    }
    private int getColor() {
        int color = 0;
        sharedPreferences = getSharedPreferences("myPreference",MODE_PRIVATE);
        color=sharedPreferences.getInt("colorkey",0);
        return color;
    }
}