import java.util.*;

class FibMatrixLog2n{
	public static int powOfMatrix(int[][] a,String n){
		long startTime = System.currentTimeMillis();
		int y[][]={{1,0},{0,1}};
		while(!n.equals("0")){
			if(Integer.parseInt(n.charAt(n.length() - 1) + "") % 2 == 1){
				y = matrixMultiply(y,a);
			}
			a = matrixMultiply(a,a);
			n = divideBy2(n);
			//System.out.println(n);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + " ms");
		return y[1][0];
	}
	public static int[][] matrixMultiply(int[][] a, int b[][]){
		int c[][] = new int[2][2];
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				int sum = 0;
				for(int k = 0;k < 2; k++){
					sum = sum + a[i][k] * b[k][j];
				}

				c[i][j] = sum % 100;
			}
		}
		return c;
	}
	public static String divideBy2(String n){
		String ans = "";
		String prev = "";
		boolean fl = false;
		if(n.equals("1") || n.equals("0")){
			return "0";
		}
		for(int i = 0;i < n.length(); i++){
			if(n.charAt(i) == '0'){
				if(prev.equals("")){
					if(!ans.equals("")){
						ans = ans + n.charAt(i);
					}
				}
				else{
					prev = prev +n.charAt(i);
					fl = true;
				}

			}
			else if(n.charAt(i) == '1'){
				if(prev.equals("")){
					if(!ans.equals("")){
						ans = ans + '0';
						prev = prev + n.charAt(i);
					}
					else{
						prev = prev + n.charAt(i);
					}
				}
				else{
					prev = prev + n.charAt(i);
					fl = true;
				}
			}
			else{
				prev = prev + n.charAt(i);
				fl =true;
			}
			if(fl){
				ans = ans + (Integer.parseInt(prev)/2);
				if(Integer.parseInt(prev) % 2 != 0){
					prev = Integer.parseInt(prev) % 2 + "";
				}
				else{
					prev = "";
				}
				fl = false;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = {{1,1},{1,0}};
		while(true){
			System.out.println(powOfMatrix(a,in.next()));
		}
	}
}
