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
import android.widget.TextView;

public class AboutActivity extends Activity {
	
	
	private double shapeww = 0;
	
	private LinearLayout linear1;
	private LinearLayout animat;
	private ImageView imageview1;
	private TextView textview;
	private TextView textview1;
	private TextView textview9;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview10;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		animat = (LinearLayout) findViewById(R.id.animat);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview = (TextView) findViewById(R.id.textview);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
	}
	private void initializeLogic() {
		_border(animat, "#FF69B4", "15");
		_edge(animat);
		
		//Create variable versionName and versionCode
		String versionName = "null";
		int versionCode = -1;
		try {
			android.content.pm.PackageInfo packageInfo = AboutActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0);
			versionName = packageInfo.versionName;
			versionCode = packageInfo.versionCode;
		} catch (android.content.pm.PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		//textview set text
		TextView textViewVersionInfo = (TextView) findViewById(R.id.textview1);
		textViewVersionInfo.setText(String.format("Version: %s", versionName, versionCode));
		/*HELP
No help for this code...
*/
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _border (final View _v, final String _color, final String _strokew) {
		shapeww = Double.parseDouble(_strokew);
		float shapew = (float) shapeww;
		
		android.graphics.drawable.ShapeDrawable shape = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.RectShape());
		shape.getPaint().setColor(Color.parseColor(_color));
		shape.getPaint().setStyle(Paint.Style.STROKE);
		shape.getPaint().setStrokeWidth(shapew);
		_v.setBackground(shape);
	}
	
	
	private void _edge (final View _view) {
		Animation makeInAnimation = AnimationUtils.makeInAnimation(getBaseContext(), false);
		makeInAnimation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) { }
			
			@Override
			public void onAnimationRepeat(Animation animation) { }
			
			@Override
			public void onAnimationStart(Animation animation) {
				_view.setVisibility(View.VISIBLE);
			}
		});
		
		Animation makeOutAnimation = AnimationUtils.makeOutAnimation(getBaseContext(), true);
		makeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				_view.setVisibility(View.INVISIBLE);
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) { }
			
			@Override
			public void onAnimationStart(Animation animation) { }
		});
		
		if (_view.isShown()) {
			_view.startAnimation(makeOutAnimation);
		}
		
		if (!_view.isShown()) {
			_view.startAnimation(makeInAnimation);
		}
		
		ScaleAnimation animview = new ScaleAnimation(0,1,0,1);
		animview.setFillBefore(true);
		animview.setFillAfter(true);
		animview.setFillEnabled(true);
		animview.setDuration(1000);
		animview.setInterpolator(new OvershootInterpolator());
		_view.startAnimation(animview);
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
