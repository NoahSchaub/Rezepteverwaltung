package ch.bbbaden.ims.rezepteverwaltung.services;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;

/**
 * Created by Noah on 19.02.2018.
 */

@Dao
public interface RezeptDAO {
    @Query("SELECT * FROM user")
    List<Rezept> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<Rezept> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    Rezept findByName(String first, String last);

    @Insert
    void insertAll(Rezept... users);

    @Delete
    void delete(Rezept user);
}
