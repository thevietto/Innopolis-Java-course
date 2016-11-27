package inno.model.test;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Elective {

    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "electives")
    private List<Student> students;

    @ElementCollection
    @JoinTable(name = "elective_dates", joinColumns = {@JoinColumn(name = "elective_id")})
    private List<Date> dates;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
