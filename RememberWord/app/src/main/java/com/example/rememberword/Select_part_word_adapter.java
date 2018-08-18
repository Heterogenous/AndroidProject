package com.example.rememberword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 89524 on 2018/4/29.
 */

public class Select_part_word_adapter extends ArrayAdapter<SaveWord> {

    private int resourceId;
    public Map selectMap=new LinkedHashMap();

    public Select_part_word_adapter(Context context, int resource, List<SaveWord> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHolder viewHolder;
        final SaveWord saveWord=getItem(position);
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView)view.findViewById(R.id.check_english);
            viewHolder.checkedTextView=(CheckedTextView)view.findViewById(R.id.check_tv);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(saveWord.getEnglish());
        viewHolder.checkedTextView.setText(saveWord.getChinese());
//        if(!selectMap.isEmpty()){
//            viewHolder.checkedTextView.setChecked((Boolean) selectMap.get(position));
//        }
        //下面代码解决getView()该方法每次调用使选择出现多个复选的bug
        if(selectMap.get(position)==null){
            viewHolder.checkedTextView.setChecked(false);
        }else{
            viewHolder.checkedTextView.setChecked(true);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.checkedTextView.toggle();
                if(viewHolder.checkedTextView.isChecked()){
                    selectMap.put(position,true);
                }else{
                    selectMap.remove(position);
                }
            }
        });
        return view;
    }
    private class ViewHolder{
        CheckedTextView checkedTextView;
        TextView textView;
    }
}
