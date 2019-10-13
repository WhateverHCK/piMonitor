package ink.hck.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ink.hck.utils.CommandExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Created by huchenkai on 2019/10/3.
 */
@RestController
@CrossOrigin
public class MonitorController {

    @RequestMapping("/stdin")
    public String executeCommand(String command) {
        String jsonRes = "";
        Map<String, String> output = null;
        try {
            output = CommandExecutor.execute(command);

            ObjectMapper objectMapper = new ObjectMapper();
            jsonRes = objectMapper.writeValueAsString(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonRes;
    }
}
