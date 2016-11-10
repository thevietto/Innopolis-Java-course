package inno;

import org.springframework.beans.factory.annotation.Qualifier;

@MusicInstrument
@Qualifier("piano")
public class Piano implements Instrument {
    public String getName() {
        return "piano";
    }
}
