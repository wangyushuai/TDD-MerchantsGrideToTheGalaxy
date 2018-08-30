package Service;

import java.util.Map;

/**
 * Created by wangyushuai@fang.com on 2018/8/28.
 */
public class IndexServiceImpl implements IndexService {

    public static void main(String[] args) {
        IndexService service = new IndexServiceImpl();
        String desc = null;
        try {
            desc = service.output();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(desc);
    }

    @Override
    public String read() {
        return "glob is I\n" +
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
    }

    @Override
    public String output() throws Exception {
        String description = read();
        TranslateService translateService = new TranslateServiceImpl();
        Map<String,Object> rules = translateService.get(description);
        ComputeService computeService = new ComputeServiceImpl(rules);
        return  computeService.get(description);
    }




}
