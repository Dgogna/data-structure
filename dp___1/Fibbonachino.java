package dp___1;

import java.util.Scanner;

public class Fibbonachino {
	
	public static int fibbIterative(int num) {
		int arr[]=new int[num+1];
		
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2;i<=num;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		
		return arr[num];
	}
	
	public static int fibbNo(int num) {
		if(num==0 || num==1) {
			return num;
		}
		
		return (fibbNo(num-1)+fibbNo(num-2));
		
	}

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
//		int fibb=fibbNo(num);
//		System.out.println(fibb);
		int fibbIte=fibbIterative(num);
		System.out.println(fibbIte);
		
	}
}
