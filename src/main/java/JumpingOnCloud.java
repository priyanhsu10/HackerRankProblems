import java.util.List;

public class JumpingOnCloud {
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int jumpCounter=0;
        int skip=0;

        for(int i:c){
            skip++;

            if(i==1|| skip==2){
                jumpCounter++;
                skip=0;
            }

        }
        return jumpCounter;
    }

}
