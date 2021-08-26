import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestingApplication {
    public static  void  main(String[] s){
        System.out.println("hello java");
        SocksMachers.sockMerchant(5, Arrays.asList(1, 1 ,3, 1, 2 ,1, 3 ,3, 3, 3)); //4
        JumpingOnCloud.jumpingOnClouds(Arrays.asList(0 ,0 ,1 ,0 ,0 ,1 ,0)); //4
        CountingValley.countingValleys("UDDDUDUU");
    }


}
