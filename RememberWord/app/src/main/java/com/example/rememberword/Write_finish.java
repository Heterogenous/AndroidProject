package com.example.rememberword;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 89524 on 2018/4/24.
 */

public class Write_finish extends AppCompatActivity {
    //SaveWordList wordList;
    int totalAmount;
    Intent intent;
    ArrayList<String> errorWordsList;
    ArrayList<Integer> errorIdList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_finish_layout);
        //获取单词量
        //wordList=new SaveWordList();
        //获取通过Intent传过来的参数
        intent=getIntent();
        //获取总单词的数量
        totalAmount=intent.getIntExtra("totalAmount",totalAmount);
        //获取错误单词原索引
        errorIdList=intent.getIntegerArrayListExtra("errorIdList");
        //获取错误单词
        errorWordsList=intent.getStringArrayListExtra("errorWordsList");
        //获取显示数据的TextView
        TextView textViewTotal=(TextView)findViewById(R.id.write_finish_total);
        TextView textViewRight=(TextView)findViewById(R.id.write_finish_right);
        TextView textViewError=(TextView)findViewById(R.id.write_finish_error);
        TextView textViewShow=(TextView)findViewById(R.id.show_write_error);
        //获取ListView
        ListView listView=(ListView)findViewById(R.id.show_error_word);
        //显示单词总个数
        textViewTotal.setText(String.valueOf(textViewTotal.getText())+totalAmount+"个");
        //显示单词正确个数
        textViewRight.setText(String.valueOf(textViewRight.getText())+(totalAmount-errorWordsList.size())+"个");
        //显示单词错误个数
        textViewError.setText(String.valueOf(textViewError.getText())+errorWordsList.size()+"个");
        //判断是否单词错误个数为0个
        if(errorWordsList.size()==0)textViewShow.setText("");
        //使用错误单词适配器去加载信息到ListView里
        SaveErrorWordList saveErrorWordList=new SaveErrorWordList(errorWordsList,errorIdList);
        Write_finish_errorWord_adapter adapter=new Write_finish_errorWord_adapter(Write_finish.this,R.layout.write_finish_layout,saveErrorWordList.save_word_list);
        listView.setAdapter(adapter);
        Button button=(Button)findViewById(R.id.write_finish_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Write_finish.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
