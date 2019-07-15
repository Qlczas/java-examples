package tests;

import org.testng.annotations.Test;
import java.util.Arrays;


public class LongestOrderTests {

    String[] testArray = {"Orange", "Apple", "Grapes", "Banana"};

    @Test
    public void testLongestOrder() {
        sortList(testArray);
    }

    private static void sortList(String[] args)
    {
        Arrays.sort(args);
        for (String arg : args) System.out.println(arg);
    }
}


