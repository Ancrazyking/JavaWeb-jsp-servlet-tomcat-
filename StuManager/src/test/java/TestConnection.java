import org.afeng.utlis.JDBCUtils;

/**
 * @author afeng
 * @date 2018/8/15 20:51
 **/
public class TestConnection
{
    public static void main(String[] args)
    {
        System.out.println(JDBCUtils.getConnection());
    }
}
