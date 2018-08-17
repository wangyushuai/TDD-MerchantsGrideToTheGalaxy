package Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
public class ComputeServiceTest {
    private ComputeService service;
    private static Map<String,Object> exchangeRule;

    @BeforeClass
    public static  void beforeClass() {
        exchangeRule = new HashMap<>();
        exchangeRule.put("glob","I");
        exchangeRule.put("prok","V");
        exchangeRule.put("pish","X");
        exchangeRule.put("tegj","L");
        exchangeRule.put("Silver ",17);
        exchangeRule.put("Gold  ",14450);
        exchangeRule.put("Iron",195);
    }

    @Before
    public void setUp() throws Exception {
        service = new ComputeServiceImpl(exchangeRule);
    }

    //Given Correct Rule When Input compute Galaxy Number Then Output Arabic Num
    @Test
    public void  GivenRuleWhenGalaxyNumThenArabicNum() {
        String descption = "how much is pish tegj glob glob ?";
        String excepted = "pish tegj glob glob is 42";
        String actually = service.get(descption);
        String errorInfo = "Given Correct Rule When Input compute Galaxy Number Then Output Arabic Num";
        Assert.assertEquals(errorInfo,excepted,actually);
    }




}