package view;

import service.ContactService;
import vo.Contact;

import java.util.Map;
import java.util.Scanner;


public class ContactView {
    private final Scanner sc ;
    private final ContactService contactService;
    public ContactView(Scanner sc, ContactService contactService) {
        this.sc = sc;
        this.contactService = contactService;
    }

    public void run(){
        while (true){
            System.out.println("1.추가  2.목록  3.수정  4.삭제  5.이름의 일부로 검색 -1:종료");
            int cmd = sc.nextInt();
            switch (cmd){
                case -1 :
                    return;
                case 1:
                    create();
                    break;
                case 2:
                    readAll();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                default:
                    System.out.println("잘 못 입력 함.");
            }
        }
    }
    private void search() {
        System.out.println("[ContactView.search()]");
    }
    private void delete() {
        System.out.println("[ContactView.delete()]");
    }
    private void readAll() {
        System.out.println("[ContactView.readAll()]");
        //맵을 읽어와서 화면에 출력
        Map<Long, Contact>store = contactService.findAll();
        if (store.isEmpty()){
            System.out.println("저장된 자료가 없습니다.");
        }
        //출력
        for(Long key : store.keySet()){
            System.out.println(store.get(key));
        }
    }
    private void update() {
        System.out.println("[ContactView.update()]");
    }

    private void create(){
        System.out.println("[ContactView.create()]");
        //이름과 나이, 전화번호를 입력받아서
        //서비스에 전달한다.
        String name;
        int age;
        String phone;
        System.out.println("이름 :");
        name = sc.next();
        System.out.println("나이 :");
        age = sc.nextInt();
        System.out.println("전화번호 :");
        phone = sc.next();

        //받은 값들을 service.ContactService.insert() 전달
        contactService.insert(name,age,phone);
    }
}
