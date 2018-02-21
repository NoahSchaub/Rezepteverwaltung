
package ch.bbbaden.ims.rezepteverwaltung.services;

import java.util.ArrayList;
import java.util.List;

import ch.bbbaden.ims.rezepteverwaltung.activities.MainActivity;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;

/**
 * Created by Noah on 21.02.2018.
 */

public class SearchRezepte {

    public List<Rezept> doSearch(String queryName, String queryAuthor, List<String> queryZutaten) {

        List<Rezept> alleRezepte = getAlleRezepte(AppDatabase.getAppDatabase(MainActivity.context));
        List<Rezept> namenRezepte = new ArrayList<>();
        List<Rezept> authorRezepte = new ArrayList<>();
        List<Rezept> zutatenRezepte = new ArrayList<>();

        if (queryName != "") {
            for (int i = 0; i < alleRezepte.size(); i++) {
                if (alleRezepte.get(i).getRezeptName().contains(queryName)) {
                    namenRezepte.add(alleRezepte.get(i));
                }
            }
        } else {
            namenRezepte = alleRezepte;
        }

        if (queryAuthor != "") {
            for (int i = 0; i < namenRezepte.size(); i++) {
                if (namenRezepte.get(i).getRezeptName().contains(queryAuthor)) {
                    authorRezepte.add(namenRezepte.get(i));
                }
            }
        } else {
            authorRezepte = namenRezepte;
        }

        if (queryZutaten.size() < 0) { //TODO wieder zu > ändern
//            for (int i = 0; i > authorRezepte.size(); i++) {
//                for (int j = 0; i > authorRezepte.get(i).getRezeptZutaten[1].size(); j++) {
//                    for (int l = 0; l > queryZutaten.size(); l++) {
//                        if (authorRezepte.get(i).getRezeptZutaten[1].get(j) == queryZutaten.get(l)) {
//                            zutatenRezepte.add(authorRezepte.get(i));
//                        }
//                    }
//                }
//            }
        }else{
            zutatenRezepte=authorRezepte;
        }

        return zutatenRezepte;
    }


    private static List<Rezept> getAlleRezepte(final AppDatabase db) {
        return db.rezeptDAO().getAll();
    }
}