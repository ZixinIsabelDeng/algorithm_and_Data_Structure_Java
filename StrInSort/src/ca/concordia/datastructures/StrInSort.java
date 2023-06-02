
//How did the structuring pass you performed, specifically the reversals chosen, affect swaps 
//and comparisons?
//Was anything else affected? Answer in less than 100 words.



// it creates more comparison when structuring pass was added, and the swaps number keeps the same.
// There are other things got affected, for example the time to run the program. Without structuring, 
//it is faster coz less comparisons need to be done, whereas with structuring, it slows down the program




//How do you feel the size of the specific runs you recorded (DESCENDING order of length 4) impacted
//performance? Answer in less than 100 words

//if the number of the run that has features of DESCENDING order of length 4 is large enough,for example, more than 10,
//Structuring method will be efficiently decrease the number of comparisons the program perform. 
//However, if there are only small number of that length 4 descending runs, structuring makes the program less efficient

//What would implementing this as a Doubly Linked List do? How would the specified structuring affect
//results? Answer in less than 100 words.

//implementing doubly linkedlist is beneficial for operation like deletion and insertion
//However, the structuring process involves a lot of swaps. It could be more complicated to do 
//that with a Doubly Linked List compare with a more straightforward array.  










package ca.concordia.datastructures;
import java.time.Duration;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import  java.util.*;
public class StrInSort {
	static int compare_total=0;
	static int swap_total=0;
	static int descendinglength4;
	static int dec=0;
	static int compare=0;

	public static void main(String[] args) {
     String filename=args[0];
     Scanner sc=null;
    		 try {
    			sc=new Scanner(new FileInputStream(filename));
    			
               	 
    		 }
    		 catch(FileNotFoundException e){
    			 System.out.println("file not found"); 
    		 }
 
    		 String a=sc.nextLine();		 
    			 
    		sc.close();	 
		

    			    
	   String[] k=a.split(" ");
	 
	   int[] b=new int[k.length];
	   for(int i=0;i<k.length;i++) {
		   b[i]=Integer.parseInt(k[i]);
	   }  
	 
	   
	  
	   for(int num :b) {
		   System.out.print(num+" "); 
	   }
	   System.out.println("\nWe sorted in INCR order"); 
		
		// step 1: find the index that are in different run, separate them into small individual run
		//write a methods
		structuringPass(b);
		System.out.println("We counted "+descendinglength4+" DEC runs of length 4");
		System.out.println("We performed "+dec+" reversals of runs in DEC order");
		System.out.println("We performed "+compare+" compares during structuring");
		
		long startmills=System.currentTimeMillis();
		
		insertionsort(b);
		
		System.out.println( "We performed "+compare_total+" compares overall");
		System.out.println( "We performed "+swap_total+" swaps overall");
		for(int i=0;i<b.length;i++) {
			System.out.print(b[i]+" ");
		   }
	
		long endmills=System.currentTimeMillis();
		//compare the time elapse to run the program
		//System.out.println("\ntime elapsed is "+(endmills-startmills));
	}

	
		
		
//my goal is to print 64 and 79 and 72
//output length 2,2,2 or 3,2,2,2,2,2,2
	public static void structuringPass(int[] k) {
		
     
		int length=1;
	
		boolean isdescending =false;
		boolean isascending =false;
	    int reverse_start_index,reverse_end_index;
	    
		 for(int i=1;i<k.length;i++) { 
		    if(!isascending&&k[i]<k[i-1]) {
		    	compare_total++;
		    	compare++;
		    	isdescending=true;
		    	length++; 	
		    }
		     
		    else if(isdescending&&k[i]>k[i-1]) 
		    {
		    	compare_total++;
		    	reverse_end_index=i-1;
		    	reverse_start_index=reverse_end_index-length+1;
		    	flipToAsc(k,reverse_start_index,reverse_end_index);
//		    	
		    	compare++;
		    	if (length>1) {
		    		compare_total++;
		    	
		    		dec++;
		    		}
		    	
		    	if(length==4) {
		    		descendinglength4++;
		    		compare_total++;

		    		}
		    	//reverse it	
		    	length=1;		    
		    	isdescending=false;
		    	
		    }
		   
		    else if(k[i]>k[i-1])
		    {
		    	//compare_total++;
		    	compare++;		    	
		    	length++;   	
		    	isascending=true;
		    }
		    else  if(isascending&&k[i]<k[i-1]) 
		    {
		    	//compare_total++;
		    	compare++;
		        isascending=false;
		    	length=1;
		    }    		 
		 }
	 

		 	 	
	}
			
				
		   
	
	public static void flipToAsc(int[] arr, int start, int end) {
		int temp=0;
		while(start<end) {
			compare_total++;
			temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
			swap_total++;
		}
	}
	
	public static void insertionsort(int[] arr) {
		int length=arr.length;
		int key;
		int temp;
		for(int i=0;i<length;i++) {
			
			key=arr[i];
			int j=i-1;
			while(j>-1&&key<arr[j]) {
				 compare_total++;
					 
				swap_total++;
				
				    temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
//					i=j;
//					j=i-1;
					j--;
								
		    }
			
			//j--;
			 compare_total++;
			
			
		
		}
		
			
		
	}
	
	
	
}
