package com.ks;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Exam :)
 */
public class Application
{
    static int contador;
    /**
     * How many centuries have n years ?
     *
     * Example
     * Year 1 belongs to the 1st century
     * Year 99 belongs to the 1st century
     * Year 101 belongs to the 2nd century
     * Year 2020 belongs to the 21st century
     *
     * @param years years...
     * @return century on the years
     */
    public static int yearsToCenturies(int years)
    {
    	if(years != 0) {
    		double aux = years / 100.0;
    		double floatPart = aux % 1;
    		double intPart = aux - floatPart;
    		
    		if(floatPart != 0) {
    			return (int)intPart + 1;
    		}
    		else
    			return (int)intPart;
    	}
    	else
    		return 0;
        
    }

    /**
     * This method search a text equality inside of another text like SCRAMBLE !!!
     *
     * You don't need instructions, right?
     *
     * in: hdsasdellsdasooawwadwdwawrl ,  helloworld
     *     hd    ell    oo w        rl -> hdelloowrl
     * Yes, it doesn't look the same, but ordered you should get the same word, you know, like scramble ...
     *
     **** You must have the same number of letters if you use them more than once ***
     *
     * @param str1 unknown text
     * @param str2 searched word
     * @return if all same words and same quantity from second string exists in first string
     */
    public static boolean scramble(String str1, String str2)
    {    	
    	HashMap<String, Integer> hash_str1 = new HashMap<String, Integer>(); 
    	HashMap<String, Integer> hash_str2 = new HashMap<String, Integer>(); 
    	int counter = 0;
    	
    	for(int i=0; i<str1.length(); i++) {
    		if(!hash_str1.containsKey(Character.toString(str1.charAt(i)))) {
    			hash_str1.put(Character.toString(str1.charAt(i)),1);
    		}
    		else{
    			hash_str1.put(Character.toString(str1.charAt(i)), hash_str1.get(Character.toString(str1.charAt(i))) + 1);
    		}
        }
        
        for(int i=0; i<str2.length(); i++) {
    		if(!hash_str2.containsKey(Character.toString(str2.charAt(i)))) {
    			hash_str2.put(Character.toString(str2.charAt(i)),1);
    		}
    		else{
    			hash_str2.put(Character.toString(str2.charAt(i)), hash_str2.get(Character.toString(str2.charAt(i))) + 1);
    		}
    	}
        
        contador = 0;
        
        Set<String> keys = hash_str2.keySet();
        
        for(String key: keys) {
        	if(!(hash_str2.get(key) <= hash_str1.get(key))) {
        		contador += 1;
        	}
        }
        if(contador == 0) 
        	return true;
        else
        	return false;
    }

    /**
     * Find a middle char(s) in a text
     *
     * Example
     *
     * in: yes (hint: odd)
     * out: e
     *
     * in: word (hint: pair)
     * out: or
     *
     * *** Always wait for a single word ***
     *
     * @param word is the resource
     * @return a middle char(s)
     */
    public static String getMiddle(String word)
    {
    	int dim = word.length();
    	int isOdd = dim & 1;
    	int middle = word.length()/2;
    	
    	if (isOdd == 1)  // odd length
    		return Character.toString(word.charAt(middle));
    	else // pair length
    		return word.substring(1, dim-1);
    }

    /**
     * This method is used to find how many letters are repeated
     *
     * Example
     *
     * in: AcCoMmOdatIOn
     * out: 4
     *
     * AcCoMmOdatIOn -> have (a:2, c:2, o:3, m:2, d:1, t:1, i:1, n:1)
     *               -> just more than one (a:2, c:2, o:3, m:2)
     *               -> sum them             ^    ^    ^    ^  -> 4
     *
     * *** As you can see, case sensitive is irrelevant, spaces don't count ***
     *
     * @param text is the resource to search
     * @return how many words are repeated
     */
    public static int duplicateCount(String text)
    {
    	HashMap<String, Integer> hash_text = new HashMap<String, Integer>(); 
    	
    	
    	for(int i=0; i<text.length(); i++) {
    		
    		if(!hash_text.containsKey(Character.toString(Character.toLowerCase(text.charAt(i))))) {
    			hash_text.put(Character.toString(Character.toLowerCase(text.charAt(i))),1);
    		}
    		else{
    			hash_text.put(Character.toString(Character.toLowerCase(text.charAt(i))), hash_text.get(Character.toString(Character.toLowerCase(text.charAt(i)))) + 1);
    		}
        }
    	
    	contador = 0;
    	
		Set<String> keys = hash_text.keySet();
        
        for(String key: keys) {
        	if(hash_text.get(key) >= 2) {
        		contador += 1;
        	}
        }
        return contador;
    }

