// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-2,3));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,0));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if (x2 > 0){
			for (int i = 0; i < x2; i++){
				sum++;
			}
		}
		else{
			for (int i = 0; i < Math.abs(x2); i++){
				sum--;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if (x2 > 0){
			for (int i = 0; i < x2; i++){
				sum--;
			}
		}
		else{
			for (int i = 0; i < Math.abs(x2); i++){
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int sum = 0;
		int newSum = 0;
		for (int i = 0; i < Math.abs(x2); i++){
			sum = plus(sum, Math.abs(x1));
		}
		if (!((x1 >= 0 && x2 >= 0) || (x1 < 0 && x2 < 0))){
			newSum = minus(0, sum);
			return newSum;
		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = x;
		if (n > 1){
			for (int i = 1; i < n; i++){
				sum = times(sum, x);
			}
		}
		else if(n == 1){
			return sum; 
		}
		else if(n == 0){
			sum = 1; 
		}
		else{
			sum = 0;
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        int divisor = 1;
		if(x1 == 0){
			return 0;
		}
		while (Math.abs(minus(times(divisor, Math.abs(x2)), Math.abs(x1))) >= Math.abs(x2) || divisor > Math.abs(x1)){
			divisor++;
		}
		if((x1 < 0) != (x2 < 0)){
			divisor = minus(0, divisor);
		}

		return divisor;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        int mod = 0;
        if (x2 > 0){
			mod = minus(x1, times(x2, div(x1, x2)));
		}
		return mod;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        int g = 1;
		while (times(g, g) <= x) {
			g++;
		}
		return minus(g, 1);
	}	  	  
}