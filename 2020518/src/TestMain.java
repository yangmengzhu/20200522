import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 *
 * @program: 2020518
 * @description
 * 层序遍历二叉树
 * @author: mrs.yang
 * @create: 2020 -05 -18 18 :44
 */

public class TestMain {
   public static boolean contains(String str,String str1){
     char[] ch1=str.toCharArray();
     char[] ch2=str1.toCharArray();
       for (int i = 0; i < ch2.length; i++) {
           char tmp2=ch2[i];
           for (int j = 0; j <ch1.length ; j++) {
               char tmp1=ch1[j];
               if(tmp1==tmp2){
                   if(i==ch2.length-1){
                       return true;
                   }
                   i++;
                   tmp2=ch2[i];
               }else{
                   i=-1;
               }
           }
       }
       return false;
   }
    public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       String str=scan.nextLine();
        String str1=scan.nextLine();
        boolean ret=contains(str,str1);
        System.out.println(ret);
    }
}
