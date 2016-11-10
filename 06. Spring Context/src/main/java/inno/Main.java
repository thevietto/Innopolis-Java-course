package inno;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import inno.test.Cinema;
import inno.test.Film;

/**
 * Created by vietto on 10.11.16.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Musician oleg = (Musician) context.getBean("oleg");

        System.out.println(oleg.getName());
        System.out.println(oleg.getAge());
        oleg.play();

        Musician petr = (Musician) context.getBean("petr");
        petr.play();
        for (String s : petr.getSongs()) {
            System.out.println(s);
        }


        Cinema bean = (Cinema) context.getBean("cinema");
        System.out.println("Комедии");
        for (Film film : bean.getComedies()) {
            System.out.println(film.getName());
        }

        System.out.println("Ужастики");
        for (Film film : bean.getHorrors()) {
            System.out.println(film.getName());
        }

    }

}
