package com.hexaware.mysampleproject.staticspack;

public class StringTester {
    public void testMethod() {
        String str = "java";
        StringBuffer sb = new StringBuffer("javachamp");
        sb.insert(9, ".com");
        str.concat("champ");

        if(sb.length() < 6 || str.equals("javachamp")){
            System.out.print(sb);
        }
        sb.delete(2, 7);
        System.out.print(sb);
    }
}
