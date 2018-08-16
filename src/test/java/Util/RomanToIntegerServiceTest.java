package Util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
public class RomanToIntegerServiceTest {

    @Test
    public void whenInputNormalThenOutputNum() {
        Assert.assertEquals("Roman to Int error",3,RomanToIntegerService.Convert("III"));
        Assert.assertEquals("Roman to Int error",4,RomanToIntegerService.Convert("IV"));
        Assert.assertEquals("Roman to Int error",9,RomanToIntegerService.Convert("IX"));
        Assert.assertEquals("Roman to Int error",58,RomanToIntegerService.Convert("LVIII"));
        Assert.assertEquals("Roman to Int error",1994,RomanToIntegerService.Convert("MCMXCIV"));
    }

    @Test
    public void whenInputEmptyThenOutput0() {
        Assert.assertEquals("Input empty string check",0,RomanToIntegerService.Convert(""));
    }
}