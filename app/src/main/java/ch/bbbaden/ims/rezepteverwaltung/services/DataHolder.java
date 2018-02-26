package ch.bbbaden.ims.rezepteverwaltung.services;

import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Noah on 26.02.2018.
 */

public class DataHolder {
    @Setter
    @Getter
    private Rezept rezept;

    @Setter
    @Getter
    private List<Rezept> rezepteListe;


    private static final DataHolder holder = new DataHolder();

    public static DataHolder getInstance() {
        return holder;
    }
}
