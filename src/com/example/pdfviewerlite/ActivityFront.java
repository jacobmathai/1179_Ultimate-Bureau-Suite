package com.example.pdfviewerlite;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import com.artifex.mupdf.MuPDFActivity;
import com.ebin.fileexp.lite.a.Slsect_main_gridview_bg;
import com.ulimate.bureau.suite.R;


import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ActivityFront extends Activity {
	File[] dir; 	
	SharedPreferences setting;
	 List<Item> match_current_result ;
	List<Item> s_fils = new ArrayList<Item>();
	List<Item> s_filsss = new ArrayList<Item>();
	FrameLayout frame_refresh, frame_progress_bar;
	ListView list_view_search_pdf_result;
	 File currentDir ;
		Adapter_saerch_result  are_search_result   ;
	EditText edit_pdf;
	ImageView image_menu_bu, image_home_bu, image_search_button;
	 Asy_search_for_pdf nnn = new Asy_search_for_pdf();
	boolean search_mode = false;
    boolean runner =true;
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_front);
        
		RelativeLayout relative_la_bg;
		relative_la_bg = (RelativeLayout) findViewById(R.id.relative_la_bg111);
	setting = getSharedPreferences("settings", 0); 
		String  bg_colour_main = setting.getString("bg_colour_main", "g_black");          
		Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
			 int n = obb.get_main_linear_layout_bg(bg_colour_main);
			 relative_la_bg.setBackgroundDrawable(getResources().getDrawable(n)); //gradient all effect work
   	 
       frame_refresh = (FrameLayout) findViewById(R.id.frame_refresh);
        frame_progress_bar = (FrameLayout) findViewById(R.id.frame_progress);
        list_view_search_pdf_result = (ListView)findViewById(R.id.listview_pdf_result);
		edit_pdf = (EditText) findViewById(R.id.editText_search_pdf);
        image_menu_bu = (ImageView) findViewById(R.id.imageView_menu);
        image_home_bu = (ImageView) findViewById(R.id.imageView3_home);
        image_search_button = (ImageView) findViewById(R.id.imageView_search);
		
        // Hiding software keyboard after enter
		 InputMethodManager imm = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
		 imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);

		 
		 
	        setting= getSharedPreferences("settings", 0);      
	      	 final SharedPreferences.Editor editor = setting.edit();
	        String curdir = setting.getString("home_location", "/sdcard/");
		 
        currentDir = new File(curdir);     
        //Asy_search_for_pdf nnn = new Asy_search_for_pdf();
        new Asy_search_for_pdf().execute(currentDir);
        
        

        ////////////////////////////////////////////////////////////////////////   search result click
        
        
        
        list_view_search_pdf_result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				// TODO Auto-generated method stub
				
			
				
				
				runner = false;
				String s = String.valueOf(arg2);
		//	Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
				Item o;
				if(search_mode==true){
					 o = match_current_result.get(arg2);
				}else{
			  o = s_fils.get(arg2); ////////////////////////////////////////////////////// 11111111111111111111111111111111111
				}
		
		//	if(o.getImage().equalsIgnoreCase("a_pdf")){  //Starting pdf Viewer
				
				String pdf_path = o.getPath();
				Uri uri = Uri.parse(pdf_path);
				Intent intent = new Intent(ActivityFront.this,MuPDFActivity.class);
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(uri);
				startActivity(intent);
			//}
			
			
			}
		});
        
        
        //////////////////////////////////////////////////////   Search button click action
        
        
        
        image_search_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String  search_item = edit_pdf.getText().toString();
			//	Toast.makeText(getApplicationContext(), search_item, Toast.LENGTH_LONG).show();
				
if(frame_refresh.isShown()){
			         if(search_item.equals("")){
			         Toast.makeText(getApplicationContext(), "Nothing to Search!", Toast.LENGTH_LONG).show();
			         }else{
			        	 List<Item> current_result = s_fils;
			        	  match_current_result = new ArrayList<Item>();
		
			        	 for(Item o_o:current_result){
			        	if(o_o.getName().toUpperCase().contains(search_item.toUpperCase())){
			        		match_current_result.add(o_o);
			
			        	}
			        	 }
			        	 
			        	 if(match_current_result.size()==0)
			        		 match_current_result.add(new Item("Sorry, No match found","", "", "","no"));
			        		 
			        		are_search_result = new Adapter_saerch_result(getApplicationContext(), android.R.layout.simple_list_item_1, match_current_result);
						    			list_view_search_pdf_result.setEmptyView(null);
						    				list_view_search_pdf_result.setAdapter(are_search_result);
						    				search_mode = true;
			         }
			      
			 
			}else{
             	  AlertDialog.Builder addd = new AlertDialog.Builder(ActivityFront.this);
            		//ad.setTitle("ttt");
            		    addd.setMessage("Please wait, to complete current task");

            		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            		      public void onClick(DialogInterface dialog, int arg1) {
            		    			// TODO Auto-generated method stub
            				System.out.println();
            		    		}
            		    	} );
            		    	addd.show();
			}
			}
		});
        
        
        ///////////////////////////////////////////////////  image home button action
        

image_home_bu.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 AlertDialog.Builder ad = new AlertDialog.Builder(ActivityFront.this,AlertDialog.THEME_HOLO_DARK);
         //ad.setTitle("ttt");
        ad.setTitle("Select search location");
        runner=false;
        if(new File("/storage/").exists()){
             dir = new File("/storage/").listFiles();
        }else{
        	 dir = new File("/mnt/").listFiles();
        }
      
        String[] items  = new String[dir.length];
    //    String[] items = {"","","","","","","","","","","","","","","","","","","",""};
        int i=0;
        for(i=0;i<dir.length;i++)
