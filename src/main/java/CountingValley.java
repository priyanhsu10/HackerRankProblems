import java.util.stream.Stream;

public class CountingValley {

    public static int countingValleys( String path) {
        // Write your code here
        int valllyCouter=0;
        int initialposition=0;
        boolean inthevaly=false;

        for(char c:path.toCharArray()){
            initialposition= c=='D'?initialposition-1: initialposition+1;
            if(inthevaly && initialposition<0){
                    inthevaly=true;

            }
            else if(inthevaly && initialposition==0){

                valllyCouter++;
            }
           inthevaly=initialposition<0;
        }
        return  valllyCouter;
    }
}
