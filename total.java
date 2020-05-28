import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int month = sc.nextInt();
			System.out.println(getTotal(month));
		}
	}
	public static int getTotal(int month){
		if(month==1||month==2){
			return 1;
		}
		return getTotal(month-1)+getTotal(month-2);
	}
}