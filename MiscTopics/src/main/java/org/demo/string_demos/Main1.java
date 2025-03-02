package org.demo.string_demos;

public class Main1 {

    public static void main(String[] args) {
        String inputString = null;
        System.out.println("--------- isEmpty() ----------");
        System.out.println("Input:\"\".isEmpty() " + "Output:" + "".isEmpty());
        System.out.println("Input:\" \".isEmpty() " + "Output:" + " ".isEmpty());
        System.out.println("Input:\"\\n\".isEmpty() " + "Output:" + "\n".isEmpty());

//        Exception in thread "main" java.lang.NullPointerException:
//        Cannot invoke "String.isEmpty()" because "inputString" is null
//        at org.demo.string_demos.Main1.main(Main1.java:11)
        //System.out.println("Input:null.isEmpty() " + "Output:" + inputString.isEmpty());

        System.out.println("\n--------- isBlank() ----------");
        System.out.println("Input:\"\".isBlank() " + "Output:" + "".isBlank());
        System.out.println("Input:\" \".isBlank() " + "Output:" + " ".isBlank());
        System.out.println("Input:\"\\n\".isBlank() " + "Output:" + "\n".isBlank());

//        Exception in thread "main" java.lang.NullPointerException:
//        Cannot invoke "String.isEmpty()" because "inputString" is null
//        at org.demo.string_demos.Main1.main(Main1.java:11)
        //System.out.println("Input:null.isBlank() " + "Output:" + inputString.isBlank());
    }

}
