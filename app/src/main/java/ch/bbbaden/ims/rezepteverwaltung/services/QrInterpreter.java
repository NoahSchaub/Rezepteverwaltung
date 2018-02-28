package ch.bbbaden.ims.rezepteverwaltung.services;

import ch.bbbaden.ims.rezepteverwaltung.activities.MainActivity;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;

/**
 * Created by Noah on 28.02.2018.
 */

public class QrInterpreter {

    public Rezept interpretQr(String qrResult) {
        Rezept tempReturnRezept = new Rezept();
        tempReturnRezept.setRezeptId(AppDatabase.getAppDatabase(MainActivity.context).rezeptDAO().getAll().size() + 1);
        tempReturnRezept.setRezeptName("QR Scaner comming soon");
        tempReturnRezept.setRezeptZubereitung(qrResult);
        tempReturnRezept.setRezeptDauer("Soon(tm)");


        return tempReturnRezept;
    }
}
