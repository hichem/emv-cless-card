package com.boussettahichem.emvclesscard;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private CardEmulation hceManager = null;
    private ComponentName emvClessCardServiceName = new ComponentName(EmvClessCardHceService.class.getPackage().getName(),
                                                                        EmvClessCardHceService.class.getSimpleName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the hce manager
        hceManager = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(getApplicationContext()));
    }


    @Override
    protected void onResume() {
        super.onResume();

        //Set our hce service as preferred
        hceManager.setPreferredService(this, emvClessCardServiceName);
    }


    @Override
    protected void onPause() {
        super.onPause();

        //Unset our hce service as preferred
        hceManager.unsetPreferredService(this);
    }
}
