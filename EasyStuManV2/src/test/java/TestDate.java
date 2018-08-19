import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author afeng
 * @date 2018/8/19 11:35
 **/
public class TestDate
{
    public static void main(String[] args) throws Exception
    {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-19");
        System.out.println(date);
    }

}
