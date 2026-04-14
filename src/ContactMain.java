import repository.ContactReporitory;
import service.ContactService;
import state.ContactState;
import view.ContactView;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        //처음 생성할 때 스캐너를 갖고 시작하도록 스캐너를
        //생성자 주입방법으로 널고 시작
        Scanner scanner = new Scanner(System.in);
        ContactState state = new ContactState();
        ContactReporitory reporitory = new ContactReporitory(state);
        ContactService contactService = new ContactService(reporitory,state);
        ContactView contactView = new ContactView(scanner,contactService);
        //화면 호출
        contactView.run();
    }
}
