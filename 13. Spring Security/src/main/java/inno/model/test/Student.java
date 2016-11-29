package inno.model.test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String middlename;

    @Column(name = "sex")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order")
    private List<Document> documents;

    private String hobbies;

    @Transient
    private List<String> hobbiesList;

    @ManyToMany
    @JoinTable(name = "st_el", joinColumns = {
            @JoinColumn(name = "student_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "elective_id")
    })
    private List<Elective> electives;

    public List<String> getHobbies() {
        return Arrays.asList(hobbies.split(","));
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
        if (hobbiesList == null) {
            hobbiesList = new ArrayList<>();
        }
        hobbiesList.addAll(Arrays.asList(hobbies.split(",")));
    }

    public List<Elective> getElectives() {
        return electives;
    }

    public void setElectives(List<Elective> electives) {
        this.electives = electives;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


    public static void main(String[] args) {
        int number = 11;
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(number & 4));
    }
}
