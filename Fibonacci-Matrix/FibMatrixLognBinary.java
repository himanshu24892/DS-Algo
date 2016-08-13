import java.util.*;

class FibMatrixLognBinary{
	public static int powOfMatrix(int[][] a,String n){
		long startTime = System.currentTimeMillis();
		int y[][]={{1,0},{0,1}};
		int i = n.length() - 1;
		while(i >= 0){
			if(n.charAt(i) == '1'){
				y = matrixMultiply(y,a);
			}
			a = matrixMultiply(a,a);
			i--;
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] a = {{1,1},{1,0}};
		while(true){
			System.out.println(powOfMatrix(a,in.next()));
		}
	}
}
