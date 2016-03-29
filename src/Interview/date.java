package Interview;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Siming on 11/14/15.
 */
public class date
{
    public void test() throws ParseException {
        Date date;
        String str = "2015/11/11 15:30:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        date = sdf.parse(str);

        System.out.println(date.getMinutes());
    }

    public static void main(String[] args) throws ParseException {
        date t = new date();
        t.test();
    }
}
