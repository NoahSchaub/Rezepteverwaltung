package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.ims.rezepteverwaltung.services.DataHolder;
import ch.bbbaden.ims.rezepteverwaltung.services.Toaster;

public class RezeptActivity extends AppCompatActivity {
    Rezept rezeptToShow;

    TextView viewDauer;
    TextView viewZubereitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rezeptToShow = DataHolder.getInstance().getRezept();
        viewDauer = findViewById(R.id.viewRezeptDauer);
        viewZubereitung = findViewById(R.id.viewRezeptZubereitung);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Toaster(view, rezeptToShow.getRezeptId() + "", 0);
            }
        });


        setTitle(rezeptToShow.getRezeptName());
        viewDauer.setText(rezeptToShow.getRezeptDauer());
        viewZubereitung.setText(rezeptToShow.getRezeptZubereitung());

    }
}
