package ink.hck.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by huchenkai on 2019/9/20.
 */
public class IoUtil {

    private static final String LINE_SEPARATOR = " #/nextLine# ";

    public static String read(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(LINE_SEPARATOR);
        }

        return sb.toString();
    }
}
