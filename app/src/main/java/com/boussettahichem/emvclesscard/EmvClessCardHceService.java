package com.boussettahichem.emvclesscard;

import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

public class EmvClessCardHceService extends HostApduService {

	
	private static final String	TAG = "EmvClessCardHceService";
	private TestCard card ;
	Intent intent = null;
	
	public EmvClessCardHceService(){
		card = new TestCard(true) ;
	}
	
	
	@Override
	public byte[] processCommandApdu(byte[] apdu, Bundle extras) {

		byte rep[] ;
		Log.i(TAG, "Command recived : " + hextostring(apdu) );
		
		rep = card.send(apdu) ;
		
		Log.i(TAG, "Send response : " + hextostring(rep) );
		return rep ;
	
		
	}

	@Override
	public void onDeactivated(int reason) {
		Log.i(TAG, "Deactivated: " + reason);
	}
	
	
	private String hextostring(byte[] tab){
		String s = "" ;
		for(int i=0 ; i<tab.length ;i++){
			//s += Integer.toHexString(tab[i] & 0xFF) +" " ;
			s += String.format("%02x ", tab[i]);
	    }
	    	
		return s ;
	}
	
	
}