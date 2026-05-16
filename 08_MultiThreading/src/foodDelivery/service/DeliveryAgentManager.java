package foodDelivery.service;

import java.util.concurrent.atomic.AtomicInteger;
public class DeliveryAgentManager {
    private AtomicInteger agentCounter = new AtomicInteger(1);

	    public String assignAgent() {
	        return "Agent-" + agentCounter.getAndIncrement();
	    }
	}
	