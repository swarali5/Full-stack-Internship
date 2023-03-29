package com.java;
import java.util.Random;
public class passwordGenerator {   
	
	public static void main(String[] args) {

    
    int num=(int)(Math.random()*16 +1);
	//System.out.println(num);
	
	String pass= generatePassword(num);
	
	System.out.println("Password length :"+ pass.length());
	
	
		if(pass.length()<=9)
		{
		System.out.println( pass+"  :weak password");
		}
		else 
		if(pass.length()>=10 && pass.length()<=13)
		{
		System.out.println(pass+"  :strong password");
		}
		else if(pass.length()>=14 && pass.length()<=16)
		{
			System.out.println(pass+"  :very strong password");
			}
	}	

    public static String generatePassword(int length) {
    	final String[] charCategories = new String[] {
                "abcdefghijklmnopqrstuvwxyz",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "0123456789",
                "!@#$%^&*()"
        };
    	
    	if(length<8)
    	{length = 8;}
    	//System.out.println(length);
    	
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }

}