import java.util.*;
public class StringArray {
    public static void main(String[] args) {
        String[] strs=new String[]{
                "Liu",
                "Ya",
                "Jia"
        };
        for(String str:strs){
            System.out.print(str+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(strs));
    }
}
