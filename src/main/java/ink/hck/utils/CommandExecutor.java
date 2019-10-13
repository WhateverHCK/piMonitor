package ink.hck.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huchenkai on 2019/9/20.
 */
public class CommandExecutor {

    public static Map<String, String> execute(String stdin) {
        try {
            Process process = Runtime.getRuntime().exec(stdin);

            String stdout = IoUtil.read(process.getInputStream());
            String stderr = IoUtil.read(process.getErrorStream());

            Map<String, String> res = new HashMap<>();
            res.put("stdout", stdout);
            res.put("stderr", stderr);

            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, String> map = execute("ls -a");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String res = objectMapper.writeValueAsString(map);
            System.out.println(res);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
