// Project:		Java2DialogFragmentsEx
// Date:		2/18/2013
// Author:		Joe Kozlevcar
// Description:	Demonstrates how to use AlertBuilder to create a simple dialog

package com.example.java2dialogfragmentex;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class FireMissilesDialogFragment extends DialogFragment 
{
	@Override     
	public Dialog onCreateDialog(Bundle savedInstanceState) 
	{         
		// Use the Builder class for convenient dialog construction         
//		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//		AlertDialog.Builder builder = new Builder(getActivity());
		Builder builder = new Builder(getActivity());
		
		// set the title message and use chaining to set the positive and negative buttons
//		builder.setMessage(R.string.dialog_fire_missiles)                
//			.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() 
//			{                    
//				public void onClick(DialogInterface dialog, int id) 
//				{                        // FIRE ZE MISSILES!
//				}                
//			})                
//			.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
//			{                   
//				public void onClick(DialogInterface dialog, int id) 
//				{                        // User cancelled the dialog
//						
//				}                
//			});     
		
		// same as above without chaining
		builder.setMessage(R.string.dialog_fire_missiles);
		builder.setTitle("Title");
		
		// set the positive button
		builder.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() 
		{            
			// this method handles onClick events for the positive button
			public void onClick(DialogInterface dialog, int id) 
			{                        
				// FIRE ZE MISSILES!
				Toast.makeText(getActivity(), "Fire Selected ID=" + id, Toast.LENGTH_LONG).show();
				int a = android.R.id.button1;
			}                
		});

        builder.setNeutralButton(R.string.delay, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

                Toast.makeText(getActivity(), "Delay Selected ID=" + id, Toast.LENGTH_LONG).show();

            }


        });
		
		// set the negative button
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
		{          
			// this method handles onClick events for the positive button
			public void onClick(DialogInterface dialog, int id) 
			{                        
				// User cancelled the dialog
				Toast.makeText(getActivity(), "Cancel Selected ID=" + id, Toast.LENGTH_LONG).show();
			}                
		});     
					
		// Create the AlertDialog object and return it         
		return builder.create();     
	} 
				
}
