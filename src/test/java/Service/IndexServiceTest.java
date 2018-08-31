package Service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Created by wangyushuai@fang.com on 2018/8/28.
 */

@RunWith(MockitoJUnitRunner.class)
public class IndexServiceTest {
    @InjectMocks
    private IndexServiceImpl indexService;
    @Mock
    private TranslateService translateService;

    private  static Map<String,Object> exchangeRule = new HashMap<>();

    @BeforeClass
    public static  void beforeClass() {
        exchangeRule.put("glob","I");
        exchangeRule.put("prok","V");
        exchangeRule.put("pish","X");
        exchangeRule.put("tegj","L");
        exchangeRule.put("Silver",17);
        exchangeRule.put("Gold",14450);
        exchangeRule.put("Iron",195.5);

    }

    private final  static String baseTestInput = "glob is I\n" +
            "prok is V\n" +
            "pish is X\n" +
            "tegj is L\n" +
            "glob glob Silver is 34 Credits\n" +
            "glob prok Gold is 57800 Credits\n" +
            "pish pish Iron is 3910 Credits\n" +
            "how much is pish tegj glob glob ?\n" +
            "how many Credits is glob prok Silver ?\n" +
            "how many Credits is glob prok Gold ?\n" +
            "how many Credits is glob prok Iron ?\n" +
            "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";

    @Ignore
    @Test
    public void whenReadThenGetNotEmpty() {
        indexService = new IndexServiceImpl();
        String testInput = indexService.read();
        Assert.assertFalse("read error",testInput == null || testInput.isEmpty());
    }

    @Test
    public void whenInputThenCorrectOutput() throws Exception {
        //模拟翻译服务
        when(translateService.get(anyString())).thenReturn(exchangeRule);

        //主要测试内容： 输出
        String output =  indexService.output();
        verify(translateService).get(anyString());
        Assert.assertNotNull(output);
        Assert.assertFalse(output.isEmpty());
        Assert.assertTrue(output.indexOf("pish tegj glob glob is 42") >= 0);
        Assert.assertTrue(output.indexOf("glob prok Silver is 68 Credits") >= 0);
        Assert.assertTrue(output.indexOf("glob prok Gold is 57800 Credits") >= 0);
        Assert.assertTrue(output.indexOf("glob prok Iron is 782 Credits") >= 0);
        Assert.assertTrue(output.indexOf("I have no idea what you are talking about") >= 0);

    }



}