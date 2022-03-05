package com.artisan.wootlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.provider.MediaStore;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import android.content.ClipData;
import android.media.MediaPlayer;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.speech.RecognitionListener;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.os.Vibrator;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import android.view.View;
import com.google.gson.Gson;
import com.bumptech.glide.Glide;
import com.google.gson.reflect.TypeToken;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainpageActivity extends AppCompatActivity {
	
	public final int REQ_CD_CAMERA = 101;
	public final int REQ_CD_FP = 102;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private double linear_num = 0;
	private String url = "";
	private double n = 0;
	private double num = 0;
	private HashMap<String, Object> onlmap = new HashMap<>();
	private double img = 0;
	private HashMap<String, Object> mm = new HashMap<>();
	private String imgsent = "";
	private String imgname = "";
	private double chatroom_var = 0;
	private String filesize = "";
	private String file = "";
	private String file_path = "";
	private String listmap_path = "";
	private String FilePath = "";
	private HashMap<String, Object> voicemap = new HashMap<>();
	private String URL = "";
	private double gameweb = 0;
	private String name = "";
	private String see = "";
	private boolean isPlaying = false;
	private double pos = 0;
	private String url_string = "";
	private HashMap<String, Object> maps = new HashMap<>();
	private String pic = "";
	private String object_clicked = "";
	private String text = "";
	private double limit = 0;
	private String chr = "";
	private double number = 0;
	private String Timer = "";
	private String imsuimage = "";
	private String imsuvoice = "";
	private String imsudocuments = "";
	private String imsuvideo = "";
	private String imsuaudio = "";
	private double get_dat = 0;
	private String SetPassword = "";
	private String image = "";
	private String video = "";
	private String nuesaimage = "";
	private String nuesaaudio = "";
	private String nuesavideo = "";
	private String nuesadocuments = "";
	private String nuesavoice = "";
	private boolean emailVerified = false;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> onlinemap = new ArrayList<>();
	private ArrayList<String> sent = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lop = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> chatmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> users = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> voicelistmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> dat = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout btm;
	private LinearLayout linear_news;
	private LinearLayout linear_reportinc;
	private LinearLayout linear2;
	private ListView listview1;
	private ImageView imageview1;
	private LinearLayout linear3;
	private TextView textview1;
	private ListView listview4;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear8;
	private LinearLayout _drawer_linear16;
	private ImageView _drawer_imageview2;
	private LinearLayout _drawer_linear20;
	private LinearLayout _drawer_linear22;
	private LinearLayout _drawer_linear24;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview16;
	private TextView _drawer_textview14;
	private ImageView _drawer_imageview17;
	private TextView _drawer_textview15;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private Calendar c = Calendar.getInstance();
	private AlertDialog.Builder d;
	private DatabaseReference photo = _firebase.getReference("photo");
	private ChildEventListener _photo_child_listener;
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
	
	private Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_camera;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder di;
	private MediaPlayer mp;
	private SpeechRecognizer Recording;
	private TimerTask t;
	private Intent gpi = new Intent();
	private Intent uci = new Intent();
	private Vibrator v;
	private Calendar c1 = Calendar.getInstance();
	private SharedPreferences A;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private StorageReference avatar = _firebase_storage.getReference("avatar");
	private OnCompleteListener<Uri> _avatar_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _avatar_download_success_listener;
	private OnSuccessListener _avatar_delete_success_listener;
	private OnProgressListener _avatar_upload_progress_listener;
	private OnProgressListener _avatar_download_progress_listener;
	private OnFailureListener _avatar_failure_listener;
	
	private TimerTask timer;
	private SharedPreferences shared;
	private DatabaseReference userdata = _firebase.getReference("userdata");
	private ChildEventListener _userdata_child_listener;
	private Intent page = new Intent();
	private StorageReference pho = _firebase_storage.getReference("pho");
	private OnCompleteListener<Uri> _pho_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _pho_download_success_listener;
	private OnSuccessListener _pho_delete_success_listener;
	private OnProgressListener _pho_upload_progress_listener;
	private OnProgressListener _pho_download_progress_listener;
	private OnFailureListener _pho_failure_listener;
	
	private Intent gallery = new Intent();
	private DatabaseReference advertimages = _firebase.getReference("advert");
	private ChildEventListener _advertimages_child_listener;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.mainpage);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
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
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainpageActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		btm = findViewById(R.id.btm);
		linear_news = findViewById(R.id.linear_news);
		linear_reportinc = findViewById(R.id.linear_reportinc);
		linear2 = findViewById(R.id.linear2);
		listview1 = findViewById(R.id.listview1);
		imageview1 = findViewById(R.id.imageview1);
		linear3 = findViewById(R.id.linear3);
		textview1 = findViewById(R.id.textview1);
		listview4 = findViewById(R.id.listview4);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear7 = _nav_view.findViewById(R.id.linear7);
		_drawer_linear8 = _nav_view.findViewById(R.id.linear8);
		_drawer_linear16 = _nav_view.findViewById(R.id.linear16);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_linear20 = _nav_view.findViewById(R.id.linear20);
		_drawer_linear22 = _nav_view.findViewById(R.id.linear22);
		_drawer_linear24 = _nav_view.findViewById(R.id.linear24);
		_drawer_imageview14 = _nav_view.findViewById(R.id.imageview14);
		_drawer_textview12 = _nav_view.findViewById(R.id.textview12);
		_drawer_imageview16 = _nav_view.findViewById(R.id.imageview16);
		_drawer_textview14 = _nav_view.findViewById(R.id.textview14);
		_drawer_imageview17 = _nav_view.findViewById(R.id.imageview17);
		_drawer_textview15 = _nav_view.findViewById(R.id.textview15);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		_file_camera = FileUtil.createNewPictureFile(getApplicationContext());
		Uri _uri_camera;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			_uri_camera = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", _file_camera);
		} else {
			_uri_camera = Uri.fromFile(_file_camera);
		}
		camera.putExtra(MediaStore.EXTRA_OUTPUT, _uri_camera);
		camera.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dialog = new AlertDialog.Builder(this);
		di = new AlertDialog.Builder(this);
		Recording = SpeechRecognizer.createSpeechRecognizer(this);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		A = getSharedPreferences("A", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);
		shared = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		listview1.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView abs, int _scrollState) {
				
			}
			
			@Override
			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {
				
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), InfoActivity.class);
				startActivity(i);
			}
		});
		
		_photo_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				photo.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						list.clear();
						list.add(_childKey);
						_Subtitle("Productivity and Efficiency");
						Collections.reverse(map);
						listview1.setAdapter(new Listview1Adapter(map));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						sp.edit().putString("photodata", new Gson().toJson(map)).commit();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				photo.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						_Subtitle("Productivity and Efficiency");
						Collections.reverse(map);
						listview1.setAdapter(new Listview1Adapter(map));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				photo.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						_Subtitle("Productivity and Efficiency");
						Collections.reverse(map);
						listview1.setAdapter(new Listview1Adapter(map));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		photo.addChildEventListener(_photo_child_listener);
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
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
				mm = new HashMap<>();
				mm.put("username", sp.getString("username", ""));
				mm.put("messages", "".trim());
				mm.put("image", _downloadUrl);
				mm.put("user_uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				c = Calendar.getInstance();
				mm.put("time", new SimpleDateFormat("E dd MMM yyyy hh:mm a").format(c.getTime()));
				
				mm.clear();
				img = 0;
				
				if (_downloadUrl.contains(".mp4") || _downloadUrl.contains(".3gp")) {
					file = _downloadUrl;
					i.putExtra("vidimg", file);
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
				maps.put("status", "online");
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
		
		_pho_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_pho_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_pho_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_pho_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_pho_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_pho_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_advertimages_child_listener = new ChildEventListener() {
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
		advertimages.addChildEventListener(_advertimages_child_listener);
		
		_drawer_linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shareApplication();
			}
		});
		
		_drawer_linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), DevActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), StudentcomplaintsActivity.class);
				startActivity(i);
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
		
		com.google.android.material.bottomnavigation.BottomNavigationView btmn= new com.google.android.material.bottomnavigation.BottomNavigationView(MainpageActivity.this);
		btmn.setLayoutParams(new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		
		
		
		btm.addView(btmn);
		btm.setElevation(16);
		btm.setBackgroundColor(0xFFFFFFFF);
		btmn.setBackgroundColor(0xFFFFFFFF);
		
		Menu menu = btmn.getMenu();
		
		final int A = 0;
		final int B = 1;
		final int C = 2;
		final int D = 3;
		
		    
		
		menu.add(Menu.NONE, B, Menu.NONE, "News").setIcon(R.drawable.ic2);
		
		menu.add(Menu.NONE, C, Menu.NONE, "Search").setIcon(R.drawable.ic4);
		
		menu.add(Menu.NONE, D, Menu.NONE, "Chat").setIcon(R.drawable.ic3);
		btmn.setOnNavigationItemSelectedListener(new  com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener() {  @Override public boolean onNavigationItemSelected(final MenuItem item) {
				switch (item.getItemId()){ 
					
					case B:
					
					linear_news.setVisibility(View.VISIBLE);
					
					break; 
					case C:
					
					i.setClass(getApplicationContext(), AllusersActivity.class);
					startActivity(i);
					 
					break;
					case D:
					
					emailVerified = auth.getCurrentUser().isEmailVerified();
					if (emailVerified) {
							intent.setClass(getApplicationContext(), GeneralchatroomActivity.class);
							startActivity(intent);
							finish();
					}
					else {
							intent.setClass(getApplicationContext(), RegisterActivity.class);
							startActivity(intent);
					}
					 
					break; 
					
				} return true; } });
		android.graphics.drawable.GradientDrawable ed = new android.graphics.drawable.GradientDrawable();
		ed.setColor(Color.parseColor("#FFFFFF"));
		ed.setCornerRadius(50);
		linear3.setBackground(ed);
		photo.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				map = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						map.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				Collections.reverse(map);
				listview1.setAdapter(new Listview1Adapter(map));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				if (map.size() == 0) {
					_set_Notification("Artisan Connect", "No Information");
				}
				_Subtitle("Productivity and Efficiency");
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_CAMERA:
			if (_resultCode == Activity.RESULT_OK) {
				 String _filePath = _file_camera.getAbsolutePath();
				
				imgsent = _filePath;
				imgname = Uri.parse(_filePath).getLastPathSegment();
				
				
				img = 1;
				
				
				img = 1;
			}
			else {
				
			}
			break;
			
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
				img = 1;
				imgsent = _filePath.get((int)(0));
				imgname = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				
				
				
				avatar.child(imgname).putFile(Uri.fromFile(new File(imgsent))).addOnFailureListener(_avatar_failure_listener).addOnProgressListener(_avatar_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return avatar.child(imgname).getDownloadUrl();
					}}).addOnCompleteListener(_avatar_upload_success_listener);
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
		d.setTitle("Exit");
		d.setMessage("Are you sure?");
		d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		d.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		d.create().show();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		net.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "A", _net_request_listener);
		
		StrictMode.VmPolicy.Builder builder = 
		  new StrictMode.VmPolicy.Builder(); 
		  StrictMode.setVmPolicy(builder.build());
		  if(Build.VERSION.SDK_INT>=24){ 
			      try{
				    java.lang.reflect.Method m = 
				          StrictMode.class.getMethod(
				    "disableDeathOnFileUriExposure"); 
				          m.invoke(null); 
				    }
			   catch(Exception e){ 
				    showMessage(e.toString()); 
				    } 
			  }
		linear_num = 0;
		img = 0;
		if (!sp.getString("photodata", "").equals("")) {
			map = new Gson().fromJson(sp.getString("photodata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
	public void _share() {
	}
	private void shareApplication() { 
		    android.content.pm.ApplicationInfo app = 
		    getApplicationContext().getApplicationInfo(); 
		    String filePath = app.sourceDir;
		    Intent intent = new Intent(Intent.ACTION_SEND); 
		    intent.setType("*/*"); 
		    java.io.File originalApk = new java.io.File(filePath); 
		    try {  
			     java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 
			      if (!tempFile.isDirectory()) 
			      if (!tempFile.mkdirs()) 
			      return; 
			      tempFile = new java.io.File(tempFile.getPath() + "/" + 
			      "Artisan Connect.apk");
			      if (!tempFile.exists()) 
			       {
				       try{
					        if (!tempFile.createNewFile()) { 
						         return; }
					        }
				       catch (java.io.IOException e){} 
				       } 
			      java.io.InputStream in = new java.io.FileInputStream (originalApk);
			      java.io.OutputStream out = new java.io.FileOutputStream(tempFile);
			      byte[] buf = new byte[1024];
			      int len; 
			      while ((len = in.read(buf)) > 0) { 
				        out.write(buf, 0, len); 
				      } 
			      in.close(); 
			      out.close(); 
			      intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
			      startActivity(Intent.createChooser(intent, "Share app via"));
			    } 
		    catch (java.io.IOException e) 
		    { showMessage(e.toString()); 
			    } 
		
		  }
	{
	}
	
	
	public void _Subtitle(final String _Text) {
		getSupportActionBar().setSubtitle(_Text);
	}
	
	
	public void _multiple_image_save(final View _view, final String _name, final String _toast) {
		Bitmap returnedBitmap = Bitmap.createBitmap(_view.getWidth(), _view.getHeight(),Bitmap.Config.ARGB_8888); Canvas canvas = new Canvas(returnedBitmap); android.graphics.drawable.Drawable bgDrawable =_view.getBackground(); if (bgDrawable!=null) { bgDrawable.draw(canvas); } else { canvas.drawColor(Color.WHITE); } _view.draw(canvas); java.io.File pictureFile = new java.io.File(_name); if (pictureFile == null) { showMessage("Error creating media file, check storage permissions: "); return; } try { java.io.FileOutputStream fos = new java.io.FileOutputStream(pictureFile); returnedBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos); fos.close(); showMessage(_toast); } catch (java.io.FileNotFoundException e) { showMessage("File not found: " + e.getMessage()); } catch (java.io.IOException e) { showMessage("Error accessing file: " + e.getMessage()); }
	}
	
	
	public void _ShareImage(final View _view, final String _screen) {
		Bitmap image = Bitmap.createBitmap(_view.getWidth(), _view.getHeight(), Bitmap.Config.ARGB_8888); Canvas canvas = new Canvas(image); android.graphics.drawable.Drawable bgDrawable = _view.getBackground(); if (bgDrawable!=null) { bgDrawable.draw(canvas); } else{ canvas.drawColor(Color.WHITE); } _view.draw(canvas); java.io.File pictureFile = new java.io.File(getExternalCacheDir() + "/image.png"); if (pictureFile == null) { Log.d("errors", "Erro,Cheque As Permissões: "); return; } try { java.io.FileOutputStream fos = new java.io.FileOutputStream(pictureFile); image.compress(Bitmap.CompressFormat.PNG, 90, fos); fos.close(); } catch (java.io.FileNotFoundException e) { Log.d("errors", "Sem Aquivos: " + e.getMessage()); } catch (java.io.IOException e) { Log.d("errors", "Erro Ao Obter Arquivo: " + e.getMessage()); } Intent iten = new Intent(android.content.Intent.ACTION_SEND); iten.setType("image/*"); iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(getExternalCacheDir() + "/image.png"))); startActivity(Intent.createChooser(iten, "Share image"));
	}
	
	
	public void _cornerRadius(final View _view, final String _color, final double _radius, final double _shadow) {
		android.graphics.drawable.GradientDrawable ed = new android.graphics.drawable.GradientDrawable();
		ed.setColor(Color.parseColor(_color));
		ed.setCornerRadius((int)_radius);
		_view.setBackground(ed);
		if(Build.VERSION.SDK_INT >= 21) {_view.setElevation((int)_shadow);}
	}
	
	
	public void _SetShadowOfView(final View _view, final double _value) {
		_view.setElevation((float)_value);
	}
	
	
	public void _round_corner(final View _view, final double _value, final String _color) {
		android.graphics.drawable.GradientDrawable round_corner = new android.graphics.drawable.GradientDrawable();
		round_corner.setColor(Color.parseColor("#"+_color));
		round_corner.setCornerRadius(new Float(_value));
		_view.setBackground(round_corner);
	}
	
	
	public void _set_Notification(final String _Title, final String _Message) {
		/*
Developer :- Aauraparti YouTube channel
Powered by :- Gopal
*/
		
		final Context context = getApplicationContext();
		
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this, MainpageActivity.class); 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0); 
		androidx.core.app.NotificationCompat.Builder builder; 
		
		    int notificationId = 1;
		    String channelId = "channel-01";
		    String channelName = "Channel Name";
		    int importance = NotificationManager.IMPORTANCE_HIGH;
		
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			        NotificationChannel mChannel = new NotificationChannel(
			                channelId, channelName, importance);
			        notificationManager.createNotificationChannel(mChannel);
			    }
		
		  
		 androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
		            .setSmallIcon(R.drawable.art)
		            .setContentTitle(_Title)
		            .setContentText(_Message)
		            .setAutoCancel(true)
		            .setOngoing(false)
		            .setContentIntent(pendingIntent);
		    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		    stackBuilder.addNextIntent(intent);
		    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		    );
		    mBuilder.setContentIntent(resultPendingIntent);
		
		    notificationManager.notify(notificationId, mBuilder.build());
		
	}
	
	
	public void _rippleEffect(final View _view) {
		_view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#b0b0b0")));
		
		_view.setClickable(true);
		
		
	}
	
	public static class Drawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[8];
			        Arrays.fill(outerRadii, 0);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
			    }
	}
	public static class CircleDrawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[180];
			/*YOU CAN CHANGE OUTERRADII TO CHANGE THE ROUNDNESS OF EFFECT*/
			        Arrays.fill(outerRadii, 20);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
		}
	}
	
	
	public void _circleRipple(final String _color, final View _v) {
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , null, null);
		_v.setBackground(ripdrb);
	}
	
	
	public void _Select(final TextView _Textview) {
		_Textview.setTextIsSelectable(true);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom_info, null);
			}
			
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear15 = _view.findViewById(R.id.linear15);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final VideoView videoview1 = _view.findViewById(R.id.videoview1);
			final LinearLayout linear17 = _view.findViewById(R.id.linear17);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final TextView username = _view.findViewById(R.id.username);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final ImageView imageview5 = _view.findViewById(R.id.imageview5);
			final TextView pn = _view.findViewById(R.id.pn);
			final LinearLayout linear_chev = _view.findViewById(R.id.linear_chev);
			final TextView city = _view.findViewById(R.id.city);
			final LinearLayout linear18 = _view.findViewById(R.id.linear18);
			final TextView craft = _view.findViewById(R.id.craft);
			final TextView message = _view.findViewById(R.id.message);
			final TextView date = _view.findViewById(R.id.date);
			
			videoview1.setVisibility(View.GONE);
			imageview5.setVisibility(View.GONE);
			_cornerRadius(linear8, "#FFFFFF", 30, 5);
			if (_data.get((int)_position).containsKey("photo")) {
				if (_data.get((int)_position).get("photo").toString().contains(".jpg") || _data.get((int)_position).get("photo").toString().contains(".png")) {
					imageview1.setVisibility(View.VISIBLE);
					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("photo").toString())).into(imageview1);
				}
				if (_data.get((int)_position).get("photo").toString().contains(".mp4") || _data.get((int)_position).get("photo").toString().contains(".3gp")) {
					imageview5.setVisibility(View.VISIBLE);
					imageview1.setVisibility(View.GONE);
					videoview1.setVisibility(View.VISIBLE);
					videoview1.setVideoURI(Uri.parse(_data.get((int)_position).get("photo").toString()));
				}
			}
			if (_data.get((int)_position).containsKey("description")) {
				message.setText(_data.get((int)_position).get("description").toString());
			}
			if (_data.get((int)_position).containsKey("date")) {
				date.setText(_data.get((int)_position).get("date").toString());
			}
			if (_data.get((int)_position).containsKey("author")) {
				username.setText(_data.get((int)_position).get("author").toString());
			}
			if (_data.get((int)_position).containsKey("phone")) {
				pn.setText(_data.get((int)_position).get("phone").toString());
			}
			if (_data.get((int)_position).containsKey("city")) {
				city.setText(_data.get((int)_position).get("city").toString());
			}
			if (_data.get((int)_position).containsKey("craft")) {
				craft.setText(_data.get((int)_position).get("craft").toString());
			}
			imageview5.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					videoview1.start();
				}
			});
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_data.get((int)_position).get("photo").toString().contains(".jpg") || _data.get((int)_position).get("photo").toString().contains(".png")) {
						di.setTitle("Choose Action");
						di.setNeutralButton("Share Image", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_ShareImage(imageview1, _data.get((int)_position).get("photo").toString());
							}
						});
						di.setNegativeButton("View Image", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								if (_data.get((int)_position).get("photo").toString().contains(".jpg") || _data.get((int)_position).get("photo").toString().contains(".png")) {
									image = _data.get((int)_position).get("photo").toString();
									page.putExtra("url", image);
									page.putExtra("imageName", Uri.parse(image).getLastPathSegment());
									page.setClass(getApplicationContext(), ImgviewActivity.class);
									startActivity(page);
								}
							}
						});
						di.create().show();
					}
				}
			});
			_Select(pn);
			
			return _view;
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