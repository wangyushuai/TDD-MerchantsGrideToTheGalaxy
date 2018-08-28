package Service;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */

public class TranslateServiceTest {

    private TranslateService service;
    private final static String baseDescription = "glob is I\n" +
            "prok is V\n" +
            "pish is X\n" +
            "tegj is L\n";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        service = new TranslateServiceImpl();
    }

    @Test
    public void whenInputGalaxyNumThenGetRomanMap() throws Exception {
        String description = "glob is I";
        String expected = "I";
        Map<String,Object> actually = service.get(description);
        Assert.assertEquals("数字翻译失败！",expected,actually.get("glob"));
    }

    @Test
    public void whenInputEmptyThenThrowsException() throws Exception {
        String desc = "";
        exception.expect(RuntimeException.class);
        exception.expectMessage("description is empty");
        service.get(desc);
    }

    @Test
    public void whenInputGalaxyUnitThenGetUnitValueMap() throws Exception {
        String description = baseDescription + "glob glob Silver is 34 Credits";
        Integer expected = 17;
        Map<String,Object> actually = service.get(description);
        Assert.assertEquals("单位翻译失败！",expected,actually.get("Silver"));
    }

}