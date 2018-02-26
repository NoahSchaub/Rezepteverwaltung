package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.ims.rezepteverwaltung.services.AppDatabase;
import ch.bbbaden.ims.rezepteverwaltung.services.DataHolder;

public class RezepteListActivity extends AppCompatActivity {
    List<Rezept> rezepte;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte_list);

        rezepte = DataHolder.getInstance().getRezepteListe();
        listView = findViewById(R.id.listView);

        String[] listItems = new String[rezepte.size()];
// 3
        for (int i = 0; i < rezepte.size(); i++) {
            Rezept recipe = rezepte.get(i);
            listItems[i] = recipe.getRezeptName();
        }
// 4
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Rezept selectedRecipe = rezepte.get(position);
                DataHolder.getInstance().setRezept(selectedRecipe);
                startActivity(new Intent(getApplicationContext(), RezeptActivity.class));
            }

        });
    }

    private static List<Rezept> getRezepte(final AppDatabase db) {
        List<Rezept> rezepts = db.rezeptDAO().getAll();
        System.out.println("RezepteListe Grösse: " + rezepts.size());
        return rezepts;
    }
}