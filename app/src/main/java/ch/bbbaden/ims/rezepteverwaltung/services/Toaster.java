package ch.bbbaden.ims.rezepteverwaltung.services;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Noah on 19.02.2018.
 */

public class Toaster {
    public Toaster(Context context,String toToast,int duration  ) {
        Toast toast = Toast.makeText(context, toToast, duration);
        toast.show();
    }

}
