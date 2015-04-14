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
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Front3 extends Activity {
Button sud,sn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smart_front3);
		
		
		
	LinearLayout	relative_la_bg = (LinearLayout) findViewById(R.id.LinearLayout_smart_front3);
		 SharedPreferences setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
			 
			 
		sn =(Button) findViewById(R.id.s1);
		sud = (Button) findViewById(R.id.sd1);
		sud.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent tic = new Intent(getApplicationContext(),bino.tic.MenuActivity.class);
				Toast.makeText(getApplicationContext(), "tic tac toe", Toast.LENGTH_SHORT).show();
			    startActivity(tic);
			}
		});
		sn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent snake = new Intent(getApplicationContext(),Sudoku.class);
				Intent snake = new Intent(getApplicationContext(),com.bino.snake.TitleScreen.class);
				Toast.makeText(getApplicationContext(), "Snake", Toast.LENGTH_SHORT).show();
			    startActivity(snake);
			}
		});
	}

	

}
