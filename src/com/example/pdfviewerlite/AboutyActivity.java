package com.example.pdfviewerlite;



import com.ebin.fileexp.lite.a.Slsect_main_gridview_bg;
import com.ulimate.bureau.suite.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.Window;
import android.widget.RelativeLayout;

public class AboutyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about_activity);
        
		RelativeLayout relative_la_bg;
		relative_la_bg = (RelativeLayout) findViewById(R.id.relative_layout_about);
	SharedPreferences setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
			 
    }



    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	this.finish();
    }
}
