package aa_front;
import com.ebin.fileexp.lite.a.Slsect_main_gridview_bg;
import com.ulimate.bureau.suite.R;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Activity_first_launcher extends Activity implements OnClickListener{

	ImageView imv_fileexp, imv_pdf, imv_text_ed, imv_exit, imv_set,imv_util;
	RelativeLayout relative_la_bg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_first_launcher);
		
		
		relative_la_bg = (RelativeLayout) findViewById(R.id.relative_la_bg);
		 SharedPreferences setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
		
			 
			 imv_util = (ImageView) findViewById(R.id.imageView4);
			 imv_util.setOnClickListener(this);
			 imv_util.setBackgroundResource(R.drawable.im_toggle_utl);
			 
	      imv_fileexp = (ImageView) findViewById(R.id.imageView1);
	      imv_fileexp.setOnClickListener(this);
	      imv_fileexp.setBackgroundResource(R.drawable.im_toggle_fileexplorer);
	      
	      imv_pdf = (ImageView) findViewById(R.id.imageView2);
	      imv_pdf.setOnClickListener(this);
	      imv_pdf.setBackgroundResource(R.drawable.im_toggle_pdf);
	      
	      imv_text_ed = (ImageView) findViewById(R.id.imageView3);
	      imv_text_ed.setOnClickListener(this);
	      imv_text_ed.setBackgroundResource(R.drawable.im_toggle_edittext);
	      
	      imv_set = (ImageView) findViewById(R.id.imageView5);
	      imv_set.setOnClickListener(this);
	      imv_set.setBackgroundResource(R.drawable.im_toggle_utility);
	      
	      imv_exit = (ImageView) findViewById(R.id.imageView6);
	      imv_exit.setOnClickListener(this);
	      imv_exit.setBackgroundResource(R.drawable.im_toggle_exit1111);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.imageView1:
			                              imv_fileexp.setBackgroundResource(R.drawable.im_toggle_fileexplorer);
			                              Intent in = new Intent("com.ebin.fileexp.lite.ActivityListdirectry");
			                              startActivity(in);
			break;
		case R.id.imageView2:
			                               imv_pdf.setBackgroundResource(R.drawable.im_toggle_pdf);
			                               Intent in1 = new Intent("com.example.pdfviewerlite.ActivityFront");
				                              startActivity(in1);
				                             
       break;
		case R.id.imageView3:
			                                imv_text_ed.setBackgroundResource(R.drawable.im_toggle_edittext);
			                                Intent in2 = new Intent("com.ultimate.text.editer.pmTextEdit");
				                              startActivity(in2);
       break;
       
		case R.id.imageView4:
			            Intent in222 = new Intent("com.bino.smartutilityyy.Grid");
                            startActivity(in222);
               			 imv_util.setBackgroundResource(R.drawable.im_toggle_utl);
			
			
			break;
			
			
		case R.id.imageView5:
                                imv_set.setBackgroundResource(R.drawable.im_toggle_utility);
                                Intent in22 = new Intent("com.ebin.fileexp.lite.a.Activity_fileexp_settings");
	                              startActivity(in22);
       break;
		case R.id.imageView6:
			                                imv_exit.setBackgroundResource(R.drawable.im_toggle_exit1111);
			                                 Intent in_about = new Intent("com.example.pdfviewerlite.AboutyActivity");
			           	                                     startActivity(in_about);
        break;

		default:
			break;
		}
	}
}
