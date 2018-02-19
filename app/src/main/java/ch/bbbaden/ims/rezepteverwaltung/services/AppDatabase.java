package ch.bbbaden.ims.rezepteverwaltung.services;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;

/**
 * Created by Noah on 19.02.2018.
 */

@Database(entities = {Rezept.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RezeptDAO RezeptDao();
}