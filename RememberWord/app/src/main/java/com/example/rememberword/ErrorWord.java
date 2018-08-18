package com.example.rememberword;

/**
 * Created by 89524 on 2018/4/24.
 */

public class ErrorWord {
    private int id;
    private String word;

    public ErrorWord(int id,String word){
        this.id=id;
        this.word=word;
    }
    public int getId(){
        return id;
    }
    public String getWord(){
        return word;
    }
}
