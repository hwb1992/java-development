
import java.io.*;

import java.net.URL;

/**
 * Created by hwb on 2015/12/13.
 */
public class TryWithResource
{

    public static void oldMethods()
    {
        InputStream inputStream = null;
        try
        {
            File file = new File("d:/1.txt");

            URL url =  new URL("");

            inputStream = url.openStream();

            OutputStream outputStream = new FileOutputStream(file);

            try
            {
                byte[] arr = new byte[4096];

                int len;

                while((len = inputStream.read(arr)) >= 0)
                {
                    outputStream.write(arr,0,len);

                }

            }
            catch (IOException iox)
            {
                System.out.println(iox.getClass());
            }
            finally
            {
                try
                {
                    outputStream.close();
                }
                catch (IOException iox)
                {

                }
            }

        }
        catch (FileNotFoundException ex)
        {

        }
        catch (IOException iox)
        {

        }
        finally
        {
            try
            {
                if( inputStream !=null)
                {
                    inputStream.close();
                }
            }
            catch (IOException io)
            {

            }

        }
    }


    public static void newMethods()
    {

        File input = new File("d:/1.txt");
        File output = new File("d:/2.txt");
     //   URL url = null;

//        try
//        {
//          url =  new URL("");
//        }
//        catch (IOException io)
//        {
//
//        }
//        finally
//        {
//
//        }


        try(

                InputStream inputStream   =  new FileInputStream(input);

                OutputStream outputStream = new FileOutputStream(output)
            )
        {
            byte[] arr = new byte[4096];

            int len;

            while ((len = inputStream.read(arr)) >= 0) {
                outputStream.write(arr, 0, len);

            }
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }



    public static void main(String[] args)
    {
       // newMethods();
        testMyException();

    }


    public static void testMyException()
    {

        try(MyException myException = new MyException())
        {
            System.out.println("使用资源");
            throw new IOException("ss");
        }
        catch (IOException io)
        {
            System.out.println(io.getMessage());
            for(Throwable t :io.getSuppressed())
                System.out.println(t);
        }

    }


    static class MyException implements Closeable
    {
        @Override
        public void close() throws IOException {
            System.out.println("关闭资源");
            throw new IOException("test");
        }
    }


    /**
     * 总结
     * 1.在  try with resoucre 中 可以在  try() 里面申请资源 到时候系统帮我们自动关闭资源
     * 2.twr中可能有2出会抛出异常  一个是在我们的 try 一个是在系统释放资源的时候 可以有如下的总结
     *      1) try 无异常 关闭资源无异常  执行顺序 try-> 关闭资源
     *      2) try 无异常 关闭资源有异常  这时候抛出的是关闭资源的异常  执行顺序 try-> 关闭资源 -> 抛出关闭资源的异常
     *      3) try 有异常 关闭资源无异常 这时候抛出的是try中的异常 但是先关闭资源  执行顺序 try->关闭资源 -> 抛出try中的异常
     *      4) try 有异常 关闭资源有一场 这时候抛出的是try中的异常 附加 关闭资源的异常 执行顺序 try -> 关闭资源 -> 抛出try的异常和附加关闭资源的异常
     * 3.
     *
     *
     */

}


