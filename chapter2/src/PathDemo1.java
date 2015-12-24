import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.concurrent.locks.Lock;

/**
 * Created by hwb on 2015/12/14.
 */

public class PathDemo1<T>
{
//    public static void main(String[] args)
//    {
//
//        int a = 10;
//        {
//            a = 21;
//            System.out.println(a);
//        }
//
//        System.out.println(a);
//    }
    Lock


    public static void main(String[] args)
    {
        Path path = Paths.get("d:/test/1.txt");

        System.out.println(path.getFileName());
        System.out.println(path.getFileSystem());
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getNameCount());
        System.out.println(path.getName(0));

    }
    @SafeVarargs
    public final <T> Collection<T> merge(T... args)
    {
        return null;
    }

}
