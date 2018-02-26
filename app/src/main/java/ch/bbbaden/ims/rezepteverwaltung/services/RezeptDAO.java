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
    @Query("SELECT * FROM rezepte")
    List<Rezept> getAll();

    @Query("SELECT * FROM rezepte WHERE rezeptId IN (:rezeptId)")
    Rezept loadAllByIds(int rezeptId);

    @Query("SELECT * FROM rezepte WHERE rezeptName LIKE :name LIMIT 1")
    Rezept findByName(String name);

    @Insert
    void insertAll(Rezept... rezepte);

    @Delete
    void delete(Rezept rezept);
}
