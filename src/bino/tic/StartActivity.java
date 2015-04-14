package bino.tic;

import com.ulimate.bureau.suite.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends Activity implements Runnable {
    
	switcher s;
	Thread th;
	Handler handler = new Handler();
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samrt_ticmain);
        s = new switcher(this, handler);
        (th = new Thread(s)).start();
    }
    
    /**
     * This class implements the timer
     */
    public class switcher implements Runnable	{
    	private boolean _running = true;
    	private Handler _handler;
    	private Runnable _runnable;
    	
    	public switcher(Runnable runnable, Handler handler){
    		_runnable = runnable;
    		_handler = handler;
    	}
    	
    	public void setRunning(boolean running)	{
    		_running = running;
    	}
    	
    	public void run()	{
    		while(_running)	{
    			try {
    				Thread.sleep(5000);
    			}
    			catch (InterruptedException ex){
    			}
    			if (_running)	{
    				_handler.post(_runnable);
    				_running = false;
    			}
    				
    				
    		}
    	}
    }
    
    public void run()	{
    	Intent i = new Intent(getApplicationContext(), MenuActivity.class);		
		startActivity(i);
    }
    
}