    /**
     * This method get how many times a vocals are in a text
     *
     * Example
     *
     * in : "vowel counting is not an everyday thing"
     *        ^ ^   ^^  ^   ^   ^  ^  ^ ^   ^    ^   -> 12
     *
     * ***Always wait lowercase***
     *
     * @param str is a text to search
     * @return a number of how many times a vocals are in a text
     */
    public static int getCount(String str)
    {
    	String vowels = "aeiou";
    	contador = 0;
    	
    	for(int i=0; i<str.length(); i++) {
    		if(vowels.contains(Character.toString(str.charAt(i)))) {
    			contador += 1;
    		}
    	}
        return contador;
    }

    /**
     * This method solve a quantity of multiply all separated decimal numbers on a number recursively
     *
     * in : 236
     * out: 8
     *
     * how ?
     *
     * 236 -> (2 * 3 * 6) = [36] -> (3 * 6) = [18] (1 * 8) = [8]
     *
     * <h3> How many times a decimal values need be multiplied to find a root number</h3>
     *
     * @param n a number to find a digital root
     * @return how many times a decimal values in a number can be multiplied recursively
     */
    public static int persistence(long n)
    {
        String number = n + "";
        int dim = number.length();
        
        
        if(dim == 1) 
        	return (int)n;
        else {
        	long aux = 1;
        	
        	for(int i=0; i<dim; i++) {
        		aux = aux * (number.charAt(i)-'0');
        	}
        	return persistence(aux);
        }
    }

    /**
     * This value sum all separated decimal numbers on a number recursively
     *
     * in : 123456
     * out : 3
     *
     * how ?
     *
     * 123456 -> (1 + 2 + 3 + 4 + 5 + 6) = [21] -> (2 + 1) = [3]
     *
     * @param n a number to find a digital root
     * @return digital root from a number
     */
    public static int digital_root(int n)
    {
        //Another easy
        return 0;
    }


    /**
     * This method return a char pair in array
     *
     * Example
     * in: "Give me some pairs please"
     * out: [Gi, ve,  m, e , so, me,  p, ai, rs,  p, le, as, e_]
     *
     * ***Spaces also count***
     *
     * @param s a text to evaluate
     * @return an array with pair of chars
     */
    public static String[] solution(String s)
    {
        //Will be worse ?
        return new String[]{};
    }

    /**
     * This method convert a long in a valid ip
     *
     * Example
     *
     * in: 2147483467L -> out : 127.255.255.75
     *
     * how ?
     * 1.- Convert a long in binary (you will always get 32 bits or less, if there is less just apply the pad to the left with zero)
     * 2.- Get 4 bytes (4 groups of 8 bits will give you 4 bytes)
     * 3.- Converts each byte to a decimal number
     * 4.- Apply the ip format to your 4 decimal numbers
     *
     * @param ip is a 32 bits number maximum
     * @return an IP
     */
    public static String longToIP(long ip)
    {
        //yes, can be worse...
        return "";
    }

    /**
     * This method find a shortest word in a text
     *
     * Example
     * in : "When I was young I had a lot of toys" -> out : 1
     *            ^           ^     ^              -> can be any of them
     *
     * in : "The worst part of school was solving problems like this" -> out : 2
     *                      ^^
     *
     * @param s a text to find the shortest word
     * @return a shortest word size in a text
     */
    public static int findShort(String s)
    {
        //have fun!
        return 0;
    }

    /**
     * Find a first number repeated in the array
     *
     * Example
     * in : {1,2,3,8,5,2} -> out : 2
     * in : {5,9,6,7,5,9,9} -> out : 5
     * in : {5,1,6,7,8,9,9} -> out : 9
     *
     * @param values is an int array
     * @return a first number repeated in the array or else return -1
     */
    public static Integer repeated(int[] values)
    {
        //Last one!
        return 0;
    }
}
