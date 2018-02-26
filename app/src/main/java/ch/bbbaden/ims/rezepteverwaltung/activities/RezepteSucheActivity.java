package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.ims.rezepteverwaltung.services.DataHolder;
import ch.bbbaden.ims.rezepteverwaltung.services.SearchRezepte;

public class RezepteSucheActivity extends AppCompatActivity {

    Button btnSearch;
    EditText editName;
    EditText editAuthor;

    String queryName;
    String queryAuthor;
    List<String> queryZutaten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte_suche);

        editName = findViewById(R.id.editSuchName);
        editAuthor = findViewById(R.id.editSuchAuthor);
        btnSearch = findViewById(R.id.btnSearch);

        queryZutaten = new ArrayList<>();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryName = editName.getText().toString();
                queryAuthor = editAuthor.getText().toString();

                List<Rezept> rezepts =new SearchRezepte().doSearch(queryName,queryAuthor,queryZutaten);

                for(int i=0; i<rezepts.size();i++){
                    System.out.println(rezepts.get(i).getRezeptName());
                    System.out.println(rezepts.get(i).getRezeptZubereitung());
                }
                if (rezepts.size() == 1) {
                    DataHolder.getInstance().setRezept(rezepts.get(0));
                    startActivity(new Intent(getApplicationContext(), RezeptActivity.class));
                }
            }
        });
    }
}
