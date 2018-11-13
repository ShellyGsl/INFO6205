package edu.neu.coe.info6205.symbolTable;
import java.util.Random;

public class test {
	public static void main(String[] args) {
		Random random = new Random(); int value = 1;
		BSTSimple<Integer, Integer> bst;
		//i is the initial number of seeds
		//if operation = 0, choose "put";
		//if operation = 1,choose "delete";
		//if operation = 2,choose "get"
		//the number of operation times are 1000
		for(int j = 100; j <= 2000; j+=20) { 
			bst = new BSTSimple<>();
		long averageput = 0;
		long averagedelete = 0;
		long averageget = 0; 
		long count0 = 0; 
		long count1 = 0; 
		long count2 = 0;
		long totaltime0 = 0; 
		long totaltime1 = 0; 
		long totaltime2 = 0;
		for(int i = 0; i < j; i++) {
		        bst.put(i, value);
		    }
		for(int ot = 0; ot < j*1000; ot++) {
			int operation = random.nextInt(3); 
			int key = random.nextInt(j *2);
		if (operation == 0) {
		long stime0 = System.nanoTime(); 
		bst.put(key, value);
		long etime0 = System.nanoTime(); 
		totaltime0 += (etime0 - stime0); 
		count0++;
		}
		else if(operation == 1) {
		long stime1 = System.nanoTime();
		bst.delete(key);
		long etime1 = System.nanoTime();
		     totaltime1 += (etime1 - stime1);
		count1++; 
		}
		else {
		long stime2 = System.nanoTime(); 
		bst.get(key);
		long etime2 = System.nanoTime();
		totaltime2 += (etime2 - stime2); 
		count2++;
		}
		}
		averageput = totaltime0/count0; 
		averagedelete = totaltime1/count1;
		averageget = totaltime2/count2;
		System.out.println(j + " "+ averageput + " " + averagedelete + " " + averageget);
		System.out.println(Math.log(j)+" "+Math.sqrt(j));
		System.out.println(bst.getmaxDepth(bst.getRoot()));
		}
		
	}

}
