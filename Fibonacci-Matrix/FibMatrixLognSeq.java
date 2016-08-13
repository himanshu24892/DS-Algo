import java.util.*;

class FibMatrixLognSeq{
	static List<Integer> fib = new ArrayList<Integer>();
	public static int calculateFib(String n, int p){
		return fib.get(mod(n,p));
	}
	public static int mod(String m, int p){
		String rem = "", ans = "";
		if(Integer.parseInt(m) < p){
			ans = m;
			return Integer.parseInt(m);
		}
		if(Integer.parseInt(m) == p){
			ans = "0";
			return 0;
		}
		for(int i = 0; i < m.length(); i++){
			rem = rem + m.charAt(i);
			if(Integer.parseInt(rem) < p){
				if(ans.equals("")){
					continue;
				}
				else{
					ans = ans + "0";
				}
			}
			else{
				ans = ans + Integer.parseInt(rem)/p;
				rem = Integer.parseInt(rem) % p + "";
			}
		}
		return Integer.parseInt(rem);
	}
	public static int checkSeq(int m){
		fib.add(0);
		fib.add(1);
		int i = 2;
		int seq = 0;
		while(i < 6*m){
			fib.add((fib.get(i - 1) + fib.get(i - 2)) % m);
			if(fib.get(i - 1) == 0 && fib.get(i) == 1){
				seq = i - 1;
				break;
			}
			i++;
		}

		return seq;
	}
	public static void main(String[] args) {
		// System.out.println(checkSeq(100));
		Scanner in = new Scanner(System.in);
		int p = checkSeq(in.nextInt());
		while(true){
			System.out.println(calculateFib(in.next(), p));
		}
	}
}