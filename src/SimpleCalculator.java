//简单的四则运算计算器
import java.util.Scanner;
public class SimpleCalculator {
    char[] opeStack=new char[300];
    int[] numstack=new int[3000];
    int[] bracketsPosition=new int[100];
    int opeStackPointer=0;
    int numStackPointer=0;
    int bracketsPointer=0;
    public static void main(String[] args) {
        SimpleCalculator cal=new SimpleCalculator();
        cal.getterAndRunner();
    }
    void getterAndRunner(){
        bracketsPosition[0]=0;
        System.out.println("仅支持四则运算，支持括号");
        System.out.println("请输入你的算式（数字，符号之间要以空格隔开），以\"=\"结束：");
        Scanner scan=new Scanner(System.in);
        String expression=scan.nextLine();
        //char[] tem=new char[expression.length()];
        String[] chars=expression.split("\\s+");//去除空格
        //int i=0;
        for(String s:chars) {
            try {
                numstack[numStackPointer]=Integer.parseInt(s);
                numStackPointer++;
            }
            catch (NumberFormatException ex){
                char tch=s.charAt(0);
                if(tch=='('){
                    bracketsPointer++;
                    bracketsPosition[bracketsPointer]=opeStackPointer;
                    continue;
                }
                if (tch==')'){
                    while (opeStackPointer != bracketsPosition[bracketsPointer]) {
                        switch (opeStack[opeStackPointer - 1]) {
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                break;
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                break;
                            case '+':
                                numstack[numStackPointer - 2] += numstack[numStackPointer - 1];
                                break;
                            case '-':
                                numstack[numStackPointer - 2] -= numstack[numStackPointer - 1];
                                break;
                        }
                        numStackPointer--;
                        opeStackPointer--;
                    }
                    bracketsPointer--;
                    continue;
                }
                if (tch=='='){
                    while (opeStackPointer != bracketsPosition[bracketsPointer]) {
                        switch (opeStack[opeStackPointer - 1]) {
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                break;
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                break;
                            case '+':
                                numstack[numStackPointer - 2] += numstack[numStackPointer - 1];
                                break;
                            case '-':
                                numstack[numStackPointer - 2] -= numstack[numStackPointer - 1];
                                break;
                        }
                        numStackPointer--;
                        opeStackPointer--;
                    }
                    System.out.println(numstack[0]);
                    break;
                }

                else if(opeStackPointer==bracketsPosition[bracketsPointer]){
                    opeStack[opeStackPointer]=tch;
                    opeStackPointer++;
                }
                else{
                switch (tch) {
                    case '-':
                    case '+':
                            while (opeStackPointer != bracketsPosition[bracketsPointer]) {
                                switch (opeStack[opeStackPointer - 1]) {
                                    case '*':
                                        numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                        break;
                                    case '/':
                                        numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                        break;
                                    case '+':
                                        numstack[numStackPointer - 2] += numstack[numStackPointer - 1];
                                        break;
                                    case '-':
                                        numstack[numStackPointer - 2] -= numstack[numStackPointer - 1];
                                        break;
                                }
                                numStackPointer--;
                                opeStackPointer--;
                        }
                        opeStack[opeStackPointer] = tch;
                        opeStackPointer++;
                        break;
                    case '*':
                        switch (opeStack[opeStackPointer - 1]) {
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                numStackPointer--;
                                break;
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                numStackPointer--;
                                opeStack[opeStackPointer - 1] = '*';
                                break;
                            case '+':
                            case '-':
                                opeStack[opeStackPointer]='*';
                                opeStackPointer++;
                                break;
                        }
                        break;
                    case '/':
                        switch (opeStack[opeStackPointer - 1]) {
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                numStackPointer--;
                                break;
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                numStackPointer--;
                                opeStack[opeStackPointer - 1] = '/';
                                break;
                            case '+':
                            case '-':
                                opeStack[opeStackPointer]='/';
                                opeStackPointer++;
                                break;
                        }
                        break;
                    }
                }
            }
        }
    }
}
