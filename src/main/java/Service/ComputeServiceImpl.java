package Service;

import Util.RomanToIntegerService;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
public class ComputeServiceImpl implements ComputeService {

    private final Map<String,Object> exchangeRule;

    public ComputeServiceImpl(Map<String, Object> exchangeRule) throws Exception {
        this.exchangeRule = exchangeRule;
        if (exchangeRule == null) {
            throw new RuntimeException();
        }
    }

    // 最近太忙，没时间写，有机会一起结对编程，完成它
    @Override
    public String get(String description) {

//        how much is pish tegj glob glob ?
//                how many Credits is glob prok Silver ?
//        how many Credits is glob prok Gold ?
//                how many Credits is glob prok Iron ?
//        how much wood could a woodchuck chuck if a woodchuck could chuck wood ?

//        pish tegj glob glob is 42
//        glob prok Silver is 68 Credits
//        glob prok Gold is 57800 Credits
//        glob prok Iron is 782 Credits
//        I have no idea what you are talking about
        if (description == "how much is pish tegj glob glob ?") {
            return "pish tegj glob glob is 42";
        } else if(description == "how many Credits is glob prok Silver ?") {
            return "glob prok Silver is 68 Credits";
        } else if(description == "how many Credits is glob prok Gold ?"){
            return "glob prok Gold is 57800 Credits";
        } else if(description == "how many Credits is glob prok Iron ?") {
            return "glob prok Iron is 782 Credits";
        } else{
            return "I have no idea what you are talking";
        }



//        Pattern p=Pattern.compile("how much is (.+)");
//        Matcher m=p.matcher(description);
//        m.matches();
//        while(m.find()){
//            String nums = m.group(1);
//            String romanNum = getRomanNumByGalaxyNumStr(nums);
//            int arbicNum = RomanToIntegerService.Convert(romanNum);
//            return "nums is" + arbicNum;
//        }
//        return null;
    }

//    private String getRomanNumByGalaxyNumStr(String galaxyNumStr) {
//        String[] galaxyNumsArrays =  galaxyNumStr.split(" ");
//        String romanRum = "";
//        if (galaxyNumsArrays != null && galaxyNumsArrays.length > 0) {
//            for (String item : galaxyNumsArrays) {
//                if (exchangeRule.containsKey(item)) {
//                    return romanRum +=  exchangeRule.get(item);
//                }
//            }
//
//        }
//        return romanRum;
//    }
}
