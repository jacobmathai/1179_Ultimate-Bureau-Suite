package bino.tic;


import com.ulimate.bureau.suite.R;

import model.TicTacToe;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity {

	TicTacToe game = new TicTacToe();
	
	Button bt00, bt01, bt02, bt10, bt11, bt12, bt20, bt21, bt22;
	boolean b00, b01, b02, b10, b11, b12, b20, b21, b22; //to check if the button has already been clicked
	TextView score1, score2, whoseTurn;
	
	Resources res;
	Drawable circle, cross, last, bg;
	
	int x, y = -1;
	static final int dialogWinP1 = 0;
	static final int dialogWinP2 = 1;
	static final int dialogDraw = 2;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.samrt_ticgame);
	    
	    res = getResources();
	    circle = res.getDrawable(R.drawable.circle);
		cross = res.getDrawable(R.drawable.cross);
		last = cross;
		
		score1 = (TextView)findViewById(R.id.score1);
	    score2 = (TextView)findViewById(R.id.score2);
	    whoseTurn = (TextView)findViewById(R.id.whoseTurn);
	    
	}
	
	public void clickHandler(View v){
		bt00 = (Button)findViewById(R.id.bt00);
		bt01 = (Button)findViewById(R.id.bt01);
		bt02 = (Button)findViewById(R.id.bt02);
		bt10 = (Button)findViewById(R.id.bt10);
		bt11 = (Button)findViewById(R.id.bt11);
		bt12 = (Button)findViewById(R.id.bt12);
		bt20 = (Button)findViewById(R.id.bt20);
		bt21 = (Button)findViewById(R.id.bt21);
		bt22 = (Button)findViewById(R.id.bt22);
		
		if (v == bt00){
			if (!b00){
				b00 = true;
				game.play(0, 0);
				toDisplay(bt00);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt01){
			if (!b01){
				b01 = true;
				game.play(0, 1);
				toDisplay(bt01);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt02){
			if (!b02){
				b02 = true;
				game.play(0, 2);
				toDisplay(bt02);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt10){
			if (!b10){
				b10 = true;
				game.play(1, 0);
				toDisplay(bt10);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt11){
			if (!b11){
				b11 = true;
				game.play(1, 1);
				toDisplay(bt11);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt12){
			if (!b12){
				b12 = true;
				game.play(1, 2);
				toDisplay(bt12);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt20){
			if (!b20){
				b20 = true;
				game.play(2, 0);
				toDisplay(bt20);
				displayDialog();
				setWhooseTurn();
			}
		}
			
		if (v == bt21){
			if(!b21){
				b21 = true;
				game.play(2, 1);
				toDisplay(bt21);
				displayDialog();
				setWhooseTurn();
			}
		}
		if (v == bt22){
			if(!b22){
				b22 = true;
				game.play(2, 2);
				toDisplay(bt22);
				displayDialog();
				setWhooseTurn(); 
			}
		}
		updateUI();
	}
	
	private void updateUI() {
		score1.setText("Player 1: " + game.getP1Score());
		score2.setText("Player 2: " + game.getP2Score());
	}

	public void toDisplay(Button b){
		if (last == cross){
			b.setBackgroundDrawable(circle);
			last = circle;
		}	
		else{
			b.setBackgroundDrawable(cross);
			last = cross;
		}
	}
	
	public void setWhooseTurn(){
		whoseTurn.setText(game.displayPlayer());
	}
	
	/*
	public void cpuPlay(){
		Button[][] bt = new Button[3][3];
		bt[0][0] = (Button)findViewById(R.id.bt00);
		bt[0][1] = (Button)findViewById(R.id.bt01);
		bt[0][2] = (Button)findViewById(R.id.bt02);
		bt[1][0] = (Button)findViewById(R.id.bt10);
		bt[1][1] = (Button)findViewById(R.id.bt11);
		bt[1][2] = (Button)findViewById(R.id.bt12);
		bt[2][0] = (Button)findViewById(R.id.bt20);
		bt[2][1] = (Button)findViewById(R.id.bt21);
		bt[2][2] = (Button)findViewById(R.id.bt22);
		
		game.cpuPlay();
		x = game.getC();
		y = game.getD();
		
		toDisplay(bt[0][2]);
		displayDialog();
		setWhooseTurn();
		
	}
	*/
	
	public void displayDialog()	{
		if (game.isHaveWinner()){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(game.gameOverMessage())
			.setCancelable(false)
			.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int id) {
					reset();
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					System.exit(0);
				}
			})
			.show();
		}
	}
	
	public void reset()	{
		bt00 = (Button)findViewById(R.id.bt00);
		bt01 = (Button)findViewById(R.id.bt01);
		bt02 = (Button)findViewById(R.id.bt02);
		bt10 = (Button)findViewById(R.id.bt10);
		bt11 = (Button)findViewById(R.id.bt11);
		bt12 = (Button)findViewById(R.id.bt12);
		bt20 = (Button)findViewById(R.id.bt20);
		bt21 = (Button)findViewById(R.id.bt21);
		bt22 = (Button)findViewById(R.id.bt22);
		
		b00 = false;
		b01 = false;
		b02 = false;
		b10 = false;
		b11 = false;
		b12 = false;
		b20 = false;
		b21 = false;
		b22 = false;
		
		res = getResources();
	    bg = res.getDrawable(R.drawable.bg);		
		bt00.setBackgroundDrawable(bg);
		bt01.setBackgroundDrawable(bg);
		bt02.setBackgroundDrawable(bg);
		bt10.setBackgroundDrawable(bg);
		bt11.setBackgroundDrawable(bg);
		bt12.setBackgroundDrawable(bg);
		bt20.setBackgroundDrawable(bg);
		bt21.setBackgroundDrawable(bg);
		bt22.setBackgroundDrawable(bg);
		
		game.reset();
	}
	
}
