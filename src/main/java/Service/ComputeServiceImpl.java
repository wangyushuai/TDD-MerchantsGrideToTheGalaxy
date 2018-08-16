package Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
public class ComputeServiceImpl implements ComputeService {

    private final Map<String,Integer> exchangeRule;

    public ComputeServiceImpl(Map<String, Integer> exchangeRule) {
        this.exchangeRule = exchangeRule;
    }


    @Override
    public String get(String description) {
        Pattern p=Pattern.compile("how much is ([a-z]+)");
        Matcher m=p.matcher(description);
        m.matches();
        while(m.find()){
            String num = m.group(0);
        }
        return null;
    }
}
