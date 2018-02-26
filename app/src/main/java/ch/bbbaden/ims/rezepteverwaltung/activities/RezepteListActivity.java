package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.ims.rezepteverwaltung.services.AppDatabase;

public class RezepteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte_list);
        System.out.println("Get Rezepte from DB");
        List<Rezept> rezepts = getRezepte(AppDatabase.getAppDatabase(MainActivity.context));
        for (int i = 0; i < rezepts.size(); i++) {
            System.out.println("Rezept: " + rezepts.get(i).getRezeptName());
            System.out.println("Rezept" + rezepts.get(i).getRezeptId());
            System.out.println("---------");
        }
        System.out.println("End of Loop");
    }

    private static List<Rezept> getRezepte(final AppDatabase db) {
        List<Rezept> rezepts = db.rezeptDAO().getAll();
        System.out.println("RezepteListe Grösse: " + rezepts.size());
        return rezepts;
    }
}
