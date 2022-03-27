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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HomeActivity extends Activity {
	
	
	private String A = "";
	private String B = "";
	private String C = "";
	private String D = "";
	private String E = "";
	private String F = "";
	private String G = "";
	private String H = "";
	private String I = "";
	private String J = "";
	private String K = "";
	private String L = "";
	private String M = "";
	private String N = "";
	private String O = "";
	private String P = "";
	private String Q = "";
	private String r = "";
	private String S = "";
	private String T = "";
	private String U = "";
	private String V = "";
	private String W = "";
	private String X = "";
	private String Y = "";
	private String z = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String word = "";
	
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private EditText edittext1;
	private ListView listview1;
	
	private Intent i = new Intent();
	private AlertDialog.Builder show;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		listview1 = (ListView) findViewById(R.id.listview1);
		show = new AlertDialog.Builder(this);
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				ArrayAdapter adapter = (ArrayAdapter)listview1.getAdapter(); adapter.getFilter().filter(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.setClass(getApplicationContext(), DetailActivity.class);
				word = listview1.getItemAtPosition(_position).toString();
				i.putExtra("word", word);
				i.putExtra("detail", map.get(word).toString());
				startActivity(i);
			}
		});
	}
	private void initializeLogic() {
		_word_list();
		SketchwareUtil.getAllKeysFromMap(map, list);
		Collections.sort(list);
		listview1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, list));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
			menu.add("About").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		
		menu.add("ShareApk").setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		
			return true;
	}
	
	@Override 
	public boolean onOptionsItemSelected(final MenuItem item) {
			switch (item.getTitle().toString()) {
					
			case "About":
				
			Intent intent2 = new Intent(HomeActivity.this, AboutActivity.class);
			startActivity(intent2);
			
			return true;
			
			case "ShareApk":
						
			String apk = "";
			String uri = ("com.eth.tech");
			
			try {
				android.content.pm.PackageInfo pi = getPackageManager().getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES);
				
				apk = pi.applicationInfo.publicSourceDir;
			} catch (Exception e) {
				showMessage(e.toString());
			}
			Intent iten = new Intent(Intent.ACTION_SEND);
			iten.setType("*/*");
			iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(apk)));
			
			startActivity(Intent.createChooser(iten, "Ethiopia First "));
			
				return true;
					
			default:
					return super.onOptionsItemSelected(item);
			}
	}
	{
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		edittext1.setText("");
	}
	
	@Override
	public void onBackPressed() {
		show.setIcon(R.drawable.yyy);
		_dialog_title_color(show, "Exit", "FFFC00");
		_dialog_message_color(show, "Do you want to exit ?", "00C300");
		show.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		show.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		show.create().show();
	}
	private void _word_list () {
		A = "{\n\n\"access\" : \"መድረሻ ፣ መበርበር\",\n\n\"accumulator\" : \"ማጠራቀሚያ\",\n\n\"activity\" : \"ክንውን ፣ ድርጊት\",\n\n\"abort\" : \"ማቋረጥ ፣ ማጨናገፍ\",\n\n\"abstraction\" : \"መደበቅ ፣ መሸፈን\",\n\n\"algorithm\" : \"ስልተ-ቀመር ፣ የስልተ-ቀመር ሂደት\",\n\n\"allocate\" : \"መደልደል\",\n\n\"architecture\" : \"መዋቅር\",\n\n\"archive\" : \"መዝገብ\",\n\n\"array\" : \"ሰልፍ ፣ ተርታ\",\n\n\"attribute\" : \"ባህርይ\",\n\n\"auto\" : \"ራስ-ከዋኝ\",\n";
		B = A.concat("\"binary\" : \"ሁለትዮሽ\",\n\n\"bind\" : \"ጥምር\",\n\n\"bit\" : \"ደቂቅ\",\n\n\"blank\" : \"ባዶ ፣ ምንም\",\n\n\"block\" : \"ክፍልፋይ ፣ ይዘት\",\n\n\"buffer\" : \"ቁጥጥር\",\n\n\"bug\" : \"የክንውን ስህተት ፣ ግድፈት\",\n\n\"bus\" : \"መጓጓዣ ፣ ማስተላለፊያ\",\n\n\"busy\" : \"ጭንቅንቅ\",\n\n\"byte\" : \"የወሂብ ክፍል\",\n");
		C = B.concat("\"cache\" : \"መሸጎጫ ፣ ጊዜያዊ መመዝገቢያ\",\n\n\"call\" : \"መጠቀም ፣ ማሰለፍ ፣ ማሳወቅ\",\n\n\"case\" : \"ሁኔታ\",\n\n\"character\" : \"ፊደል\",\n\n\"client\" : \"ተጠቃሚ ፣ ተገልጋይ\",\n\n\"code\" : \"ቀመር ፣ ደንብ ፣ የሚስጥር ፅሑፍ\",\n\n\"class\" : \"ክፍል ፣ ሽንሽን\",\n\n\"command\" : \"ትእዛዝ\",\n\n\"component\" : \"አካላት\",\n\n\"concurrence\" : \"ቅልጥፍና ፣ ሂደት\",\n\n\"configuration\" : \"ማረጋገጫ\",\n\n\"constraint\" : \"ግዴታ ፣ ቁርኝት\",\n\n\"connection\" : \"ግንኙነት\",\n\n\"compute\" : \"ማስላት ፣ ማሰብ\",\n\n\"computer\" : \"ማሰላሸያ\",\n\n\"compiler\" : \"ማቀናጂያ ፣ መገንቢያ ፣ ማጣሪያ\",\n\n\"crash\" : \"ግጭት ፣ ብልሽት\",\n\n\"crop\" : \"መከርከም ፣ መቁረጥ\",\n\n\"cursor\" : \"ጨቋሚ\",\n\n\"cyber\" : \"አለመ-ኮምፒውተር\",\n");
		D = C.concat("\"data\" : \"ወሂብ\",\n\n\"datatype\" : \"የወሂብ አይነት\",\n\n\"database\" : \"የወሂብ ጎታ ፣ የወሂብ መረጃ መጠራቀሚያ\",\n\n\"deadlock\" : \"ውጥረት\",\n\n\"debug\" : \"ግድፈት ማስወገድ\",\n\n\"decoder\" : \"ተርጓሚ\",\n\n\"decrypt\" : \"መፍታት\",\n\n\"default\" : \"ነባር\",\n\n\"define\" : \"ቋሚ ዋጋ\",\n\n\"develop\" : \"ማበልፀግ ፣ ማዘጋጀት ፣ ማሳደግ\",\n\n\"developer\" : \"አበልፃጊ\",\n\n\"device\" : \"መሳሪያ\",\n\n\"design\" : \"ቅርፅ ፣ ጌጥ\",\n\n\"designer\" : \"ቀራጭ\",\n\n\"directory\" : \"ማውጫ\",\n\n\"dispatch\" : \"አፈፃፀም\",\n\n\"display\" : \"አሳይ\",\n\n\"distortion\" : \"ተዛብቶ ፣ መዛባት\",\n\n\"document\" : \"ሰነድ\",\n\n\"driver\" : \"አንቀሳቃሽ\",\n\n\"duplex\" : \"መንታ\",\n");
		E = D.concat("\"edit\" : \"ማስተካከል ፣ አርትኦት\",\n\n\"element\" : \"የግብአት ዝርዝር\",\n\n\"else\" : \"ያለበለዚያ ፣ አልያም\",\n\n\"encode\" : \"መቀየር\",\n\n\"encryption\" : \"ማመስጠር\",\n\n\"entity\" : \"የባህርይ ስብስብ\",\n\n\"entry\" : \"መረጃ ማስገባት\",\n\n\"erase\" : \"መጥረግ ፣ ማፅዳት\",\n\n\"error\" : \"ስህተት\",\n\n\"execute\" : \"መፈፀም\",\n\n\"extend\" : \"መቀጠል ፣ መዘርጋት ፣ ማስፋፋት\",\n\n\"evaluation\" : \"ግምገማ\",\n\n\"event\" : \"ድርጊት\",\n\n\"exception\" : \"የተለየ ፣ልዩነት\",\n\n\"exit\" : \"መዝጋት\",\n\n\"extension\" : \"ቅፅል ፣ ቅጥያ\",\n\n\"exteact\" : \"መለጠጥ ፣ መበተን\",\n");
		F = E.concat("\"failure\" : \"መሳን ፣ ጉድለት ፣ መታወክ\",\n\n\"fault\" : \"ግድፈት\",\n\n\"font\" : \"ቅርፅ\",\n\n\"function\" : \"ሰራተኛ ፣ ተግባር\",\n");
		G = F.concat("\"gate\" : \"መግቢያ\",\n\n\"graphics\" : \"ንድፍ\",\n");
		H = G.concat("\"hardware\" : \"ውጪያዊ ሽፋን ወይም አካል\",\n\n\"header\" :  \"ራስጌ ፣ አናት\",\n\n\"hierarchical\" : \"ተዋረድ ፣ እርከን\",\n");
		I = H.concat("\"id\" : \"መለያ\",\n\n\"import\" : \"መጋዝ ፣ ማከል ፣ ማምጣት\",\n\n\"implement\" : \"ተግባር\",\n\n\"index\" : \"አመልካች\",\n\n\"initialize\" : \"ማስጀመር ፣ ማነሳሳት\",\n\n\"inspection\" : \"ፍተሻ\",\n\n\"interface\" : \"ገፅታ\",\n\n\"interrupt\" : \"መረበሽ ፣ መቋረጥ\",\n\n\"isolation\" : \"ብቸኛ\",\n\n\"iteration\" : \"ድግግሞሽ\",\n");
		L = I.concat("\"loop\" : \"ምልልስ\",\n");
		N = L.concat("\"network\" : \"አውታር ፣ አውታረ መረብ\",\n");
		O = N.concat("\"object\" : \"ቅፅል ስም\",\n");
		P = O.concat("\"package\" : \"ክምችት ፣ ጥቅል\",\n\n\"page\" : \"ገፅ\",\n\n\"pixel\" : \"ቅንጣት ፣ ሽራፊ\",\n\n\"pointer\" : \"አድራሻ ጠቋሚ\",\n\n\"priority\" : \"የበላይ ፣ ቅድሚያ\",\n\n\"port\" : \"መተላለፊያ ፣ መግቢያ\",\n\n\"processing\" : \"በሂደት ላይ ፣ በክንውን ላይ\",\n\n\"program\" : \"ክንውን\",\n\n\"project\" : \"እቅድ ፣ የጥናት ስራ\",\n");
		Q = P.concat("\"queue\" : \"ወረፋ\",\n");
		r = Q.concat("\"run\" : \"መፈተሽ ፣ ማደራጀት\",\n");
		S = r.concat("\"scan\" : \"መመርመር\",\n\n\"screen\" : \"የምስል መስኮት\",\n\n\"server\" : \"አገልጋይ ፣ ምላሽ ሰጭ\",\n\n\"skip\" : \"ማለፍ ፣ መሻገር\",\n\n\"software\" : \"የኮምፒዩተር ስርአተ-አገልግሎት\",\n\n\"source\" : \"ምንጭ ፣ ዋና ፍንጭ\",\n\n\"string\" : \"የፅሑፍ ይዘት\",\n\n\"switch\" : \"መቀየሪያ ፣ ማማረጪያ\",\n\n\"syntax\" : \"የስርአተ-ቀመር ህግ\",\n\n\"system\" : \"ዘዴ ፣ ስርአት\",\n");
		T = S.concat("\"table\" : \"ሰንጠረዥ\",\n\n\"tag\" : \"ምልክት\",\n\n\"task\" : \"ተግባር\",\n\n\"technique\" : \"ስልት ፣ መላ\",\n\n\"toggle\" : \"አዛዋሪ\",\n\n\"type\" : \"መተየብ ፣ መፃፍ\",\n");
		U = T.concat("\"update\" : \"መለወጥ ፣ ማሻሻል ፣ ማደስ\",\n\n\"upload\" : \"መስቀል ፣ መጫን\",\n");
		V = U.concat("\"variable\" : \"ተለዋዋጭ ፣ ጊዚያዊ አድራሻ\",\n\n\"value\" : \"ግምት ፣ ዋጋ\"\n\n}");
		map = new Gson().fromJson(V, new TypeToken<HashMap<String, Object>>(){}.getType());
	}
	
	
	private void _dialog_title_color (final AlertDialog.Builder _dialog, final String _title, final String _color) {
		_dialog.setTitle(Html.fromHtml("<font color=\"#"+_color+"\">"+_title+"</font>"));
	}
	
	
	private void _dialog_message_color (final AlertDialog.Builder _dialog, final String _msg, final String _color) {
		_dialog.setMessage(Html.fromHtml("<font color=\"#"+_color+"\">"+_msg+"</font>"));
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
