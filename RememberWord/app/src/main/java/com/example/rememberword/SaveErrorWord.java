package com.example.rememberword;

/**
 * Created by 89524 on 2018/4/24.
 */

public class SaveErrorWord {
        private String ErrorEnglish;
        private String English;
        private String Chinese;

        public SaveErrorWord(){

        }
//        public SaveErrorWord(String ErrorEnglish){
//            this.ErrorEnglish=ErrorEnglish;
//        }
//        public SaveErrorWord(String English,String Chinese){
//            this.English=English;
//            this.Chinese=Chinese;
//        }
        public void setErrorEnglish(String ErrorEnglish){
            this.ErrorEnglish=ErrorEnglish;
        }
        public void setEnglish(String English){
            this.English=English;
        }
        public void setChinese(String Chinese){
            this.Chinese=Chinese;
        }
        public String getErrorEnglish(){
            return ErrorEnglish;
        }
        public String getEnglish(){
            return English;
        }
        public String getChinese(){
            return Chinese;
        }
}
