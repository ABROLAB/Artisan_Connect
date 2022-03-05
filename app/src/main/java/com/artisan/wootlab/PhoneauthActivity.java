package com.artisan.wootlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class PhoneauthActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String phone = "";
	private String code = "";
	private String codeSent = "";
	private HashMap<String, Object> user = new HashMap<>();
	private HashMap<String, Object> maps = new HashMap<>();
	private double n = 0;
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout regotp;
	private LinearLayout verifyotp;
	private LinearLayout linearsend;
	private LinearLayout linearverify;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private ImageView imageview2;
	private TextView textview2;
	private EditText edittext1;
	private TextView textview4;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear14;
	private EditText edittext2;
	private TextView textview3;
	private TextView res;
	private TextView time;
	private TextView textview7;
	
	private FirebaseAuth fauth;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private DatabaseReference authdata = _firebase.getReference("authdata");
	private ChildEventListener _authdata_child_listener;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.phoneauth);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		regotp = findViewById(R.id.regotp);
		verifyotp = findViewById(R.id.verifyotp);
		linearsend = findViewById(R.id.linearsend);
		linearverify = findViewById(R.id.linearverify);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		edittext1 = findViewById(R.id.edittext1);
		textview4 = findViewById(R.id.textview4);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear14 = findViewById(R.id.linear14);
		edittext2 = findViewById(R.id.edittext2);
		textview3 = findViewById(R.id.textview3);
		res = findViewById(R.id.res);
		time = findViewById(R.id.time);
		textview7 = findViewById(R.id.textview7);
		fauth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				n = 120;
				if (!edittext1.getText().toString().trim().equals("")) {
					_sendotp();
					linearsend.setVisibility(View.GONE);
					linearverify.setVisibility(View.VISIBLE);
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									n--;
									time.setText(String.valueOf((long)(n)));
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(t, (int)(0), (int)(1000));
					if (n == 0) {
						res.setEnabled(true);
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Please, enter your phone number");
				}
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Verifying...");
				_verify();
			}
		});
		
		res.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (res.isEnabled()) {
					_sendotp();
					res.setEnabled(false);
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									n--;
									time.setText(String.valueOf((long)(n)));
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(t, (int)(0), (int)(1000));
					if (n == 0) {
						res.setEnabled(true);
						res.setAlpha((float)(1.0d));
					}
				}
			}
		});
		
		_authdata_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		authdata.addChildEventListener(_authdata_child_listener);
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					maps = new HashMap<>();
					maps.put("pn", phone);
					maps.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					authdata.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(maps);
					maps.clear();
					sp.edit().putString("pn", phone).commit();
					sp.edit().putString("myuid", FirebaseAuth.getInstance().getCurrentUser().getUid()).commit();
					i.setClass(getApplicationContext(), MainpageActivity.class);
					startActivity(i);
				}
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		android.graphics.drawable.GradientDrawable ed = new android.graphics.drawable.GradientDrawable();
		ed.setColor(Color.parseColor("#FFF7991D"));
		ed.setCornerRadius(50);
		linear13.setBackground(ed);
		linear11.setBackground(ed);
		res.setEnabled(false);
	}
	
	public void _sendotp() {
		phone = "+234".concat(edittext1.getText().toString());
		//code for send otp on user mobile
		
		com.google.firebase.auth.PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 60, java.util.concurrent.TimeUnit.SECONDS, this, mCallbacks);
	}
	com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
		 @Override
		public void onVerificationCompleted(com.google.firebase.auth.PhoneAuthCredential phoneAuthCredential) {
				showMessage("Code has been sent to your Mobile !");
		}
		 @Override
		public void onVerificationFailed(com.google.firebase.FirebaseException e) {
				showMessage("Your Phone number is invalid");
		}
		 @Override
		public void onCodeSent(String s, com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken forceResendingToken) {
				super.onCodeSent(s, forceResendingToken);
				codeSent = s;
		}
	};
	{
		//powered by ashishtechnozone
		
	}
	
	
	public void _verify() {
		code = edittext2.getText().toString();
		//code for verify otp
		
		com.google.firebase.auth.PhoneAuthCredential credential = com.google.firebase.auth.PhoneAuthProvider.getCredential(codeSent, code);
		signInWithPhoneAuthCredential(credential);
	}
	private void signInWithPhoneAuthCredential(com.google.firebase.auth.PhoneAuthCredential credential) {
		fauth.signInWithCredential(credential) .addOnCompleteListener(this, _fauth_sign_in_listener);
	}
	{
		//powered by ashishtechnozone
		
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
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}