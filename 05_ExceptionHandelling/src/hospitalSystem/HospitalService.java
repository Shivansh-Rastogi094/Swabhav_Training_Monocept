package hospitalSystem;

public abstract class HospitalService {

    protected int serviceId;
    protected String patientName;
    protected double consultationFee;

    static {
        System.out.println("Loading Hospital Configuration...");
    }

    public HospitalService(int id, String name, double fee)
            throws InvalidServiceException {

        System.out.println("HospitalService Constructor Called");

        if (id <= 0)
            throw new InvalidServiceException("Service ID must be positive");

        if (name == null || name.trim().isEmpty())
            throw new InvalidServiceException("Patient name cannot be empty");

        if (fee <= 0)
            throw new InvalidServiceException("Service fee must be positive");

        serviceId = id;
        patientName = name;
        consultationFee = fee;
    }

    public void displayService() {

        System.out.println("\nService ID: " + serviceId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Consultation Fee: " + consultationFee);
    }

    public abstract void processService();
}