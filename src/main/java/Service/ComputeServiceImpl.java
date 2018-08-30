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

    @Override
    public String get(String description) {
        //how much is pish tegj glob glob ?
        //pish tegj glob glob is 42
        String result = "";
        String[] descArray = description.split("\n");
        for (String desc : descArray) {
            if (desc.indexOf("many")>0 || desc.indexOf("much") >0) {
                if (desc.indexOf("much") > 0) {
                    result += computeNums(desc);
                } else if (desc.indexOf("many") > 0) {
                    result += computeNumsAndUnit(desc);
                } else {
                    result += "I have no idea what you are talking about\n";
                }
            }
        }

        return result;
    }


    /**
     * 计算数字
     * @param description
     * @return
     */
    private String computeNums(String description) {
        Integer arabicNum = 0;
        String galaxyNum = "";
        String numPattern = "^how\\smuch\\sis\\s(.+)\\s\\?";
        Pattern pattern = Pattern.compile(numPattern);
        Matcher matcher = pattern.matcher(description);
        if (matcher.find()) {
            galaxyNum = matcher.group(1);
            arabicNum = parseGalaxyNumToArabicNum(galaxyNum);
            if (arabicNum >= 0) {
                return galaxyNum + " is " + arabicNum + "\n";
            }
        }

        return "I have no idea what you are talking about\n";
    }

    /**
     * 计算数字和单位
     * @param description
     * @return
     */
    private String computeNumsAndUnit(String description) {
        //how many Credits is glob prok Silver ?
        //glob prok Silver is 68 Credits
        Integer total = 0;
        Integer arabicNum = 0;
        String galaxyNum = "";
        String unit = "";
        Integer unitValue = 0;
        String numPattern = "^how\\smany\\sCredits\\sis\\s(.+)\\s([A-Z][a-z]+)\\s\\?";
        Pattern pattern = Pattern.compile(numPattern);
        Matcher matcher = pattern.matcher(description);
        if (matcher.find()) {
            galaxyNum = matcher.group(1);
            arabicNum = parseGalaxyNumToArabicNum(galaxyNum);
            unit = matcher.group(2);
            if (exchangeRule.containsKey(unit)) {
                unitValue = Integer.parseInt(exchangeRule.get(unit).toString());
                total = arabicNum * unitValue;
                return galaxyNum + " " + unit + " is " + total + " Credits\n";
            } else  {
                throw  new RuntimeException("exchange rules can't find this unit!");
            }
        }
        return "I have no idea what you are talking about\n";
    }


    /**
     * galaxy num change to arabic num
     * @param galaxyNum
     * @return
     */
    private Integer parseGalaxyNumToArabicNum(String galaxyNum) {
        String romanNum = "";
        String[] nums = galaxyNum.split(" ");
        for (String item : nums) {
            if (exchangeRule.containsKey(item)) {
                romanNum += exchangeRule.get(item);
            }else {
                throw new RuntimeException("Can not find this galaxy's num!");
            }
        }
       return RomanToIntegerService.Convert(romanNum);
    }
}
