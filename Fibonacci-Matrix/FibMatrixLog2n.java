import java.util.*;

class FibMatrixLog2n{
	public static void  /*int[][]*/ powOfMatrix(int a[][],String n){
		// int y[][]={{1,0},{0,1}};
		// while(!n.equals("0")){
		// 	if(n % 2 == 1){
		// 		y = matrixMutiply(y,a);
		// 	}
		// 	a = matrixMutiply(a,a);
		// 	n = divideBy2(n);
		// }
	}
	public static void matricMultiply(int[][] a, int b[][]){
		// int c[][] = new int[2][2];
		// for(int i = 0; i < 2; i++){
		// 	for(int j = 0; j < 2; j++){
		// 		int sum = 0;
		// 		for(int k = 0;k < 2; k++){
		// 			sum = sum + a[i][k] * b[k][j];
		// 		}

		// 		c[i][j] = sum;
		// 	}
		// }
	}
	public static String divideBy2(String n){
		String ans = "";
		String prev = "";
		for(int i = 0; i < n.length(); i++){
			if(Integer.parseInt(n.charAt(i) + "") == 0){
				// System.out.println("yes");
				if(ans.equals("")){
					continue;
				}
				else if(!prev.equals("")){
					prev = prev + n.charAt(i);
				}
				else{
					ans = ans + 0;
				}
			}
			else if(Integer.parseInt(n.charAt(i) + "") < 2){
				if(prev.equals("")){
					prev = prev + n.charAt(i);
				}else{
					continue;
				}
			}
			else{
					prev = prev + n.charAt(i);
			}
			if(!prev.equals("")){
				//System.out.println("prev: " + prev);
				ans = ans + (Integer.parseInt(prev)/2);
				if(Integer.parseInt(prev) % 2 != 0){
					prev = Integer.parseInt(prev) % 2 + "";
				}
				else{
					prev = "";
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println("1. " + divideBy2("112"));
		System.out.println("2. " + divideBy2("100002"));
		System.out.println("3. " + divideBy2("1012"));
		System.out.println("4. " + divideBy2("01012"));
	}
}
