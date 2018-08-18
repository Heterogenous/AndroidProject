package com.example.rememberword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 89524 on 2018/4/23.
 */

public class Look_word_adapter extends ArrayAdapter<SaveWord> {
    private int resourceId;
    public Look_word_adapter(Context context, int resource, List<SaveWord> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        SaveWord saveWord=getItem(position);
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.English_word=(TextView) view.findViewById(R.id.text_view_english);
            viewHolder.Chinese_word=(TextView)view.findViewById(R.id.text_view_chinese);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
            viewHolder.English_word.setText(saveWord.getEnglish());
            viewHolder.Chinese_word.setText(saveWord.getChinese());
        return view;
    }
    class ViewHolder{
       TextView English_word,Chinese_word;
    }
}
