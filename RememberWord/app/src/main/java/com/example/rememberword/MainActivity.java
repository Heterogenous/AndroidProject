package com.example.rememberword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button look_btn=(Button)findViewById(R.id.look_word);
        Button write_btn=(Button)findViewById(R.id.write_word);
        look_btn.setOnClickListener(this);
        write_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.look_word:
                Intent intent=new Intent(MainActivity.this,Look_word.class);
                startActivity(intent);
                break;
            case R.id.write_word:
                Intent intent1=new Intent(MainActivity.this,Write_word_select.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
