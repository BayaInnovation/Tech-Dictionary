package com.eth.tech;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview1;
	
	private Intent i = new Intent();
	private SharedPreferences once;
	private TimerTask time;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		once = getSharedPreferences("once", Activity.MODE_PRIVATE);
	}
	private void initializeLogic() {
		_round(linear2, 20, "#00C300");
		if (once.getString("port", "").equals("")) {
			time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							i.setClass(getApplicationContext(), HomeActivity.class);
							startActivity(i);
							once.edit().putString("port", "free").commit();
							finish();
						}
					});
				}
			};
			_timer.schedule(time, (int)(4000));
		}
		else {
			i.setClass(getApplicationContext(), HomeActivity.class);
			startActivity(i);
			finish();
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _round (final View _view, final double _num, final String _color) {
		try {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			
			
			float f = (float) _num;
			
			
			gd.setCornerRadius(f);
			_view.setBackground(gd);
			
		} catch(Exception e){ Log.e("Error: ", e.toString()); String error_code = e.toString();
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
							builder.setTitle("Error")
								.setMessage(error_code)
								.setCancelable(false)
								.setNegativeButton("ОК", new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog, int id) {
												
										}
								});
							AlertDialog alert = builder.create();
							alert.show();
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
