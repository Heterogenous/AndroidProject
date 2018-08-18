package com.example.rememberword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 89524 on 2018/4/28.
 */

public class Select_part_word extends AppCompatActivity {

//    Map selectMap=new LinkedHashMap();
    SaveWordList saveWordList=new SaveWordList();
    Select_part_word_adapter adapter;
    CheckedTextView checkedTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_part_word);
        adapter=new Select_part_word_adapter(Select_part_word.this,R.layout.select_layout,saveWordList.saveWordList);
        checkedTextView=(CheckedTextView)findViewById(R.id.check_tv);
        final ListView listView=(ListView)findViewById(R.id.part_word_list_view);
        listView.setAdapter(adapter);
        Button btn_ok=(Button)findViewById(R.id.btn_part_word_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.selectMap.isEmpty()){
                    //Log.d("Test:","null");
                    Toast.makeText(v.getContext(),"请选择需要默写的单词",Toast.LENGTH_SHORT).show();
                }
                else{
                    //Log.d("Test:","not null");
                    ArrayList<Integer> position=new ArrayList<>();
                    Set keySet=adapter.selectMap.keySet();
                    Iterator it=keySet.iterator();
                    while(it.hasNext()){
                        position.add((Integer) it.next());
                    }
                    Intent intent=new Intent(Select_part_word.this,write_word.class);
                    intent.putIntegerArrayListExtra("position",position);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
