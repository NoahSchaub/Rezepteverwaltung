package ch.bbbaden.ims.rezepteverwaltung.services;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.activities.MainActivity;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;

/**
 * Created by Noah on 26.02.2018.
 */

public class FirebaseConector {
    DatabaseReference mDatabase;

    public FirebaseConector() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        System.out.println("FirebaseConector--------------------");
//        deleteAll(AppDatabase.getAppDatabase(MainActivity.context));
    }

    public void downloadAllRezepte() {
        mDatabase.child("rezept").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List rezepte = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    Rezept rezept = noteDataSnapshot.getValue(Rezept.class);
                    System.out.println(rezept.getRezeptName() + " current RezeptName-------------------------------------------------------------------------------------------------");
                    if (getByIdRezepte(AppDatabase.getAppDatabase(MainActivity.context), rezept) == null) {
                        addRezepte(AppDatabase.getAppDatabase(MainActivity.context), rezept);
                    }
                }
                System.out.println("From Firebase");
                System.out.println(rezepte);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private static Rezept addRezepte(final AppDatabase db, Rezept rezept) {
        db.rezeptDAO().insertAll(rezept);
        return rezept;
    }

    private static Rezept getByIdRezepte(final AppDatabase db, Rezept rezept) {
        Rezept returnRezept = db.rezeptDAO().loadAllByIds(rezept.getRezeptId());
        return returnRezept;
    }
//    private static void deleteAll(final AppDatabase db){
//        for(int i=0;i<(db.rezeptDAO().getAll().size()+1);i++){
//            db.rezeptDAO().delete(db.rezeptDAO().getAll().get(i));
//        }
//    }
}
