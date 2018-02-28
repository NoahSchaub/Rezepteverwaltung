package ch.bbbaden.ims.rezepteverwaltung.activities;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import ch.bbbaden.ims.rezepteverwaltung.R;
import ch.bbbaden.ims.rezepteverwaltung.activities.barcode.BarcodeCaptureActivity;
import ch.bbbaden.ims.rezepteverwaltung.services.DataHolder;
import ch.bbbaden.ims.rezepteverwaltung.services.QrInterpreter;

public class AddRezepteVariantenActivity extends AppCompatActivity {

    Button btnQr;
    Button btnManuel;
    private static final int BARCODE_READER_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rezepte_varianten);

        btnQr = findViewById(R.id.btnQr);
        btnManuel = findViewById(R.id.btnManuel);

        btnManuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewActivity(AddRezeptActivity.class);
            }
        });

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BarcodeCaptureActivity.class);
                startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    Point[] p = barcode.cornerPoints;
                    String qrResultat = barcode.displayValue;
                    System.out.println("QR Code        " + barcode.displayValue);
                    DataHolder.getInstance().setRezept(new QrInterpreter().interpretQr(qrResultat));
                    goToNewActivity(RezeptActivity.class);

                } else {
//                    mResultTextView.setText(R.string.no_barcode_captured);
                }
            } else {
//                Log.e(LOG_TAG, String.format(getString(R.string.barcode_error_format),
//                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void goToNewActivity(Class goToClass) {
        startActivity(new Intent(getApplicationContext(), goToClass));
    }
}

