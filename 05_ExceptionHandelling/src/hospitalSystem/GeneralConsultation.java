package hospitalSystem;

public class GeneralConsultation extends HospitalService implements ServiceValidation {

    public GeneralConsultation(int id, String name, double fee)
            throws InvalidServiceException {

        super(id, name, fee);
        System.out.println("General Consultation Created");
    }

    @Override
    public void processService() {

        System.out.println("Processing General Consultation...");
        System.out.println("Doctor consultation scheduled.");
    }

    @Override
    public boolean validateService() {

        return consultationFee >= 200;
    }
}