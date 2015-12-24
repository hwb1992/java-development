import java.util.Date;

/**
 * Created by hwb on 2015/12/12.
 */
class Test{

    public enum NUMBER{

        ONW(1),TWO(2);

        private Integer number;

        NUMBER(Integer number){
            this.number = number;
        }


        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }

    public final class T
    {
        public static final String name = "1";

        public static final int age = 12;


    }

    private static  Test t;

}



public class EnumTest {

    public static void main(String[] args){


        Test.NUMBER d = Test.NUMBER.ONW;


        Test test = new Test();




        System.out.println(d);


        for(Test.NUMBER number : Test.NUMBER.values())
        {
            System.out.println(number);

            System.out.println(number.ordinal());
        }

    }


}
