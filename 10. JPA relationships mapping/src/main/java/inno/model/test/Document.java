package inno.model.test;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Document {

    @Id
    private Long id;

    private String name;

    private String number;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    // em.createQuery("select d from Document d where d.student_id = id")
    private Student student;


}
