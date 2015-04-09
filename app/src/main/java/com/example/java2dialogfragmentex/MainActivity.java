// Project:		Java2DialogFragmentsEx
// Date:		2/18/2013
// Author:		Joe Kozlevcar
// Description:	Demonstrates how to use AlertBuilder to create a simple dialog

package com.example.java2dialogfragmentex;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
    private Button fireButton;
    private Button colorButton;
    private Button toppingsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        // create the Java object for the fire button
        fireButton = (Button)findViewById(R.id.fireButton);
        fireButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // create a Dialog Fragment and show it
                DialogFragment newFragment = new FireMissilesDialogFragment();
                newFragment.show(getFragmentManager(), "missiles");
            }
        });

        // create the Java object for the color button
        colorButton = (Button)findViewById(R.id.colorButton);
        colorButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // create a Dialog Fragment and show it
                DialogFragment newFragment = new ColorDialogFragment();
                newFragment.show(getFragmentManager(), "colors");
            }
        });

        // create the Java object for the color button
        toppingsButton = (Button)findViewById(R.id.toppingsButton);
        toppingsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // create a Dialog Fragment and show it
                DialogFragment newFragment = new ToppingsDialogFragment();
                newFragment.show(getFragmentManager(), "toppings");
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
