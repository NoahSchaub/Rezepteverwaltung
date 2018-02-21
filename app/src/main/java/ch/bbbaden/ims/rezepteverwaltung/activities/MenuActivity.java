package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ch.bbbaden.ims.rezepteverwaltung.R;

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
                goToNewActivity(RezepteActivity.class);
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
                goToNewActivity(AddRezeptActivity.class);
            }
        });

    }

    public void goToNewActivity(Class goToClass){
        startActivity(new Intent(getApplicationContext(), goToClass));
    }
}
