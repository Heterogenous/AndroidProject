package com.example.rememberword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 89524 on 2018/4/23.
 */

public class Look_word extends AppCompatActivity {

    SaveWordList wordList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_word_layout);
        wordList=new SaveWordList();
        ListView listView=(ListView)findViewById(R.id.look_word_list);
        Button back=(Button)findViewById(R.id.look_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Look_word.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Look_word_adapter adapter=new Look_word_adapter(Look_word.this,R.layout.word_items_layout,wordList.saveWordList);
        listView.setAdapter(adapter);
    }
}
