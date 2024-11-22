import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String newStr1 = preProcess(str1);
		String newStr2 = preProcess(str2);
		for(int i = 0; i < newStr1.length(); i++){
			boolean checkForChar = false;
			for(int j = 0; j < newStr2.length(); j++){
				if(j == newStr2.length() - 1){ // does a seperate check so the other one wont go out of the string's bounds
					if(newStr1.charAt(i) == newStr2.charAt(j) && !checkForChar){
						checkForChar = true;
						newStr2 = newStr2.substring(0, j);
						break;
					}
				}
				else if(newStr1.charAt(i) == newStr2.charAt(j) && !checkForChar){
					checkForChar = true;
					newStr2 = newStr2.substring(0, j) + newStr2.substring(j+1);
					break;
				}
			}
			if(!checkForChar){
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
				newStr += (char)(str.charAt(i) + 32);
			}
			else if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
				newStr += str.charAt(i);
			}
			else if(str.charAt(i) == 32){
				newStr += str.charAt(i);
			}
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String copy1 = str;
		String newStr = "";
		Random random = new Random();
		int index;
		for(int i = 0; i < str.length(); i++){
			if(copy1.length() > 1){
				index = random.nextInt(0, copy1.length());
			}
			else{
				index = 0;
			}
			newStr += copy1.charAt(index);
			if(index == copy1.length()-1){
				copy1 = copy1.substring(0, index);
			}
			else{
				copy1 = copy1.substring(0, index) + copy1.substring(index + 1);
			}
		}
		return newStr;
	}
}