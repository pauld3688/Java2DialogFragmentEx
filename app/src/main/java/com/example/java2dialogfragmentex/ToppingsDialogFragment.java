// Project:		Java2DialogFragmentsEx
// Date:		2/18/2013
// Author:		Joe Kozlevcar
// Description:	Demonstrates how to use AlertBuilder to create a simple dialog

package com.example.java2dialogfragmentex;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

public class ToppingsDialogFragment extends DialogFragment 
{
	private ArrayList<Object> mSelectedItems = new ArrayList<Object>();	// hint: use static for Lab6
	private String msg = "";			// message to be displayed in Toast
	private String[] arr;		// array of toppings

    private static boolean[] boolArray = new boolean[3];
    private static boolean[] savingArray = new boolean[3];
    private static ArrayList<Object> saveSelectedItems = new ArrayList<Object>();

	
	// hint: for lab 6 maybe use a static boolean array

	
	@Override public Dialog onCreateDialog(Bundle savedInstanceState) 
	{   
		// create the Dialog builder object    
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());     
		
		// Set the dialog title     
		builder.setTitle(R.string.pick_toppings);     
		
		// get the resource object and then copy the toppings resource array to a String array
		Resources res = this.getResources(); 
		arr = res.getStringArray(R.array.toppings);
		
		
		// Specify the list array, the items to be selected by default (null for none),     
		// and the listener through which to receive callbacks when items are selected 
		// Parameters
		// itemsId  the resource id of an array i.e. R.array.foo 
		// checkedItems  specifies which items are checked. It should be null in which case no items are checked. 
		//If non null it must be exactly the same length as the array of items. 
		// listener  notified when an item on the list is clicked. The dialog will not be dismissed when an item is clicked. 
		// It will only be dismissed if clicked on a button, if no buttons are supplied it's up to the user to dismiss the dialog. 

		builder.setMultiChoiceItems(R.array.toppings, null, new DialogInterface.OnMultiChoiceClickListener() 
		{           
			// method to handle click events on checkboxes
			// Parameters
			// dialog  The dialog where the selection was made. 
			// which  The position of the item in the list that was clicked. 
			// isChecked  True if the click checked the item, else false.  

			@Override                
			public void onClick(DialogInterface dialog, int which, boolean isChecked) 
			{                    
				if (isChecked) 
				{                        
					// If the user checked the item, add it to the selected items                        
					mSelectedItems.add(which);   
				} 
				else if (mSelectedItems.contains(which)) 
				{                        
					// Else, if the item is already in the array, remove it                         
					mSelectedItems.remove(Integer.valueOf(which)); 
				}  
			}            
		});
		
		// Set the positive action button            
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() 
		{                
			@Override                
			public void onClick(DialogInterface dialog, int id) 
			{                    
				// User clicked OK, so save the mSelectedItems results somewhere                    
				// or return them to the component that opened the dialog
				
				// build a string from the selected items and display them in a Toast
				for(Object item : mSelectedItems)
				{
					msg += arr[Integer.parseInt(item.toString())] + " ";
				}
				Toast.makeText(getActivity(), "Selected: " + msg, Toast.LENGTH_LONG).show();

                System.arraycopy(boolArray, 0, savingArray, 0, 3);
                saveSelectedItems = (ArrayList<Object>)saveSelectedItems.clone();
			}            
		});

		// negative action button
		builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
		{                
			@Override                
			public void onClick(DialogInterface dialog, int id) 
			{         
				Toast.makeText(getActivity(), "Cancel Selected", Toast.LENGTH_LONG).show();

                System.arraycopy(savingArray, 0, boolArray, 0, 3);
                mSelectedItems = (ArrayList<Object>)mSelectedItems.clone();
			}            
		});      
		
		return builder.create(); 
	} // end of onCreate
} // end of class
		
