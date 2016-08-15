import java.util.*;

class FibMatrixLognBase10{
	public static int powOfMatrix(int[][] a,String n){
		long startTime = System.currentTimeMillis();
		int y[][]={{1,0},{0,1}};
		int i = n.length() - 1;
		while(i >= 0){
			int ni = Integer.parseInt(n.charAt(i) + ""); 
				int [][] temp = a;
				if(ni == 0){
					temp = new int[][]{{1,0},{0,1}};
				}
				else if(ni == 1){
					temp = a;
				}
				else{
					for(int t = 1; t < ni; t++){
						temp = matrixMultiply(temp , a);
					}
				}
				y = matrixMultiply(y,temp);
			int a2[][] = new int[2][2];
			temp = a;
			for(int t = 1; t < 10;  t++){
				a = matrixMultiply(a,temp);
			}
			// a = matrixMultiply(a, a2);

			i--;
			//System.out.println(n);
		}
		long endTime = System.currentTimeMillis();
		// /System.out.println(endTime - startTime + " ms");
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = {{1,1},{1,0}};
		while(true){
			System.out.println(powOfMatrix(a,in.next()));
		}
	}
}
