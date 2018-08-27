import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/27 9:42
 **/
public class TestList
{

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        String a = "aaa";
        String b = "bbb";
        String c = "ccc";
        list.add(a);
        list.add(b);
        list.add(c);
  /*      for (String l : list)
        {
            if (l.equals("aaa"))
            {
                list.remove(l);
            }
        }*/
        //  System.out.println(list.get(0));
        // System.out.println(list.get(1));
        //System.out.println(list.get(2));
        System.out.println(list);
        System.out.println("=======================");
        //   list.remove(a);
        // System.out.println(list.get(0));
        //System.out.println(list.get(1));
/*
        System.out.println(list.get(2));
*/

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext())
        {
            String l = iterator.next();
            if (l.equals("aaa"))
            {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

}
