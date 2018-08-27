package Util;

import java.util.HashMap;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
public class RomanToIntegerService {
    public static int Convert(String romanNum) {
        int result = 0;
        HashMap hashMap = new HashMap<String,Integer>() {
            {
                put("I",1);
                put("V",5);
                put("X",10);
                put("L",50);
                put("C",100);
                put("D",500);
                put("M",1000);
            };
        };
        char[] romanItems = romanNum.toCharArray();
        int preNum = 0;
        for (char item : romanItems) {
            if (hashMap.containsKey(item)) {
                int curNum = (int) hashMap.get(item + "");
                if (curNum > preNum) {
                    result += curNum - 2 * preNum;
                } else {
                    result += curNum;
                }
                preNum = curNum;
            }
        }
        return result;
    }
}
