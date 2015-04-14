package com.bino.smartutilityyy;

import java.util.Calendar;
import java.util.Timer;

import com.ebin.fileexp.lite.a.Slsect_main_gridview_bg;
import com.ulimate.bureau.suite.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Agecalculatormain extends Activity implements OnClickListener{
    private Button btnStart;
    static final int DATE_START_DIALOG_ID = 0;
    private int startYear=1970;
    private int startMonth=6;
    private int startDay=15;
    private Agecalculatorsecond age = null;
    private TextView currentDate;
    private TextView birthDate;
    private TextView result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_agecalculatormain);
        
        
        
        
        
    	LinearLayout	relative_la_bg = (LinearLayout) findViewById(R.id.LinearLayout_smaart_age);
		 SharedPreferences setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
			 
			 
			 
        age=new Agecalculatorsecond();
        currentDate=(TextView) findViewById(R.id.current_date);
        currentDate.setText("CURRENT DATE(Day/Month/Year)      :"+age.getCurrentDate());
        birthDate=(TextView) findViewById(R.id.birth_date);
        result=(TextView) findViewById(R.id.result_age);
        btnStart=(Button) findViewById(R.id.date_birth);
        btnStart.setOnClickListener(this);
      
    }
   
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_START_DIALOG_ID:
            return new DatePickerDialog(this,
                        mDateSetListener,
                        startYear, startMonth, startDay);
         }
        return null;
     }
   
    private DatePickerDialog.OnDateSetListener mDateSetListener 
    = new DatePickerDialog.OnDateSetListener() {
    	public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
    		     startYear=selectedYear;
    		 	 startMonth=selectedMonth;
    		 	 startDay=selectedDay;
    		 	 age.setDateOfBirth(startYear, startMonth, startDay);
    		   //  birthDate.setText("Date of Birth(DD/MM/YY): "+selectedDay+":"+(startMonth+1)+":"+startYear); 
    		 	birthDate.setText("DATE OF BIRTH(Day/Month/Year)     :"+selectedDay+":"+(startMonth+1)+":"+startYear);
    	         calculateAge();
    	}
    };
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.date_birth:
		showDialog(DATE_START_DIALOG_ID);
			break;
        
		default:
			break;
		}
	}
	private void calculateAge()
	{       
		age.calcualteYear();
		age.calcualteMonth();
	    age.calcualteDay();
	  //	Toast.makeText(getBaseContext(), "click the resulted button"+age.getResult() , Toast.LENGTH_SHORT).show();
	    result.setText("AGE (Day/Month/Year)                      :"+age.getResult());
	}
}
