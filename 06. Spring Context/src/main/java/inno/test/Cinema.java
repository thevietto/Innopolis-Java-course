package inno.test;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cinema {

    @Comedies
    private List<Film> comedies;

    @Horrors
    private List<Film> horrors;


    public List<Film> getComedies() {
        return comedies;
    }

    public void setComedies(List<Film> comedies) {
        this.comedies = comedies;
    }

    public List<Film> getHorrors() {
        return horrors;
    }

    public void setHorrors(List<Film> horrors) {
        this.horrors = horrors;
    }
}
