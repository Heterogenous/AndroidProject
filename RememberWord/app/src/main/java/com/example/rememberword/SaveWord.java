package com.example.rememberword;

/**
 * Created by 89524 on 2018/4/23.
 */

public class SaveWord {
    private String English;
    private String Chinese;

    public SaveWord(String English,String Chinese){
        this.English=English;
        this.Chinese=Chinese;
    }
    public String getEnglish(){
        return English;
    }
    public String getChinese(){
        return Chinese;
    }
}
