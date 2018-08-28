package Service;

import Util.RomanToIntegerService;
import sun.nio.cs.ext.MacHebrew;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 * @description init galaxy's unit and galaxy's num exchange rules;
 */
public class TranslateServiceImpl implements TranslateService {

    private Map<String,Object> maps = new HashMap<>();

    @Override
    public Map<String, Object> get(String desciption) throws Exception {
        if (desciption.isEmpty()) throw new RuntimeException("description is empty");
        String[] descArray = desciption.split("\n");
        for (String desc : descArray) {
            if (GetUnitsMaps(desc)) {
                continue;
            } else if(GetNumMaps(desc)) {
                continue;
            }
        }
        return maps;
    }

    private boolean GetNumMaps(String desciption) {
        String numPattern = "(^[a-z]+)\\sis\\s(\\w{1}$)";//glob is I
        Pattern regex =  Pattern.compile(numPattern);
        Matcher matcher = regex.matcher(desciption);
        if (matcher.find()) {
            maps.put(matcher.group(1),matcher.group(2));
            return true;
        }
        return false;
    }


    private boolean GetUnitsMaps(String desciption) {
        String numAndUnitPattern = "(.+)\\s([A-Z]{1}[a-z]+)\\sis\\s([0-9]+)\\sCredits";//glob is I
        Pattern regex =  Pattern.compile(numAndUnitPattern);
        Matcher matcher = regex.matcher(desciption);
        if (matcher.find()) {
            String galaxyNum = matcher.group(1);//get galaxy Num
            int arabicNum = getArabicNum(galaxyNum);
            int unitValue = Integer.parseInt(matcher.group(3))/arabicNum;
            maps.put(matcher.group(2),unitValue); // unit  and galaxy unit exchange arabic value
            return true;
        }
        return false;
    }

    private Integer getArabicNum(String galaxyNum) {
        String[] galaxyNums = galaxyNum.split(" ");
        String romanNum = "";
        for(String item : galaxyNums) {
            romanNum += maps.get(item);
        }
        return RomanToIntegerService.Convert(romanNum);
    }


}
