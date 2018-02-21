package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.ims.rezepteverwaltung.services.AppDatabase;

public class RezepteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte_list);
//        TextView[][] textViews = new TextView[6][6];
//        int[][] ids = {{R.id.name1, R.id.Zubereitung1},
//                        {R.id.name2, R.id.Zubereitung2},
//                        {R.id.name3, R.id.Zubereitung3}};
//
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 1; i++) {
//                textViews[i][j] = findViewById(ids[i][j]);
//            }
//        }
        List<Rezept> rezepts = getRezepte(AppDatabase.getAppDatabase(MainActivity.context));
//
        for (int i = 0; i < rezepts.size(); i++) {
            System.out.println(rezepts.get(i).getRezeptName());
        }

        TextView name1=findViewById(R.id.name1);
        TextView zub1=findViewById(R.id.Zubereitung1);
        TextView name2=findViewById(R.id.name2);
        TextView zub2=findViewById(R.id.Zubereitung2);
        TextView name3=findViewById(R.id.name3);
        TextView zub3=findViewById(R.id.Zubereitung3);

        name1.setText(rezepts.get(0).getRezeptName());
        zub1.setText(rezepts.get(0).getRezeptZubereitung());
       name2.setText(rezepts.get(1).getRezeptName());
//        name3.setText(rezepts.get(3).getRezeptName());

    }

    private static List<Rezept> getRezepte(final AppDatabase db) {
        List<Rezept> rezepts = db.rezeptDAO().getAll();
        System.out.println(rezepts.size());
        return rezepts;
    }
}
