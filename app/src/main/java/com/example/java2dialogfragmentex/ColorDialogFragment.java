// Project:		Java2DialogFragmentsEx
// Date:		2/18/2013
// Author:		Joe Kozlevcar
// Description:	Demonstrates how to use AlertBuilder to create a simple dialog

package com.example.java2dialogfragmentex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

public class ColorDialogFragment extends DialogFragment 
{
	private String[] arr;	// string array to hold list of colors
	
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		// create the Dialog builder object
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	
		// Because the list appears in the dialog's content area, the dialog cannot show both a message 
		// and a list and you should set a title for the dialog with setTitle().
//		builder.setMessage(R.string.pick_color);
		
		builder.setTitle("Pick a Color");
		
		
		// get the resource object and then copy the resource array to a String array
		Resources res = this.getResources(); 
		arr = res.getStringArray(R.array.colors_array); 

		// set the onClick listener
		builder.setItems(R.array.colors_array, new DialogInterface.OnClickListener() 
		{	
			// this method handles onClick events for a selected color
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				Toast.makeText(getActivity(), "Color Selected: " + arr[which], Toast.LENGTH_LONG).show();
			}
		});
		
		// return the dialog
		return builder.create();
	}
}
