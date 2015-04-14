package bino.tic;

import com.ulimate.bureau.suite.R;
import model.TicTacToe;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends Activity {
	
	//private TextView onePlayer;
	private TextView twoPlayer;	
	private TextView quit;
	
	TicTacToe game = new TicTacToe();
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samrt_ticmenu);
	}
	
	public void onClick(View v){
		//onePlayer = (TextView)findViewById(R.id.onePlayer);
		twoPlayer = (TextView)findViewById(R.id.twoPlayer);	
		quit = (TextView)findViewById(R.id.quit);
		
		/*
		if(v == onePlayer){
			startActivity(new Intent(getApplicationContext(), GameActivity.class));
			game.setGameMode(0);
		}
		*/
		
		if(v == twoPlayer){
			startActivity(new Intent(getApplicationContext(), GameActivity.class));
			game.setGameMode(1);
		}
		if(v == quit)
			System.exit(0);
	}
	
}
