package com.example.rememberword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by 89524 on 2018/4/28.
 */

public class Write_word_select extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_word_select_layout);
        Button btn_write_all=(Button)findViewById(R.id.btn_write_all);
        Button btn_write_part=(Button)findViewById(R.id.btn_write_part);
        btn_write_all.setOnClickListener(this);
        btn_write_part.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_write_all:
                //Log.d("Test:","null");
                Intent intent=new Intent(Write_word_select.this,write_word.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_write_part:
                //Log.d("Test:","??????????????????????????????????????");
                Intent intent1=new Intent(Write_word_select.this,Select_part_word.class);
                startActivity(intent1);
                finish();
                break;
            default:
                break;
        }
    }
}
