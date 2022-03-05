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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.content.ClipData;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class RegisterActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String imagepath = "";
	private String imagename = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String imageString = "";
	private boolean emailVerified = false;
	private String ID = "";
	private HashMap<String, Object> maps = new HashMap<>();
	private String str = "";
	private String imsuimage = "";
	private String imsudocuments = "";
	private String imsuvideo = "";
	private String imsuvoice = "";
	private String imsuaudio = "";
	private String pushkey = "";
	private String nuesaimage = "";
	private String nuesavideo = "";
	private String nuesaaudio = "";
	private String nuesadocuments = "";
	private String nuesavoice = "";
	
	private ArrayList<String> list = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear9;
	private TextView textview1;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear10;
	private LinearLayout linear8;
	private RadioButton radiobutton1;
	private LinearLayout linear11;
	private Button button1;
	private ProgressBar progressbar1;
	private TextView textview2;
	private Button button2;
	private ImageView imageview2;
	private ImageView imageview3;
	private EditText username;
	private ImageView imageview4;
	private EditText email;
	private ImageView imageview8;
	private EditText city;
	private ImageView imageview5;
	private EditText edittext1;
	private ImageView imageview7;
	private ImageView imageview6;
	private ImageView imageview9;
	private EditText craft;
	
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference avatar = _firebase_storage.getReference("avatar");
	private OnCompleteListener<Uri> _avatar_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _avatar_download_success_listener;
	private OnSuccessListener _avatar_delete_success_listener;
	private OnProgressListener _avatar_upload_progress_listener;
	private OnProgressListener _avatar_download_progress_listener;
	private OnFailureListener _avatar_failure_listener;
	
	private DatabaseReference userdata = _firebase.getReference("userdata");
	private ChildEventListener _userdata_child_listener;
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
	
	private SharedPreferences sp;
	private Intent intent = new Intent();
	private Intent i = new Intent();
	private Calendar cal = Calendar.getInstance();
	private SharedPreferences A;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.register);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear9 = findViewById(R.id.linear9);
		textview1 = findViewById(R.id.textview1);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear10 = findViewById(R.id.linear10);
		linear8 = findViewById(R.id.linear8);
		radiobutton1 = findViewById(R.id.radiobutton1);
		linear11 = findViewById(R.id.linear11);
		button1 = findViewById(R.id.button1);
		progressbar1 = findViewById(R.id.progressbar1);
		textview2 = findViewById(R.id.textview2);
		button2 = findViewById(R.id.button2);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		username = findViewById(R.id.username);
		imageview4 = findViewById(R.id.imageview4);
		email = findViewById(R.id.email);
		imageview8 = findViewById(R.id.imageview8);
		city = findViewById(R.id.city);
		imageview5 = findViewById(R.id.imageview5);
		edittext1 = findViewById(R.id.edittext1);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		imageview9 = findViewById(R.id.imageview9);
		craft = findViewById(R.id.craft);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		auth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		A = getSharedPreferences("A", Activity.MODE_PRIVATE);
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear11.setVisibility(View.VISIBLE);
			}
		});
		
		radiobutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (radiobutton1.isChecked()) {
					linear11.setVisibility(View.VISIBLE);
				}
				else {
					linear11.setVisibility(View.GONE);
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (username.getText().toString().length() < 3) {
					SketchwareUtil.showMessage(getApplicationContext(), "This allows a minimum of three characters");
					if (edittext1.getText().toString().length() < 5) {
						SketchwareUtil.showMessage(getApplicationContext(), "Password should be a minimum of 7 characters");
					}
					if (!(city.getText().toString().length() == 11)) {
						SketchwareUtil.showMessage(getApplicationContext(), "Invalid phone number");
					}
				}
				else {
					progressbar1.setVisibility(View.VISIBLE);
					auth.createUserWithEmailAndPassword(email.getText().toString(), edittext1.getText().toString()).addOnCompleteListener(RegisterActivity.this, _auth_create_user_listener);
				}
				sp.edit().putString("username", username.getText().toString()).commit();
				sp.edit().putString("email", email.getText().toString()).commit();
				if (imagepath.equals("")) {
					
				}
				else {
					java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
					Bitmap bm = ((android.graphics.drawable.BitmapDrawable) imageview2.getDrawable()).getBitmap();
					bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
					byte[] imageBytes = baos.toByteArray();
					String imageString = android.util.Base64.encodeToString(imageBytes, android.util.Base64.DEFAULT);
					sp.edit().putString("avatar", imageString).commit();
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(intent);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		email.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		city.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview7.setVisibility(View.GONE);
				imageview6.setVisibility(View.VISIBLE);
				edittext1.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview6.setVisibility(View.GONE);
				imageview7.setVisibility(View.VISIBLE);
				edittext1.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
			}
		});
		
		_avatar_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_avatar_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_avatar_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				try {
					pushkey = userdata.push().getKey();
					cal = Calendar.getInstance();
					maps = new HashMap<>();
					maps.put("username", username.getText().toString().trim());
					maps.put("entrydate", new SimpleDateFormat("EEEE dd/MMM/yyyy hh:mm a").format(cal.getTime()));
					maps.put("push key", pushkey);
					maps.put("email", email.getText().toString().trim());
					maps.put("password", edittext1.getText().toString().trim());
					maps.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					maps.put("pic", _downloadUrl);
					maps.put("pn", sp.getString("pn", ""));
					maps.put("city", city.getText().toString().trim());
					maps.put("craft", craft.getText().toString().trim());
					maps.put("ID", ID);
					A.edit().putString("pushkey", pushkey).commit();
					sp.edit().putString("r_name", username.getText().toString().trim()).commit();
					sp.edit().putString("email", email.getText().toString().trim()).commit();
					sp.edit().putString("city", city.getText().toString().trim()).commit();
					sp.edit().putString("craft", craft.getText().toString().trim()).commit();
					userdata.child(sp.getString("myuid", "")).updateChildren(maps);
					maps.clear();
					sp.edit().putString("avatar", _downloadUrl).commit();
					i.putExtra("user", "");
				} catch (Exception e) {
					 
				}
			}
		};
		
		_avatar_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_avatar_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_avatar_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_userdata_child_listener = new ChildEventListener() {
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
		userdata.addChildEventListener(_userdata_child_listener);
		
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
				if (_success) {
					avatar.child(imagename).putFile(Uri.fromFile(new File(imagepath))).addOnFailureListener(_avatar_failure_listener).addOnProgressListener(_avatar_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return avatar.child(imagename).getDownloadUrl();
						}}).addOnCompleteListener(_avatar_upload_success_listener);
					auth.getCurrentUser().sendEmailVerification().addOnCompleteListener( new OnCompleteListener<Void>() {
						@Override
						public void onComplete(Task<Void>task) {
							if(task.isSuccessful()) {
								showMessage("Email sent"); } else {
								showMessage("We encountered an error");}
						} });
					SketchwareUtil.showMessage(getApplicationContext(), "A verification link has been sent to your email. Please, click the link to verify your account");
					sp.edit().putString("email", email.getText().toString()).commit();
					sp.edit().putString("password", edittext1.getText().toString()).commit();
					sp.edit().putString("pn", sp.getString("pn", "")).commit();
					progressbar1.setVisibility(View.GONE);
					intent.setClass(getApplicationContext(), LoginActivity.class);
					startActivity(intent);
				}
				else {
					progressbar1.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		linear11.setVisibility(View.GONE);
		setTitle("Register");
		imageview7.setVisibility(View.GONE);
		edittext1.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		android.graphics.drawable.GradientDrawable ed = new android.graphics.drawable.GradientDrawable();
		ed.setColor(Color.parseColor("#FFF7991D"));
		ed.setCornerRadius(70);
		button1.setBackground(ed);
		android.graphics.drawable.GradientDrawable hd = new android.graphics.drawable.GradientDrawable();
		hd.setColor(Color.parseColor("#FFF7991D"));
		hd.setCornerRadius(70);
		button2.setBackground(hd);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/productsansbold.ttf"), 1);
		progressbar1.setVisibility(View.GONE);
		ID = android.os.Build.ID;
		ID = ID.replace(".", "");
		sp.edit().putString("ID", ID).commit();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				FileUtil.resizeBitmapFileToCircle(_filePath.get((int)(0)), FileUtil.getPublicDir(Environment.DIRECTORY_PICTURES).concat("/".concat("saved")));
				imagepath = FileUtil.getPublicDir(Environment.DIRECTORY_PICTURES).concat("/".concat("saved"));
				imagename = Uri.parse(imagepath).getLastPathSegment();
				imageview2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(imagepath, 1024, 1024));
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _round_corner(final View _view, final double _value, final String _color) {
		android.graphics.drawable.GradientDrawable round_corner = new android.graphics.drawable.GradientDrawable();
		round_corner.setColor(Color.parseColor("#"+_color));
		round_corner.setCornerRadius(new Float(_value));
		_view.setBackground(round_corner);
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