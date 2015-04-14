package com.bino.smartutilityyy;

import com.ebin.fileexp.lite.a.Slsect_main_gridview_bg;
import com.ulimate.bureau.suite.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Front2 extends Activity {
Button ag,calo,loan;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smart_front2);
		
		
		
		LinearLayout	relative_la_bg = (LinearLayout) findViewById(R.id.LinearLayout_smart_front2);
		 SharedPreferences setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
			 
			 
			 
		ag = (Button) findViewById(R.id.age1);
	   //n88=(Button) findViewById(R.id.nig1);
		calo=(Button) findViewById(R.id.call1);
	
		ag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent agecalculator = new Intent(getApplicationContext(),Agecalculatormain.class);
				Toast.makeText(getApplicationContext(), "AGE CALCULATOR", Toast.LENGTH_SHORT).show();
			    startActivity(agecalculator);
			}
		});
       // n88.setOnClickListener(new OnClickListener() {
			
		//	@Override
		//	public void onClick(View v) {
		//		// TODO Auto-generated method stub
		//		Intent nightdual= new Intent(getApplicationContext(),Nightcalculator.class);
		//		Toast.makeText(getApplicationContext(), "NIGHT CALCULATOR", Toast.LENGTH_SHORT).show();
		//	    startActivity(nightdual);	
		//	}
		//});
        calo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent calu= new Intent(getApplicationContext(),Calculatoronly.class);
				Toast.makeText(getApplicationContext(), "CALCULATOR", Toast.LENGTH_SHORT).show();
			    startActivity(calu);	
			}
		});
       
	}
	
	

}
