package Service;

import java.util.Map;

/**
 * Created by wangyushuai@fang.com on 2018/8/15.
 */
public interface TranslateService {
    Map<String,Object> get(String desciption) throws Exception;
}
