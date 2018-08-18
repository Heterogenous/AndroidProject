package com.example.rememberword;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 89524 on 2018/4/24.
 */

public class SaveErrorWordList {
    ArrayList<String> errorWordsList;
    ArrayList<Integer> errorIdList;
    SaveWordList saveWordList=new SaveWordList();
    public List<SaveErrorWord> save_word_list=new ArrayList<>();

    public SaveErrorWordList(ArrayList<String> errorWordsList,ArrayList<Integer> errorIdList){
        this.errorIdList=errorIdList;
        this.errorWordsList=errorWordsList;
        initSaveErrorWord();
    }
    private void initSaveErrorWord(){
        for(int i=0;i<errorWordsList.size();i++){
            SaveErrorWord saveErrorWord=new SaveErrorWord();
            saveErrorWord.setErrorEnglish(errorWordsList.get(i));
            saveErrorWord.setEnglish(saveWordList.saveWordList.get(errorIdList.get(i)).getEnglish());
            saveErrorWord.setChinese(saveWordList.saveWordList.get(errorIdList.get(i)).getChinese());
            save_word_list.add(saveErrorWord);
        }

    }
}
