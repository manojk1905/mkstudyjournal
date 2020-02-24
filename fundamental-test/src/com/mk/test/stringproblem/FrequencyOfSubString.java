package com.mk.test.stringproblem;

public class FrequencyOfSubString {

    public static void main(String[] args){
        System.out.println(countFreq("text abc text abc hello text abc","abc"));
    }

    public static int countFreq(String text, String pattern){
        int freq = 0;
        int textLen = text.length();
        int patterLen = pattern.length();

        if(textLen == 0 || patterLen == 0 || textLen < patterLen) {
            return 0;
        }

        for(int textCount = 0 ; textCount <= (textLen - patterLen) ; textCount++){
            int patternCount;
            for(patternCount = 0 ; patternCount < patterLen ; patternCount++) {
                if(text.charAt(textCount + patternCount) !=  pattern.charAt(patternCount)) {
                    break;
                }
            }

            if(patternCount == patterLen) {
                freq++;
                patternCount = 0;
            }
        }
        return freq;
    }
}
