package com.example.rememberword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 89524 on 2018/4/24.
 */

public class Write_finish_errorWord_adapter extends ArrayAdapter<SaveErrorWord>{
    int resourceId;
    public Write_finish_errorWord_adapter(Context context, int resource, List<SaveErrorWord> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        SaveErrorWord saveErrorWord=getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(R.layout.show_write_error_layout,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.showError=(TextView)view.findViewById(R.id.show_error_write);
            viewHolder.showRight=(TextView)view.findViewById(R.id.show_right_write);
            viewHolder.showChinese=(TextView)view.findViewById(R.id.show_chinese_write);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.showError.setText(saveErrorWord.getErrorEnglish());
        viewHolder.showRight.setText(saveErrorWord.getEnglish());
        viewHolder.showChinese.setText(saveErrorWord.getChinese());
        return view;
    }
    class ViewHolder{
        TextView showError,showRight,showChinese;
    }
}
