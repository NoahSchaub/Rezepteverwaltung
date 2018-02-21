package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Random;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.ims.rezepteverwaltung.services.AppDatabase;

public class MenuActivity extends AppCompatActivity {

    Button btnAlleRezepte;
    Button btnSuche;
    Button btnGluck;
    Button btnNeuesRezept;
    Button btnBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAlleRezepte = findViewById(R.id.btnAlleRezepte);
        btnSuche = findViewById(R.id.btnGoToSuche);
        btnGluck = findViewById(R.id.btnGluck);
        btnNeuesRezept = findViewById(R.id.btnNeuesRezept);
        btnBackup = findViewById(R.id.btnBackup);


        btnAlleRezepte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewActivity(RezepteListActivity.class);
            }
        });

        btnSuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewActivity(RezepteSucheActivity.class);
            }
        });
        btnNeuesRezept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewActivity(AddRezepteVariantenActivity.class);
            }
        });
        btnGluck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rezept random=getRandomRezept();
                System.out.println(random.getRezeptName());
                goToNewActivity(RezeptActivity.class);
            }
        });

    }

    public Rezept getRandomRezept() {
        List<Rezept> rezepte = AppDatabase.getAppDatabase(MainActivity.context).rezeptDAO().getAll();
        Random rand = new Random();
        return rezepte.get(rand.nextInt(rezepte.size()));
    }

    public void goToNewActivity(Class goToClass) {
        startActivity(new Intent(getApplicationContext(), goToClass));
    }
}
