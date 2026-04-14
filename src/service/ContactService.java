package service;

import repository.ContactReporitory;
import state.ContactState;
import vo.Contact;

import java.util.Map;

public class ContactService {
    private final ContactReporitory reporitory;
    private final ContactState state ;
    private  ContactReporitory contactReporitory;

    public ContactService(ContactReporitory reporitory, ContactState state) {
        this.reporitory = reporitory;
        this.state = state;
    }

    public void insert(String name, int age, String phone) {
        System.out.println("[ContactService.insert()]");
        //Contact 를 받은 데이터를 갖고 만들어요.
        Long id = state.getNextId();
        Contact contact = new Contact(id,name,age,phone);
        System.out.println(contact);

        //repository.ContactRepository.save()를 호출해서
        //store에 저장
        reporitory.save(id,contact);
        //출력
        System.out.println("저장된 거 출력");
        Map<Long,Contact> currStore = state.getStore();
        for (Long key : currStore.keySet()){
            System.out.println(currStore.get(key));
        }
    }

    public Map<Long, Contact> findAll() {
        System.out.println("[ContactService.findAll()]");
        return reporitory.findAll();
    }
}
