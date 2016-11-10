package inno;

import org.springframework.beans.factory.annotation.Qualifier;

@MusicInstrument
@Qualifier("guitar")
public class Guitar implements Instrument {

    public String getName() {
        return "guitar";
    }
}
