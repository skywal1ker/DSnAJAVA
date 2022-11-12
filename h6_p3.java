import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


public class h6_p3 {


    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i=0; i < a.length; i++)
            buffer.push(a[i]);
        for (int i=0; i < a.length; i++)
            a[i] = buffer.pop();
    }


//            for (int i = 0; i < words.length; i++) {S.push(words[i]);}
//            for (int i = 0; i < words.length; i++) {System.out.print(S.pop()+"");}


    public static void main(String[] args) {

        Stack<String> S = new ArrayStack<>();
        Scanner fileInput = null;


        try { fileInput = new Scanner (new File("src/text.txt")); }
        catch(FileNotFoundException e) { System.out.println("Input file not found");
        }

        while (fileInput.hasNext()){
            String words = fileInput.nextLine();
            for (int i = 0; i < words.length(); i++) {S.push(words.split("")[i]);}
            System.out.println();
            for (int i = 0; i < words.length(); i++) {System.out.print(S.pop());}

        }

        fileInput.close();


    }
}
