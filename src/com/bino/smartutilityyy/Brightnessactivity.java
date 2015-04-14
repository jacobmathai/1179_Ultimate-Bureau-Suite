///////////////////////////////////////////////////////////////////////////////////////////
//                                                   41 Post                             //
// Android: changing the screen brightness												 //
// Created by DimasTheDriver in 28/Mar/2011                                      		 //
// Available at:       http://www.41post.com/?p=3503                           		 	 //
///////////////////////////////////////////////////////////////////////////////////////////


package com.bino.smartutilityyy;



import com.ulimate.bureau.suite.R;
import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Brightnessactivity extends Activity 
{
	//UI objects//
	//the seek bar variable
	private SeekBar brightbar;

	// a variable to store the system brightness
	private int brightness;
	//the content resolver used as a handle to the system's settings
	private ContentResolver cResolver;
	//a window object, that will store a reference to the current window
	private Window window;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_activity_brightnessactivity);
        
        //get the seek bar from main.xml file
        brightbar = (SeekBar) findViewById(R.id.sb_brightbar1);
        
        //get the content resolver
        cResolver = getContentResolver();
        
        //get the current window
        window = getWindow();
        
        //seek bar settings//
        //sets the range between 0 and 255
        brightbar.setMax(255);
        //set the seek bar progress to 1
        brightbar.setKeyProgressIncrement(1);
      
        try 
        {
        	//get the current system brightness
        	brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
		} 
        catch (SettingNotFoundException e) 
		{
        	//throw an error case it couldn't be retrieved
			Log.e("Error", "Cannot access system brightness");
			e.printStackTrace();
		}
		
		//sets the progress of the seek bar based on the system's brightness
		brightbar.setProgress(brightness);

		//register OnSeekBarChangeListener, so it can actually change values
		brightbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) 
			{
				//set the system brightness using the brightness variable value
				System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
				
				//preview brightness changes at this window
				//get the current window attributes
				LayoutParams layoutpars = window.getAttributes();
				//set the brightness of this window
				layoutpars.screenBrightness = brightness / (float)255;
				//apply attribute changes to this window
				window.setAttributes(layoutpars);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) 
			{
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			{
				//sets the minimal brightness level
				//if seek bar is 20 or any value below
				if(progress<=20)
				{
					//set the brightness to 20
					brightness=20;
				}
				else //brightness is greater than 20
				{
					//sets brightness variable based on the progress bar 
					brightness = progress;
				}
			}
		});	
    }
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	this.finish();
    }
}