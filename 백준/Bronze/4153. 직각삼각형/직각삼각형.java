/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       while(true){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int f = Integer.parseInt(st.nextToken());
           int s = Integer.parseInt(st.nextToken());
           int t = Integer.parseInt(st.nextToken());
           
           if(f+s+s ==0)
                break;
           
           int max = f < s ? s<t ? t:s : f<t ? t : f;
           
           if(max == f){
               if(f*f == s*s + t*t)
                    System.out.println("right");
                else 
                    System.out.println("wrong");
           }else if(max == s){
               
                if(s*s == f*f + t*t)
                    System.out.println("right");
                else 
                    System.out.println("wrong");
           }else{
               
                if(t*t == f*f+s*s)
                    System.out.println("right");
                else 
                    System.out.println("wrong");
           }
           
       }
   }
}
