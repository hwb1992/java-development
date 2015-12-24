import java.io.*;

/**
 * Created by hwb on 2015/12/12.
 */

class TestException extends RuntimeException{

}


public class TryCatchDemo {


//    public static void test() throws IOException
//    {
//       // throw new IOException();
//        throw new RuntimeException();
//    }
//
//    public static void main(String[] args) throws IOException{
//        test();
//    }


    public static void main(String[] args) {


        File file = new File("d:/1.txt");

        File output = new File("d:/2.txt");

        try {
            try {
                InputStream is = new FileInputStream(file);
                byte[] arr = new byte[1024];

                OutputStream os = new FileOutputStream(output);
                int length = -1;
                while ((length = is.read(arr, 0, arr.length)) != -1)

                {
                    os.write(arr, 0, length);
                }
                throw new TestException();
            }
//        catch (TestException | IOException e){
//            System.out.println(e.getClass());
//
//        }
            catch (final Exception e) { // final重新抛出 这样就可以让外面用具体的异常接受 而不是要用抽象的exception来做

                throw e;

            }
        }
        catch (TestException e)
        {
            System.out.println(e.getClass());
        }
        catch (IOException e)
        {
            System.out.println(e.getClass());
        }
    }
}
