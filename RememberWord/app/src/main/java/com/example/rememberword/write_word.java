package com.example.rememberword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 89524 on 2018/4/23.
 */

public class write_word extends AppCompatActivity {

    List<SaveWord> list=new ArrayList<>();
    ArrayList<Integer> position;
    int totalAmount;
    EditText editText;
    TextView textView,textViewShowTotal;
    SaveWordList wordList=new SaveWordList();
    ArrayList<String> errorWordsList=new ArrayList<>();
    ArrayList<Integer> errorIdList=new ArrayList<>();
    int i=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_word_layout);

        textViewShowTotal = (TextView) findViewById(R.id.write_word_show_total);
        Button btnOk=(Button)findViewById(R.id.write_word_ok);
        editText=(EditText)findViewById(R.id.write_word_edit);
        textView=(TextView)findViewById(R.id.show_chinese);

        Intent intent=getIntent();
        if(intent.getIntegerArrayListExtra("position")!=null){
            position=intent.getIntegerArrayListExtra("position");
            for(int j=0;j<position.size();j++){
                list.add(wordList.saveWordList.get(position.get(j)));
            }
        }else {
            list=wordList.saveWordList;
            //textViewShowTotal.setText("1/" + list.size());
        }
        totalAmount=list.size();
        textViewShowTotal.setText("1/" + totalAmount);
        textView.setText(list.get(i).getChinese());
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= String.valueOf(editText.getText());
                if (i == list.size()){
                    Intent intent=new Intent(v.getContext(),Write_finish.class);
                    intent.putStringArrayListExtra("errorWordsList",errorWordsList);
                    intent.putIntegerArrayListExtra("errorIdList",errorIdList);
                    intent.putExtra("totalAmount",totalAmount);
                    v.getContext().startActivity(intent);
                    finish();
                }
                else {
                    if (!"".equals(a) && !a.equals(list.get(i).getEnglish())) {
                        //当单词错误时,执行下面语句
                        //找到list中原索引的位置
                        int t=0;
                        if(position!=null) {
                            for (int j = 0; j < position.size(); j++) {
                                if (list.get(i).getEnglish().equals(wordList.saveWordList.get(position.get(j)).getEnglish())) {
                                    t = position.get(j);
                                    break;
                                }
                            }
                        }else{
                            t=i;
                        }
                        errorIdList.add(t);
                        errorWordsList.add(String.valueOf(editText.getText()));
                    }
                    if("".equals(a)){
                        //当editText为空时,执行下面语句
                        Toast.makeText(v.getContext(), "请填写英文单词", Toast.LENGTH_SHORT).show();
                    }
                    //只有当editText不为空的时候才执行下面操作
                    if (!"".equals(a)) {
                        editText.setText("");
                        i++;
                        if (i == list.size())
                            textView.setText("恭喜您完成默写单词!请点击确定查看默写情况!");
                        if (i < list.size()) {
                            textView.setText(list.get(i).getChinese());
                            textViewShowTotal.setText((i + 1) + "/" + totalAmount);
                        }
                    }
                }
            }
        });
    }
}
