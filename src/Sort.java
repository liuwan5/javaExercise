import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n;
        n=scan.nextInt();
        int[] array=new int[n];
        for (int i=0;i<n;i++){
            array[i]=scan.nextInt();
        }
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-1;j++){
                if (array[j]>=array[j+1]){
                    int t;
                    t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
        for(int num:array)System.out.print(num+" ");
    }
}
