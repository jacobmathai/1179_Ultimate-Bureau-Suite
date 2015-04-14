package com.bino.smartutilityyy;

import com.ebin.fileexp.lite.a.Slsect_main_gridview_bg;
import com.ulimate.bureau.suite.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View;



public class Grid extends Activity implements OnClickListener{

	
	ImageView imageView_smart_coverter1,imageView_smart_game,imageView_smart_calculator,
	imageView_smart_flash,imageView_smart_cal;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from gridview_main.xml
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.smart_activity_grid);

		
		
		RelativeLayout relative_la_bg = (RelativeLayout) findViewById(R.id.relative_la_bg_smart_frontasasas);
		 SharedPreferences setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
			 
			 
		imageView_smart_coverter1 = (ImageView) findViewById(R.id.imageView_smart_coverter);
		imageView_smart_coverter1.setOnClickListener(this);
		imageView_smart_coverter1.setBackgroundResource(R.drawable.im_toggle_converter);
		
		imageView_smart_game = (ImageView) findViewById(R.id.imageView_smart_game);
		imageView_smart_game.setOnClickListener(this);
		imageView_smart_game.setBackgroundResource(R.drawable.im_toggle_game);
		
		imageView_smart_calculator = (ImageView) findViewById(R.id.imageView_smart_calculator);
		imageView_smart_calculator.setOnClickListener(this);
		imageView_smart_calculator.setBackgroundResource(R.drawable.im_toggle_calculator);
		
		imageView_smart_flash = (ImageView) findViewById(R.id.imageView_smart_flash);
		imageView_smart_flash.setOnClickListener(this);
		imageView_smart_flash.setBackgroundResource(R.drawable.im_toggle_flas);
		
		
		imageView_smart_cal = (ImageView) findViewById(R.id.imageView_smart_calendar);
		imageView_smart_cal.setOnClickListener(this);
		imageView_smart_cal.setBackgroundResource(R.drawable.im_toggle_calendar);
		}
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		switch (v.getId()) {
	case R.id.imageView_smart_coverter:
		imageView_smart_coverter1.setBackgroundResource(R.drawable.im_toggle_converter);
		Intent i3 = new Intent(Grid.this,UnitConverter.class);
		// Show the item position using toast
		Toast.makeText(Grid.this, "converter", 
				Toast.LENGTH_SHORT).show();
		// Send captured position to ViewImage.java
		//i3.putExtra("id", position);
		// Start ViewImage.java
		startActivity(i3);

break;

	  case R.id.imageView_smart_game:
		  imageView_smart_game.setBackgroundResource(R.drawable.im_toggle_game);
		  Intent i5 = new Intent(Grid.this,Front3.class);
			// Show the item position using toast
		//	Toast.makeText(Grid.this, "games", 
			//		Toast.LENGTH_SHORT).show();
			// Send captured position to ViewImage.java
			//i5.putExtra("id", position);
			// Start ViewImage.java
			startActivity(i5);

           
break;


case R.id.imageView_smart_calculator:
	imageView_smart_calculator.setBackgroundResource(R.drawable.im_toggle_calculator);
	Intent i2 = new Intent(Grid.this,Front2.class);
	// Show the item position using toast
	Toast.makeText(Grid.this, "calculators", 
			Toast.LENGTH_SHORT).show();
	// Send captured position to ViewImage.java
	//i2.putExtra("id", position);
	// Start ViewImage.java
	startActivity(i2);


break;


case R.id.imageView_smart_flash:
	imageView_smart_flash.setBackgroundResource(R.drawable.im_toggle_flas);
	Intent i = new Intent(Grid.this, Flashlightmain.class);

	startActivity(i);
break;


case R.id.imageView_smart_calendar:
	imageView_smart_cal.setBackgroundResource(R.drawable.im_toggle_calendar);
Intent i8 = new Intent(Grid.this,com.eeeeeeeeeeeee.calendar.Calendar_here_we_go.class);
	// Show the item position using toast
	Toast.makeText(Grid.this, "calendar", 
			Toast.LENGTH_SHORT).show();
	// Send captured position to ViewImage.java
//	i8.putExtra("id", position);
	// Start ViewImage.java
	startActivity(i8);

break;

default:
break;
		}
	}

}
