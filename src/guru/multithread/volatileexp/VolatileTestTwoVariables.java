package guru.multithread.volatileexp;


/**
 * 
 * @author Srisarguru
 * Kind of works. If you run you can see volatile variable change displayed. 
 * Yeah quite get what volatile is all about. 
 */
public class VolatileTestTwoVariables {
private  volatile static int volatileInt = 0;
private static int nonVolatileInt=0;
    
	public static void main(String[] args) {
		 new ChangeListener().start();
	        new ChangeMaker().start();
	    }

	    static class ChangeListener extends Thread {
	        @Override
	        public void run() {
	            int localVolatileInt = volatileInt;
	            int localNonVolatileInt = nonVolatileInt;
	          /*  while ( localVolatileInt < 5 && localNonVolatileInt < 5){
	            	 if(localNonVolatileInt!=nonVolatileInt){
		                	System.out.println("Got Change for non volatile var:"+ nonVolatileInt);
		                    
		                     localNonVolatileInt= nonVolatileInt;
		                }
	                if( localVolatileInt!= volatileInt){
	                	System.out.println("Got Change for volatile var :"+ volatileInt);
	                    
	                     localVolatileInt= volatileInt;
	                }
	               
	            }*/
	            while (  localVolatileInt < 5){
	            	
	            	 if(localVolatileInt!=volatileInt){
	            		 try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                	System.out.println("Got Change for volatile var:"+ nonVolatileInt);
		                    
		                     localVolatileInt= volatileInt;
		                }
	            }
	            while (  localNonVolatileInt < 5){
	            	
	            	 if(localNonVolatileInt!=nonVolatileInt){
		                	System.out.println("Got Change for non volatile var:"+ nonVolatileInt);
		                    
		                     localNonVolatileInt= nonVolatileInt;
		                }
	            }
	        }
	    }

	    static class ChangeMaker extends Thread{
	        @Override
	        public void run() {

	            int local_value = nonVolatileInt;
	            int local_value1=volatileInt;
	            while (volatileInt <5 && nonVolatileInt < 5){
	                System.out.println("Incrementing both volate and nonvolatile var to"+ (local_value+1));
	                nonVolatileInt = ++local_value;
	                volatileInt=++local_value1;
	                try {
	                    Thread.sleep(500);
	                } catch (InterruptedException e) { e.printStackTrace(); }
	            }
	        }
	    }
	}
