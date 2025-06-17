package xyz;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      if(n<=0 || n==1) {
    	  System.out.println("1");
      }
      int start=1;
      int end=n;
      int result=0;
      while(start<end) {
    	  int mid=(start+end)/2;
    	  int square=mid*mid;
    	  if(n==square) {
    		  result=mid;
    		  break;
    	  }else if(square<n) {
    		  start=mid+1;
    		  result=mid;
    	  }else {
    		  end=mid-1;
    	  }
        
      }
      System.out.println(result);
	}

}