items[i] = dir[i].getName().toString();
   
	

    //final CharSequence[] items = {"2","3","4","5","6","8","10","12"};
        
        ad.setItems(items, new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
             File ff = dir[which];
             currentDir = ff;     
             
 	        setting= getSharedPreferences("settings", 0);      
 	      	 final SharedPreferences.Editor editor = setting.edit();
 	    	editor.putString("home_location", currentDir.toString());   /// Saved for next restart
 	        editor.commit();
             
          // if(!nnn.isCancelled())  nnn.cancel(true);
          
//             new Asy_search_for_pdf().execute(currentDir);
//                     //SharedPreferences setting = getSharedPreferences("grid_s", 0);
Toast.makeText(getApplicationContext(), "Home Directory changed! ,Plz refresh after Loading files",Toast.LENGTH_LONG).show();
                                           }
           });ad.show();
	}
});



image_menu_bu.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		openOptionsMenu();
	}
});

frame_refresh.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
     runner=true;
	    try{  new Asy_search_for_pdf().execute(currentDir); }catch(Exception ds){}
	}
});
        
    }

    
    
    
    
    
    
    
	 
	 
	 
	 
	 
	 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
    
	 @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	 
	 
	 
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    //	super.onBackPressed();
    	if(search_mode==false){
        	this.finish();
        	edit_pdf.setText("");
        }else if(search_mode==true){
    	search_mode=false;
		are_search_result = new Adapter_saerch_result(getApplicationContext(), android.R.layout.simple_list_item_1, s_fils);
		list_view_search_pdf_result.setEmptyView(null);
			list_view_search_pdf_result.setAdapter(are_search_result);
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main1, menu);
        return true;
    }
    
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	switch(item.getItemId()){
	case R.id.action_browse:  runner = false;
		
		                                         Intent in_file_exp = new Intent(this,ActivityFileChooser.class);
                                                startActivity(in_file_exp);
		
		                                           break;
//	case R.id.action_about:  Intent in_about = new Intent("com.example.pdfviewerlite.AboutyActivity");
	                 //                          startActivity(in_about);
		                  
		                                        //   break;
	case R.id.action_exit :
                                                this.finish();
                                                break;
		                                           
		                                           
	
	}

	return super.onOptionsItemSelected(item);
}

class Asy_search_for_pdf extends AsyncTask<File, Item, String> {

	
@Override
public void onPreExecute() {
	// TODO Auto-generated method stub
	super.onPreExecute();
	
	frame_refresh.setVisibility(View.GONE);
	frame_progress_bar.setVisibility(View.VISIBLE);
	
}
	




@Override
	public String doInBackground(File... params) {
		// TODO Auto-generated method stub

	s_filsss = new ArrayList<Item>();

		File f = params[0];
	List<Item>fls = new ArrayList<Item>(); 

	
	
class Read_pdf_in_dir {

	List<Item>fls = new ArrayList<Item>(); 
	Asy_search_for_pdf c;
	
public Read_pdf_in_dir(Asy_search_for_pdf asy_search_for_pdf){
 c= asy_search_for_pdf;
}
	public List<Item> read_pdf(File f){

		if(runner){
		File[]dirs = f.listFiles(); 
		try{
			for(File ff: dirs) {
				
				if(ff.isFile()){
              Date lastModDate = new Date(ff.lastModified()); 
		       DateFormat formater = DateFormat.getDateTimeInstance();
				String date_modify = formater.format(lastModDate);
				
				
				String temp_name = ff.getName();
				String[] it=temp_name.split("\\.");
				String ext=it[it.length-1].toString();
				
				
		if(ext.toUpperCase().equals("PDF")){
					String file_icon_name = "PDF";
					
					Dir_size_Human_Redable newobj = new Dir_size_Human_Redable();
					long f_size= ff.length();
		        	 	String ss = newobj.humanReadableByteCount(f_size, false);         
		        		//fls.add(new Item(ff.getName(),ss, date_modify, ff.getAbsolutePath(),file_icon_name));
		        	 	Item ooo = new Item(ff.getName(),ss, date_modify, ff.getAbsolutePath(),file_icon_name);
		        	 	
		        		//oo.onProgressUpdate(fls);
		        		publishProgress(ooo);

				}
				
		
				}else{            read_pdf(ff);    }
				}
	
		}catch(Exception exc){}
		}
	return fls;	
	}
	
	
}

	if(runner){
Read_pdf_in_dir obj = new Read_pdf_in_dir(this);
List<Item> temp_files = obj.read_pdf(f);

	}

		
		
		return null;
	}
	




@Override
	public void onProgressUpdate(com.example.pdfviewerlite.Item... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);

	s_filsss .add(values[0]);
   s_fils = new ArrayList<Item>();
   s_fils = s_filsss;
	search_mode=false;
			int index = list_view_search_pdf_result.getFirstVisiblePosition();   //Finding position of list View
			are_search_result = new Adapter_saerch_result(getApplicationContext(), android.R.layout.simple_list_item_1, s_fils);
			list_view_search_pdf_result.setEmptyView(null);
				list_view_search_pdf_result.setAdapter(are_search_result);
			try{  	list_view_search_pdf_result.setSelection(index);    }catch(Exception exc){}          // Setting that position back	
	}


	public void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		if(s_fils.isEmpty()){
			Toast.makeText(getApplicationContext(), "No files Found in : "+currentDir, Toast.LENGTH_LONG).show();
			are_search_result = new Adapter_saerch_result(getApplicationContext(), android.R.layout.simple_list_item_1, s_fils);
			list_view_search_pdf_result.setEmptyView(null);
				list_view_search_pdf_result.setAdapter(are_search_result);
		}
		frame_refresh.setVisibility(View.VISIBLE);
		frame_progress_bar.setVisibility(View.GONE);
	}
		
	
	

}


		
}