import ws.PersonsService;
import ws.PersonsService_Service;

/**
 * Created by vietto on 09.01.17.
 */
public class Tester {

    public static void main(String[] args) {
        PersonsService_Service service = new PersonsService_Service();
        PersonsService stub = service.getPersonsPort();

        System.out.println(service);
    }

}
