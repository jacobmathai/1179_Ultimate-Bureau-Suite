package com.eeeeeeeeeeeee.calendar;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;


import com.ulimate.bureau.suite.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Calendar_here_we_go extends Activity{

	
	
	 GregorianCalendar month, itemmonth;// calendar instances.
     CalendarAdapter adapter1;// adapter instance
	 Handler handler;// for grabbing some event values for showing the dot	// marker.
	ArrayList<String> items; // container to store calendar items which	// needs showing the event marker
	ArrayList<String> event;
	LinearLayout rLayout;
	ArrayList<String> date;
	ArrayList<String> desc;
   
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		  setContentView(R.layout.inflate_layout_calendeer);
		getActionBar().setTitle("Calendar");
		
		  
		  
			rLayout = (LinearLayout) findViewById(R.id.text);
			month = (GregorianCalendar) GregorianCalendar.getInstance();
			itemmonth = (GregorianCalendar) month.clone();

			items = new ArrayList<String>();

			adapter1 = new CalendarAdapter(this, month);

			GridView gridview = (GridView) findViewById(R.id.gridview_calendar);
			gridview.setAdapter(adapter1);
			
	//LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
	//gridview.setLayoutParams(lp);


			//lp.height=view_frame_inflate_child_calender.getMeasuredHeight();  //in pixel
//		Display pdis = getWindowManager().getDefaultDisplay();
//		int pwidth = pdis.getWidth();
//		int phieght = pdis.getHeight();

			
			
			
			

			handler = new Handler();
			handler.post(calendarUpdater);

			TextView title = (TextView) findViewById(R.id.title);
			title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

			RelativeLayout previous = (RelativeLayout)findViewById(R.id.previous);

			previous.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setPreviousMonth();
					refreshCalendar();
				}
			});

			RelativeLayout next = (RelativeLayout) findViewById(R.id.next);
			next.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					setNextMonth();
					refreshCalendar();

				}
			});

			gridview.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					// removing the previous view if added
					if (((LinearLayout) rLayout).getChildCount() > 0) {
						((LinearLayout) rLayout).removeAllViews();
					}
					desc = new ArrayList<String>();
					date = new ArrayList<String>();
					((CalendarAdapter) parent.getAdapter()).setSelected(v);
					String selectedGridDate = CalendarAdapter.dayString
							.get(position);
					String[] separatedTime = selectedGridDate.split("-");
					String gridvalueString = separatedTime[2].replaceFirst("^0*",
							"");// taking last part of date. ie; 2 from 2012-12-02.
					int gridvalue = Integer.parseInt(gridvalueString);
					// navigate to next or previous month on clicking offdays.
					if ((gridvalue > 10) && (position < 8)) {
						setPreviousMonth();
						refreshCalendar();
					} else if ((gridvalue < 7) && (position > 28)) {
						setNextMonth();
						refreshCalendar();
					}
					((CalendarAdapter) parent.getAdapter()).setSelected(v);

					for (int i = 0; i < Utility.startDates.size(); i++) {
						if (Utility.startDates.get(i).equals(selectedGridDate)) {
							desc.add(Utility.nameOfEvent.get(i));
						}
					}

					if (desc.size() > 0) {
						for (int i = 0; i < desc.size(); i++) {
							TextView rowTextView = new TextView(Calendar_here_we_go.this);

							// set some properties of rowTextView or something
							rowTextView.setText("Event:" + desc.get(i));
							rowTextView.setTextColor(Color.BLACK);

						//	Toast.makeText(getApplicationContext(), "Event:" + desc.get(i), Toast.LENGTH_LONG).show();
							
							
							int apiLevel = 0;
							try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception exc){}
							
							if(apiLevel<11){
								AlertDialog alertbox = new AlertDialog.Builder(Calendar_here_we_go.this).create();
								alertbox.setTitle("Event");
								alertbox.setMessage(desc.get(i));
								alertbox.setButton("OK", new DialogInterface.OnClickListener() {
									            public void onClick(DialogInterface dialog, int which) {
										            // TODO Auto-generated method stub
									                                                       }
								                                   });
								alertbox.show();
							}else{
						    	  AlertDialog.Builder addd = new AlertDialog.Builder(Calendar_here_we_go.this);
						    		addd.setTitle("Event");
									addd.setMessage(desc.get(i));

				            		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
				            		      public void onClick(DialogInterface dialog, int arg1) {
				            		    			// TODO Auto-generated method stub
				            				System.out.println();
				            		    		}
				            		    	} );
				            		    	addd.show();
								
							}
							
							
							
							
							
							
							
							
							
							
							
							// add the textview to the linearlayout
							rLayout.addView(rowTextView);

						}

					}

					desc = null;

				}

			});
			
			
			
			
		
	}
	

	protected void setNextMonth() {
		if (month.get(GregorianCalendar.MONTH) == month
				.getActualMaximum(GregorianCalendar.MONTH)) {
			month.set((month.get(GregorianCalendar.YEAR) + 1),
					month.getActualMinimum(GregorianCalendar.MONTH), 1);
		} else {
			month.set(GregorianCalendar.MONTH,
					month.get(GregorianCalendar.MONTH) + 1);
		}

	}

	protected void setPreviousMonth() {
		if (month.get(GregorianCalendar.MONTH) == month
				.getActualMinimum(GregorianCalendar.MONTH)) {
			month.set((month.get(GregorianCalendar.YEAR) - 1),
					month.getActualMaximum(GregorianCalendar.MONTH), 1);
		} else {
			month.set(GregorianCalendar.MONTH,
					month.get(GregorianCalendar.MONTH) - 1);
		}

	}

	protected void showToast(String string) {
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

	}

	public void refreshCalendar() {
		TextView title = (TextView) findViewById(R.id.title);

		adapter1.refreshDays();
		adapter1.notifyDataSetChanged();
		handler.post(calendarUpdater); // generate some calendar items

		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
	}

	public Runnable calendarUpdater = new Runnable() {

		@Override
		public void run() {
			items.clear();

			// Print dates of the current week
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
			String itemvalue;
			event = Utility.readCalendarEvent(Calendar_here_we_go.this);
			Log.d("=====Event====", event.toString());
			Log.d("=====Date ARRAY====", Utility.startDates.toString());

			for (int i = 0; i < Utility.startDates.size(); i++) {
				itemvalue = df.format(itemmonth.getTime());
				itemmonth.add(GregorianCalendar.DATE, 1);
				items.add(Utility.startDates.get(i).toString());
			}
			adapter1.setItems(items);
			adapter1.notifyDataSetChanged();
		}
	};
    
    
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
	
}
