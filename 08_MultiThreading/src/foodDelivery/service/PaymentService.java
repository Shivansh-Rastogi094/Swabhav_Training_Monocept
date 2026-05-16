package foodDelivery.service;
public class PaymentService {

    public void processPayment(String orderId) {
        try {
            Thread.sleep(500); // simulate delay
            System.out.println(orderId + ": Payment processed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}