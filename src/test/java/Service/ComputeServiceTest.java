package Service;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */

public class ComputeServiceTest {
    private ComputeService service;
    private static Map<String,Object> exchangeRule;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static  void beforeClass() {
        exchangeRule = new HashMap<>();
        exchangeRule.put("glob","I");
        exchangeRule.put("prok","V");
        exchangeRule.put("pish","X");
        exchangeRule.put("tegj","L");
        exchangeRule.put("Silver",17);
        exchangeRule.put("Gold",14450);
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

    @Test
    public void GiveRuleWhenInputNumAndUnitThenArabicNum() {
        String descption = "how many Credits is glob prok Silver ?";
        String excepted = "glob prok Silver is 68 Credits\n";
        String actually = service.get(descption);
        String errorInfo = "Galaxy Num And Galaxy Unit Copute Error";
        Assert.assertEquals(errorInfo,excepted,actually);
    }



    @Test
    public void WhenNullIsRullThenThorwException() throws Exception {
        Map<String,Object> nullExchangeRule = null;
        exception.expect(RuntimeException.class);
        service = new ComputeServiceImpl(nullExchangeRule);
        service.get("");
    }









}