package Interview;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siming on 11/11/15.
 */
public class ReadFile
{
    public void readFile() throws IOException
    {
        File file = new File("/Users/Siming/Desktop/test.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        Map<String, Integer> map = new HashMap<>();
        int lineNum = 0;

        String line = null;
        while ((line = br.readLine()) != null)
        {
            if (line.contains("java") && !line.contains("python"))
            {
                map.put("java", lineNum);
            }
            else if (line.contains("python") && !line.contains("java"))
            {
                map.put("python", lineNum);
            }
            else if (line.contains("java") && line.contains("python"))
            {
                map.put("both", lineNum);
            }

            lineNum++;
        }

        br.close();
    }
}
