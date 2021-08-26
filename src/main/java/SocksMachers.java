import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class SocksMachers {
    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> collect = ar.stream().
                collect(groupingBy(x -> x, collectingAndThen(counting(), Long::intValue)));
        int sum = collect.entrySet().stream().mapToInt(x -> x.getValue() / 2).sum();
        System.out.println(sum);

        return  1;
    }
}
