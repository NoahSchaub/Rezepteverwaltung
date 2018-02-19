package ch.bbbaden.ims.rezepteverwaltung.objects;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Noah on 19.02.2018.
 */

public class Rezept {

    @Getter
    @Setter
    private int rezeptId;

    @Getter
    @Setter
    private String rezeptName;

    @Getter
    @Setter
    private List<List<String>> rezeptZutaten;

    @Getter
    @Setter
    private String rezeptZubereitung;

    @Getter
    @Setter
    private String rezeptDauer;
}
