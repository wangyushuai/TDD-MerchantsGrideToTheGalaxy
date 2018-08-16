package Service;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
@Ignore
public class TranslateServiceTest {

    private TranslateService service;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        service = new TranslateServiceImpl();
    }

    @Test
    public void whenInputGalaxyNumThenGetRomanMap() {
        String description = "glob is I";
        Character expected = 'I';
        Map<String,Object> actually = service.get(description);
        Assert.assertEquals("数字翻译失败！",expected,actually.get("glob"));
    }

    @Test
    public void whenInputEmptyThenThrowsExperion() {
        String desc = "";
        exception.expect(RuntimeException.class);
        service.get(desc);
    }

    @Test
    public void whenInputGalaxyUnitThenGetUnitValueMap() {
        String description = "glob glob Silver is 34 Credits";
        Integer expected = 17;
        Map<String,Object> actually = service.get(description);
        Assert.assertEquals("单位翻译失败！",expected,actually.get("Silver"));

    }

}