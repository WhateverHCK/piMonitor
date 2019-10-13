package ink.hck.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huchenkai on 2019/9/20.
 */
public class CommandExecutor {

    public static Map<String, String> execute(String stdin) {
        Map<String, String> res = new HashMap<>();

        try {
            Process process = Runtime.getRuntime().exec(stdin);

            String stdout = IoUtil.read(process.getInputStream());
            String stderr = IoUtil.read(process.getErrorStream());

            res.put("stdout", stdout);
            res.put("stderr", stderr);

        } catch (Exception e) {
            e.printStackTrace();
            res.put("stdout", "");
            res.put("stderr", e.getClass().getCanonicalName());
        }
        return res;
    }

}
