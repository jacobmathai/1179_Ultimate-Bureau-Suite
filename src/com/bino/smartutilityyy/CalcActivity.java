package com.bino.smartutilityyy;

import com.ulimate.bureau.suite.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CalcActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smart_calculatoronly);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculatoronly, menu);
		return true;
	}

}
