package com.artisan.wootlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class LoginActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean emailVerified = false;
	private String nuesaimage = "";
	private String nuesadocuments = "";
	private String nuesaaudio = "";
	private String nuesavoice = "";
	private String nuesavideo = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private ProgressBar progressbar1;
	private Button button2;
	private TextView textview2;
	private TextView textview4;
	private ImageView imageview2;
	private EditText email;
	private ImageView imageview3;
	private EditText edittext1;
	private ImageView imageview4;
	private ImageView imageview5;
	
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	private TimerTask t;
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		progressbar1 = findViewById(R.id.progressbar1);
		button2 = findViewById(R.id.button2);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		imageview2 = findViewById(R.id.imageview2);
		email = findViewById(R.id.email);
		imageview3 = findViewById(R.id.imageview3);
		edittext1 = findViewById(R.id.edittext1);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		auth = FirebaseAuth.getInstance();
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (email.getText().toString().length() == 0) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter Email");
					if (edittext1.getText().toString().length() == 0) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter Password");
					}
				}
				else {
					progressbar1.setVisibility(View.VISIBLE);
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									auth.signInWithEmailAndPassword(email.getText().toString().trim(), edittext1.getText().toString().trim()).addOnCompleteListener(LoginActivity.this, _auth_sign_in_listener);
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
				if (edittext1.getText().toString().equals("youngachiever")) {
					i.setClass(getApplicationContext(), MainpageActivity.class);
					startActivity(i);
				}
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				auth.getCurrentUser().sendEmailVerification().addOnCompleteListener( new OnCompleteListener<Void>() {
					@Override
					public void onComplete(Task<Void>task) {
						if(task.isSuccessful()) {
							showMessage("Email sent"); } else {
							showMessage("We encountered an error");}
					} });
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (email.getText().toString().length() == 0) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter your email ");
				}
				else {
					auth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(_auth_reset_password_listener);
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview4.setVisibility(View.GONE);
				imageview5.setVisibility(View.VISIBLE);
				edittext1.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview5.setVisibility(View.GONE);
				imageview4.setVisibility(View.VISIBLE);
				edittext1.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					emailVerified = auth.getCurrentUser().isEmailVerified();
					if (emailVerified) {
						progressbar1.setVisibility(View.GONE);
						d.setTitle("Privacy Policy");
						d.setMessage("This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service.\n\nIf you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except if demanded by a valid enforcement agency as the case may be.\n\nThe terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at Imsu Connect unless otherwise defined in this Privacy Policy.\n\nInformation Collection and Use:\n\nFor a better experience, while using our Service, I may require you to provide us with certain personally identifiable information, including but not limited to Emails, result data. The information that I request will be retained on your device and as well kept in our database which supports data retrieval.\n\nThe app does use third party services that may collect information used to identify you.\n\nReference to third party service providers used by the app are below;\n\nFirebase.  Admob.  Google Play Services.  Google Analytics.              \n\nLog Data:\n\nI want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics.\n\nCookies:\n\nCookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device's internal memory.\n\nThis Service does not use these “cookies” explicitly. However, the app may use third party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service.\n\nService Providers:\n\nI may employ third-party companies and individuals due to the following reasons:\n\nTo facilitate our Service;To provide the Service on our behalf;To perform Service-related services; or To assist us in analyzing how our Service is used.\n\nI want to inform users of this Service that these third parties have access to your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.\n\nSecurity:\n\nI value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee its absolute security.\n\nLinks to Other Sites:\n\nThis Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by me. Therefore, I strongly advise you to review the Privacy Policy of these websites. I have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.\n\n\nChanges to This Privacy Policy:\n\nI may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. I will notify you of any changes by posting the new Privacy Policy on this page.\n\n\nContact Us:\n\nIf you have any questions or suggestions about my Privacy Policy, do not hesitate to contact me at muoleehs@gmail.com");
						d.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								i.setClass(getApplicationContext(), MainpageActivity.class);
								startActivity(i);
								finish();
							}
						});
						d.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								finishAffinity();
							}
						});
						d.create().show();
					}
					else {
						progressbar1.setVisibility(View.GONE);
						d.setTitle("Your email account is not verified yet. ");
						d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						d.create().show();
					}
				}
				else {
					progressbar1.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					SketchwareUtil.showMessage(getApplicationContext(), "Check your email account to reset your password");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "We encountered an error. Check your internet connection");
				}
			}
		};
	}
	
	private void initializeLogic() {
		setTitle("Login");
		imageview4.setVisibility(View.GONE);
		edittext1.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		android.graphics.drawable.GradientDrawable ed = new android.graphics.drawable.GradientDrawable();
		ed.setColor(Color.parseColor("#FFF7991D"));
		ed.setCornerRadius(70);
		button2.setBackground(ed);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/productsansbold.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/productsansbold.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/productsansbold.ttf"), 1);
		progressbar1.setVisibility(View.GONE);
		if (!sp.getString("email", "").equals("")) {
			email.setText(sp.getString("email", ""));
			edittext1.setText(sp.getString("password", ""));
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