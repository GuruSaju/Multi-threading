package guru.multithread.volatileexp;

/**
 * 
 * @author Srisarguru
 *
 */
public class WithVolatile {
	/*
	 * Each thread has its own stack, and so its own copy of variables it can access. When the thread is created, 
	 * it copies the value of all accessible variables in its own memory. The volatile keyword is used to say to the 
	 * jvm "Warning, this variable may be modified in an other Thread". Without this keyword the JVM is free to make 
	 * some optimizations, like never refreshing those local copies in some threads. The volatile force the thread to 
	 * update the original variable for each variable. The volatile keyword could be used on every kind of variable, 
	 * either primitive or objects
	 */

    private static volatile int MY_INT = 0;
    
	public static void main(String[] args) {
		 new ChangeListener().start();
	        new ChangeMaker().start();
	    }

	    static class ChangeListener extends Thread {
	        @Override
	        public void run() {
	            int local_value = MY_INT;
	            while ( local_value < 5){
	            	//new change in MY_INT by change maker is immediately reflected in main memory  due to volatile MY_INT
	                if( local_value!= MY_INT){
	                	System.out.println("Got Change for MY_INT :"+ MY_INT);
	                    
	                     local_value= MY_INT;
	                }
	            }
	        }
	    }

	    static class ChangeMaker extends Thread{
	        @Override
	        public void run() {

	            int local_value = MY_INT;
	            while (MY_INT <5){
	                System.out.println("Incrementing MY_INT to"+ (local_value+1));
	                MY_INT = ++local_value;
	                try {
	                    Thread.sleep(500);
	                } catch (InterruptedException e) { e.printStackTrace(); }
	            }
	        }
	    }
	}