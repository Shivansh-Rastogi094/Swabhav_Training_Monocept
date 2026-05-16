package hospitalSystem;

public class Surgery extends HospitalService implements ServiceValidation {

    public Surgery(int id, String name, double fee)
            throws InvalidServiceException {

        super(id, name, fee);
        System.out.println("Surgery Service Created");
    }

    @Override
    public void processService() {

        System.out.println("Processing Surgery...");
        System.out.println("Operating room scheduled.");
    }

    @Override
    public boolean validateService() {

        return consultationFee >= 5000;
    }
}