package inno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by vietto on 10.11.16.
 */
public class Musician {

    static int count;

    private String name;

    private int age;

    @Autowired
    @Qualifier("piano")
    private Instrument instrument;

    private List<String> songs;

    public Musician(String name) {
        this.name = name;
        count++;
    }

    public void play() {
        System.out.println(name + " playing on " + instrument.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}
