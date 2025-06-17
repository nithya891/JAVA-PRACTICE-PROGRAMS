package xyz;

public class LinearSearchExample {

	public static void main(String[] args) {
		int[]  a= {1,2,3,4,5,6};
		int tag=10;
        boolean found=false;
        for(int i=0;i<=a.length;i++) {
        	if(a[i]==tag) {
        	System.out.println("found"+ " "+tag+"at index"+ i);
        	found=true;
        	break;
        	}
        }
        if(!found) {
        	System.out.println("not found");
        }
	}

}