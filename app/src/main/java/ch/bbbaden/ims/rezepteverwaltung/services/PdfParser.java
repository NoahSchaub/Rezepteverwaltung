package ch.bbbaden.ims.rezepteverwaltung.services;

import android.os.AsyncTask;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

import ch.bbbaden.ims.rezepteverwaltung.activities.MenuActivity;
import ch.bbbaden.ims.rezepteverwaltung.objects.Rezept;

//import org.apache.commons.vfs2.FileNotFoundException;

/**
 * Created by Noah on 26.02.2018.
 */

public class PdfParser extends AsyncTask<String, Void, Rezept> {


    private Exception exception;

    protected Rezept doInBackground(String[] rezept) {
        try {
            System.out.println("PDF parser start");
            URL url = new URL(rezept[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.connect();

            System.out.println("PDF parser download pdf");

            InputStream inputStream = urlConnection.getInputStream();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            //inputStream = new FileInputStream(new File(rezept[0]));
            ParseContext pcontext = new ParseContext();

            System.out.println("PDF parser parsing");

            //parsing the document using PDF parser
            PDFParser pdfparser = new PDFParser();
            pdfparser.parse(inputStream, handler, metadata, pcontext);

            //getting the content of the document
            System.out.println(
                    "Contents of the PDF :" + handler.toString());
            new Toaster(MenuActivity.context, "Contents of the PDF :" + handler.toString(), -2);

            //getting metadata of the document
            System.out.println(
                    "Metadata of the PDF:");
            String[] metadataNames = metadata.names();

            for (String name : metadataNames) {
                System.out.println(name + " : " + metadata.get(name));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("PDF parser catched");

        }
        try {
            System.out.println("Try-------------------------------------------------------------------------");
            URL website = new URL("https://www.bj.admin.ch/dam/data/bj/staat/rechtsinformatik/magglingen/2011/11a_wolf-d.pdf");
            System.out.println("1");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            System.out.println("2");
            FileOutputStream fos = new FileOutputStream("p.pdf");
            System.out.println("3");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("DOne------------------------------------------------------------------------");

        } catch (MalformedURLException ex) {
            System.out.println("catched1");
            Logger.getLogger(PdfParser.class.getName()).log(Level.SEVERE, null, ex);

        } catch (FileNotFoundException ex) {

            System.out.println("cateched2");
        } catch (IOException ex) {


        }
        return null;
    }
}
