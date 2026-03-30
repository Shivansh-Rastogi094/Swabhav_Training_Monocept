package hospitalSystem;

public class DiagnosticTest extends HospitalService implements ServiceValidation {

    public DiagnosticTest(int id, String name, double fee)
            throws InvalidServiceException {

        super(id, name, fee);
        System.out.println("Diagnostic Test Created");
    }

    @Override
    public void processService() {

        System.out.println("Processing Diagnostic Test...");
        System.out.println("Lab test scheduled.");
    }

    @Override
    public boolean validateService() {

        return consultationFee >= 500;
    }
}