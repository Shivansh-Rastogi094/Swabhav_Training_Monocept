package foodDelivery.threads;


	public class LoggerDaemon extends Thread {

	    @Override
	    public void run() {
	        while (true) {
	            try {
	                Thread.sleep(3000);
	                System.out.println("Logger: System running smoothly...");
	            } catch (InterruptedException e) {
	                break;
	            }
	        }
	    }
	}
