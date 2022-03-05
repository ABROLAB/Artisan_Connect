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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import android.content.ClipData;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.media.MediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import android.widget.AdapterView;
import android.text.Editable;
import android.text.TextWatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.ClipboardManager;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class GeneralchatroomActivity extends AppCompatActivity {
	
	public final int REQ_CD_CAM = 101;
	public final int REQ_CD_FP = 102;
	public final int REQ_CD_IMAGE1 = 103;
	public final int REQ_CD_VIDEO1 = 104;
	public final int REQ_CD_C = 105;
	public final int REQ_CD_FIL = 106;
	public final int REQ_CD_FILL = 107;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private double img = 0;
	private HashMap<String, Object> mm = new HashMap<>();
	private String imgPath = "";
	private String imgName = "";
	private String user_name = "";
	private String file_path = "";
	private String filesize = "";
	private String file = "";
	private HashMap<String, Object> maps = new HashMap<>();
	private double get_dat = 0;
	private boolean replyMode = false;
	private double sound_sent = 0;
	private double sound_receive = 0;
	private boolean get_messages = false;
	private boolean doh = false;
	private boolean IsShow = false;
	private String uid2 = "";
	private boolean onchildAdded = false;
	private double length = 0;
	private double place = 0;
	private double ReplyPosition = 0;
	private String reply_uid = "";
	private String outputFile = "";
	private double time_passed = 0;
	private String voice_duration = "";
	private String ddd = "";
	private String extension = "";
	private String push_key = "";
	private String videoPath = "";
	private String filePathh = "";
	private String imagePath = "";
	private String thumb_String = "";
	private boolean b = false;
	private HashMap<String, Object> map_like = new HashMap<>();
	private double num_like = 0;
	private double likes = 0;
	private double n_ls_like = 0;
	private HashMap<String, Object> put_like = new HashMap<>();
	private String LIKES = "";
	private String date = "";
	private String time = "";
	private String bold = "";
	private String positionpushkey = "";
	private String likekey = "";
	private double like = 0;
	private String username = "";
	private String get_name = "";
	private double n = 0;
	private boolean vidcam = false;
	private String content_path = "";
	private String filePath = "";
	private double count = 0;
	private String imgcount = "";
	private String audiopath = "";
	private String key = "";
	private double like_num = 0;
	private boolean liked = false;
	private String like_key = "";
	private String object_clicked = "";
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lop = new ArrayList<>();
	private ArrayList<String> uid = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> dat = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm_pesan = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm_list_chat = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm_like = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> ls_like = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> user = new ArrayList<>();
	
	private LinearLayout linear_chatroom;
	private LinearLayout linear_main;
	private LinearLayout linear22;
	private ListView listview1;
	private LinearLayout linear_msg_main;
	private LinearLayout layout;
	private TextView textview21;
	private ImageView imageview12;
	private LinearLayout linear_message;
	private ImageView im_send;
	private LinearLayout linear_attach;
	private LinearLayout linear_reply;
	private LinearLayout linear1;
	private LinearLayout linear23;
	private LinearLayout lin_camera;
	private LinearLayout lin_gallery;
	private ImageView imageview14;
	private TextView textview22;
	private ImageView imageview8;
	private TextView textview15;
	private ImageView imageview11;
	private TextView textview20;
	private LinearLayout linear20;
	private ImageView ig_reply_close;
	private TextView name_reply_out;
	private TextView text_reply_out;
	private EditText tx_message;
	private ImageView im_attach_file;
	private ImageView im_send_img;
	
	private Intent i = new Intent();
	private Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_cam;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private Calendar cal = Calendar.getInstance();
	private FirebaseAuth auths;
	private OnCompleteListener<AuthResult> _auths_create_user_listener;
	private OnCompleteListener<AuthResult> _auths_sign_in_listener;
	private OnCompleteListener<Void> _auths_reset_password_listener;
	private OnCompleteListener<Void> auths_updateEmailListener;
	private OnCompleteListener<Void> auths_updatePasswordListener;
	private OnCompleteListener<Void> auths_emailVerificationSentListener;
	private OnCompleteListener<Void> auths_deleteUserListener;
	private OnCompleteListener<Void> auths_updateProfileListener;
	private OnCompleteListener<AuthResult> auths_phoneAuthListener;
	private OnCompleteListener<AuthResult> auths_googleSignInListener;
	
	private StorageReference store = _firebase_storage.getReference("store");
	private OnCompleteListener<Uri> _store_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _store_download_success_listener;
	private OnSuccessListener _store_delete_success_listener;
	private OnProgressListener _store_upload_progress_listener;
	private OnProgressListener _store_download_progress_listener;
	private OnFailureListener _store_failure_listener;
	
	private AlertDialog.Builder d;
	private SharedPreferences sp;
	private SoundPool pool;
	private StorageReference voice = _firebase_storage.getReference("voice");
	private OnCompleteListener<Uri> _voice_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _voice_download_success_listener;
	private OnSuccessListener _voice_delete_success_listener;
	private OnProgressListener _voice_upload_progress_listener;
	private OnProgressListener _voice_download_progress_listener;
	private OnFailureListener _voice_failure_listener;
	
	private StorageReference video = _firebase_storage.getReference("video");
	private OnCompleteListener<Uri> _video_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _video_download_success_listener;
	private OnSuccessListener _video_delete_success_listener;
	private OnProgressListener _video_upload_progress_listener;
	private OnProgressListener _video_download_progress_listener;
	private OnFailureListener _video_failure_listener;
	
	private Intent image1 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent video1 = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference image = _firebase_storage.getReference("image");
	private OnCompleteListener<Uri> _image_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _image_download_success_listener;
	private OnSuccessListener _image_delete_success_listener;
	private OnProgressListener _image_upload_progress_listener;
	private OnProgressListener _image_download_progress_listener;
	private OnFailureListener _image_failure_listener;
	
	private MediaPlayer mediaPlayer;
	private Intent in = new Intent();
	private TimerTask timer;
	private TimerTask tatta;
	private TimerTask tm4;
	private Intent c = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_c;
	private Intent fil = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent fill = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference audio = _firebase_storage.getReference("audio");
	private OnCompleteListener<Uri> _audio_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _audio_download_success_listener;
	private OnSuccessListener _audio_delete_success_listener;
	private OnProgressListener _audio_upload_progress_listener;
	private OnProgressListener _audio_download_progress_listener;
	private OnFailureListener _audio_failure_listener;
	
	private DatabaseReference chatlikes = _firebase.getReference("like");
	private ChildEventListener _chatlikes_child_listener;
	private DatabaseReference userdata = _firebase.getReference("userdata");
	private ChildEventListener _userdata_child_listener;
	private DatabaseReference data = _firebase.getReference("data");
	private ChildEventListener _data_child_listener;
	private Intent page = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.generalchatroom);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		linear_chatroom = findViewById(R.id.linear_chatroom);
		linear_main = findViewById(R.id.linear_main);
		linear22 = findViewById(R.id.linear22);
		listview1 = findViewById(R.id.listview1);
		linear_msg_main = findViewById(R.id.linear_msg_main);
		layout = findViewById(R.id.layout);
		textview21 = findViewById(R.id.textview21);
		imageview12 = findViewById(R.id.imageview12);
		linear_message = findViewById(R.id.linear_message);
		im_send = findViewById(R.id.im_send);
		linear_attach = findViewById(R.id.linear_attach);
		linear_reply = findViewById(R.id.linear_reply);
		linear1 = findViewById(R.id.linear1);
		linear23 = findViewById(R.id.linear23);
		lin_camera = findViewById(R.id.lin_camera);
		lin_gallery = findViewById(R.id.lin_gallery);
		imageview14 = findViewById(R.id.imageview14);
		textview22 = findViewById(R.id.textview22);
		imageview8 = findViewById(R.id.imageview8);
		textview15 = findViewById(R.id.textview15);
		imageview11 = findViewById(R.id.imageview11);
		textview20 = findViewById(R.id.textview20);
		linear20 = findViewById(R.id.linear20);
		ig_reply_close = findViewById(R.id.ig_reply_close);
		name_reply_out = findViewById(R.id.name_reply_out);
		text_reply_out = findViewById(R.id.text_reply_out);
		tx_message = findViewById(R.id.tx_message);
		im_attach_file = findViewById(R.id.im_attach_file);
		im_send_img = findViewById(R.id.im_send_img);
		_file_cam = FileUtil.createNewPictureFile(getApplicationContext());
		Uri _uri_cam;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			_uri_cam = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", _file_cam);
		} else {
			_uri_cam = Uri.fromFile(_file_cam);
		}
		cam.putExtra(MediaStore.EXTRA_OUTPUT, _uri_cam);
		cam.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		auths = FirebaseAuth.getInstance();
		d = new AlertDialog.Builder(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		image1.setType("image/*");
		image1.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		video1.setType("video/*");
		video1.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		_file_c = FileUtil.createNewPictureFile(getApplicationContext());
		Uri _uri_c;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			_uri_c = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", _file_c);
		} else {
			_uri_c = Uri.fromFile(_file_c);
		}
		c.putExtra(MediaStore.EXTRA_OUTPUT, _uri_c);
		c.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		fil.setType("*/*");
		fil.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		fill.setType("*/*");
		fill.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final com.google.android.material.bottomsheet.BottomSheetDialog
				 bs_base = new com.google.android.material.bottomsheet.BottomSheetDialog
				(GeneralchatroomActivity.this);
				
				View layBase = getLayoutInflater().inflate(R.layout.option, null);
				
				bs_base.setContentView(layBase);
				
				bs_base.show();
				final LinearLayout delete = (LinearLayout)layBase.findViewById(R.id.linear4);
				final LinearLayout reply = (LinearLayout)layBase.findViewById(R.id.linear3);
				final LinearLayout copy = (LinearLayout)layBase.findViewById(R.id.linear2);
				final LinearLayout download = (LinearLayout)layBase.findViewById(R.id.linear5);
				final LinearLayout detail = (LinearLayout)layBase.findViewById(R.id.linear6);
				final ImageView img1 = (ImageView)layBase.findViewById(R.id.imageview1);
				final ImageView img2 = (ImageView)layBase.findViewById(R.id.imageview2);
				final ImageView img3 = (ImageView)layBase.findViewById(R.id.imageview3);
				final ImageView img4 = (ImageView)layBase.findViewById(R.id.imageview4);
				final ImageView img5 = (ImageView)layBase.findViewById(R.id.imageview5);
				if (lop.get((int)_position).containsKey("message")) {
					copy.setVisibility(View.VISIBLE);
					download.setVisibility(View.GONE);
					if (lop.get((int)_position).containsKey("image") && lop.get((int)_position).containsKey("video")) {
						download.setVisibility(View.GONE);
					}
				}
				else {
					copy.setVisibility(View.GONE);
					download.setVisibility(View.VISIBLE);
				}
				_Shadow(0, 100, "#ECEFF1", img1);
				_Shadow(0, 100, "#ECEFF1", img2);
				_Shadow(0, 100, "#ECEFF1", img3);
				_Shadow(0, 100, "#ECEFF1", img4);
				_Shadow(0, 100, "#ECEFF1", img5);
				_rippleEffect(delete);
				_rippleEffect(reply);
				_rippleEffect(copy);
				_rippleEffect(download);
				_rippleEffect(detail);
				delete.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						d.setTitle("Delete Message?");
						d.setMessage("Are you sure want to delete this message?");
						d.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								data.child(list.get((int)(_position))).removeValue();
								list.remove((int)(_position));
								SketchwareUtil.showMessage(getApplicationContext(), "Deleted");
							}
						});
						d.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						d.create().show();
						bs_base.dismiss();
					}});
				reply.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						_replyAt(_position);
						bs_base.dismiss();
					}});
				copy.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", lop.get((int)_position).get("message").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), "Copied!");
						bs_base.dismiss();
					}});
				download.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						try {
							if (lop.get((int)_position).containsKey("voice")) {
								if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Imsu Connect/Media/Imsu Connect Voice/".concat("VOC-".concat(lop.get((int)_position).get("path").toString()))))) {
									download.setVisibility(View.GONE);
								}
								else {
									download.setVisibility(View.VISIBLE);
									_firebase_storage.getReferenceFromUrl(lop.get((int)_position).get("voice").toString()).getFile(new File("/Imsu Connect/Media/Imsu Connect Voice/".concat(lop.get((int)_position).get("path").toString()))).addOnSuccessListener(_voice_download_success_listener).addOnFailureListener(_voice_failure_listener).addOnProgressListener(_voice_download_progress_listener);
								}
							}
							else {
								if (lop.get((int)_position).containsKey("file")) {
									if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Imsu Connect/Media/Imsu Connect Documents/".concat(lop.get((int)_position).get("filename").toString())))) {
										download.setVisibility(View.GONE);
									}
									else {
										download.setVisibility(View.VISIBLE);
										
									}
								}
							}
						}catch(Exception e){
							SketchwareUtil.CustomToast(getApplicationContext(), e.toString(), 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
						}
						bs_base.dismiss();
					}});
				detail.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						final com.google.android.material.bottomsheet.BottomSheetDialog
						 menu = new com.google.android.material.bottomsheet.BottomSheetDialog
						(GeneralchatroomActivity.this);
						
						View layBase = getLayoutInflater().inflate(R.layout.mini, null);
						
						menu.setContentView(layBase);
						
						menu.show();
						
						final LinearLayout detail = (LinearLayout)layBase.findViewById(R.id.linear6);
						
						TextView nam = (TextView)layBase.findViewById(R.id.name);
						nam.setText(lop.get((int)_position).get("username").toString());
						
						TextView lik = (TextView)layBase.findViewById(R.id.like);
						lik.setText(LIKES);
						
						TextView dat = (TextView)layBase.findViewById(R.id.date);
						dat.setText(lop.get((int)_position).get("date").toString());
						
						TextView tim = (TextView)layBase.findViewById(R.id.time);
						tim.setText(lop.get((int)_position).get("time").toString());
						bs_base.dismiss();
					}});
				return true;
			}
		});
		
		im_send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					if (tx_message.getText().toString().replace("", "").equals("")) {
						_recordVoice();
						if (replyMode) {
							replyMode = false;
							linear_reply.setVisibility(View.GONE);
						}
					}
					else {
						if (replyMode) {
							push_key = data.push().getKey();
							cal = Calendar.getInstance();
							mm = new HashMap<>();
							mm.put("message", tx_message.getText().toString());
							mm.put("message2", tx_message.getText().toString());
							mm.put("username", get_name);
							mm.put("push key", push_key);
							mm.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
							mm.put("like", "0");
							mm.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
							mm.put("ID", sp.getString("ID", ""));
							mm.put("reply", "true");
							mm.put("reply_position", String.valueOf((long)(ReplyPosition)));
							mm.put("reply_uid", reply_uid);
							mm.put("reply_message", text_reply_out.getText().toString());
							mm.put("date", new SimpleDateFormat("EEEE dd/MMM/yyyy").format(cal.getTime()));
							mm.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
							data.child(push_key).updateChildren(mm);
							mm.clear();
							tx_message.setText("");
							replyMode = false;
							linear_reply.setVisibility(View.GONE);
						}
						else {
							push_key = data.push().getKey();
							cal = Calendar.getInstance();
							mm = new HashMap<>();
							mm.put("message", tx_message.getText().toString());
							mm.put("message2", tx_message.getText().toString());
							mm.put("username", get_name);
							mm.put("push key", push_key);
							mm.put("like", "0");
							mm.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
							mm.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
							mm.put("ID", sp.getString("ID", ""));
							mm.put("date", new SimpleDateFormat("dd/MMM/yyyy").format(cal.getTime()));
							mm.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
							data.child(push_key).updateChildren(mm);
							mm.clear();
							tx_message.setText("");
							replyMode = false;
							linear_reply.setVisibility(View.GONE);
						}
					}
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
		});
		
		linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fill, REQ_CD_FILL);
			}
		});
		
		lin_camera.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(image1, REQ_CD_IMAGE1);
			}
		});
		
		lin_gallery.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(video1, REQ_CD_VIDEO1);
			}
		});
		
		ig_reply_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				replyMode = false;
				linear_reply.setVisibility(View.GONE);
			}
		});
		
		tx_message.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.replace("", "").equals("")) {
					im_send.setImageResource(R.drawable.ic_mic_none_white);
				}
				else {
					im_send.setImageResource(R.drawable.sendmes);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		im_attach_file.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (doh) {
					doh = false;
					linear_attach.setVisibility(View.GONE);
					_TransitionManager(linear_message, 300);
				}
				else {
					doh = true;
					linear_attach.setVisibility(View.VISIBLE);
					_TransitionManager(linear_message, 300);
				}
				if (replyMode) {
					replyMode = false;
					linear_reply.setVisibility(View.GONE);
				}
			}
		});
		
		im_send_img.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				Intent intent = new
				Intent(MediaStore.ACTION_VIDEO_CAPTURE);
				
				intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
				
				startActivityForResult(intent, REQ_CD_CAM);
				vidcam = true;
				return true;
			}
		});
		
		im_send_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(cam, REQ_CD_CAM);
			}
		});
		
		_store_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_store_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_store_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_store_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_store_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_store_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_voice_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				SketchwareUtil.CustomToast(getApplicationContext(), "Sending...Please wait", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_voice_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_voice_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				push_key = data.push().getKey();
				mm = new HashMap<>();
				mm.put("message", "Voice 🔊");
				mm.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				mm.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
				mm.put("username", get_name);
				mm.put("like", "0");
				mm.put("push key", push_key);
				mm.put("voice", _downloadUrl);
				mm.put("voice_during", voice_duration);
				mm.put("path", outputFile);
				mm.put("date", new SimpleDateFormat("dd/MMM/yyyy").format(cal.getTime()));
				mm.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
				data.child(push_key).updateChildren(mm);
				tx_message.setText("");
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		};
		
		_voice_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				SketchwareUtil.CustomToast(getApplicationContext(), "Stored on /storage/emulated/0/Imsu Connect/Media/Imsu Connect Voice/", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_voice_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_voice_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_video_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				SketchwareUtil.CustomToast(getApplicationContext(), "Uploading...please wait", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				_CoreProgressLoading(true);
			}
		};
		
		_video_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				SketchwareUtil.CustomToast(getApplicationContext(), "Downloading... please wait", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				_CoreProgressLoading(true);
			}
		};
		
		_video_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				push_key = data.push().getKey();
				mm = new HashMap<>();
				mm.put("message", tx_message.getText().toString());
				mm.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				mm.put("username", get_name);
				mm.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
				mm.put("like", "0");
				mm.put("push key", push_key);
				mm.put("video", _downloadUrl);
				mm.put("videoName", Uri.parse(videoPath).getLastPathSegment());
				mm.put("date", new SimpleDateFormat("dd/MMM/yyyy").format(cal.getTime()));
				mm.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
				data.child(push_key).updateChildren(mm);
				tx_message.setText("");
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				_CoreProgressLoading(false);
				thumb_String = "";
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		};
		
		_video_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				SketchwareUtil.CustomToast(getApplicationContext(), "Stored on /storage/emulated/0/Imsu Connect/Media/Imsu Connect Video/", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_video_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_video_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.CustomToast(getApplicationContext(), _message, 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_image_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				SketchwareUtil.CustomToast(getApplicationContext(), "Uploading...please wait", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				_CoreProgressLoading(true);
			}
		};
		
		_image_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				SketchwareUtil.CustomToast(getApplicationContext(), "Downloading... please wait", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				_CoreProgressLoading(true);
			}
		};
		
		_image_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				push_key = data.push().getKey();
				mm = new HashMap<>();
				mm.put("message", tx_message.getText().toString());
				mm.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				mm.put("username", user_name);
				mm.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
				mm.put("push key", push_key);
				mm.put("like", "0");
				mm.put("image", _downloadUrl);
				mm.put("imageName", Uri.parse(imagePath).getLastPathSegment());
				mm.put("date", new SimpleDateFormat("dd/MMM/yyyy").format(cal.getTime()));
				mm.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
				data.child(push_key).updateChildren(mm);
				tx_message.setText("");
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				_CoreProgressLoading(false);
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		};
		
		_image_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_image_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_image_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.CustomToast(getApplicationContext(), _message, 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_audio_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				SketchwareUtil.CustomToast(getApplicationContext(), "Sending...Please wait", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_audio_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_audio_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				push_key = data.push().getKey();
				mm = new HashMap<>();
				mm.put("message", "Voice 🔊");
				mm.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				mm.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
				mm.put("username", get_name);
				mm.put("like", "0");
				mm.put("push key", push_key);
				mm.put("voice", _downloadUrl);
				mm.put("voice_during", voice_duration);
				mm.put("path", audiopath);
				mm.put("date", new SimpleDateFormat("dd/MMM/yyyy").format(cal.getTime()));
				mm.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
				data.child(push_key).updateChildren(mm);
				tx_message.setText("");
				im_send.setEnabled(true);
				if (replyMode) {
					linear_reply.setVisibility(View.GONE);
					replyMode = false;
				}
				if (doh) {
					linear_attach.setVisibility(View.GONE);
					doh = false;
				}
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		};
		
		_audio_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				SketchwareUtil.CustomToast(getApplicationContext(), "Stored on /storage/emulated/0/Imsu Connect/Media/Imsu Connect Audio/", 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
			}
		};
		
		_audio_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_audio_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_chatlikes_child_listener = new ChildEventListener() {
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
		chatlikes.addChildEventListener(_chatlikes_child_listener);
		
		_userdata_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				try {
					userdata.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							user = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									user.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							get_name = _childValue.get("username").toString();
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				} catch (Exception e) {
					SketchwareUtil.CustomToast(getApplicationContext(), "Error in delivering results", 0xFFFFFFFF, 12, 0xFF000000, 60, SketchwareUtil.BOTTOM);
				}
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
		
		_data_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				try {
					data.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							lop = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									lop.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							list.add(_childKey);
							listview1.setAdapter(new Listview1Adapter(lop));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							sp.edit().putString("chatdata", new Gson().toJson(lop)).commit();
							LIKES = _childValue.get("like").toString();
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				} catch (Exception e) {
					SketchwareUtil.showMessage(getApplicationContext(), "Error in delivering results...Contact the administrator");
				}
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
				data.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lop = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lop.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(lop));
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
		data.addChildEventListener(_data_child_listener);
		
		auths_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auths_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auths_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auths_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auths_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auths_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auths_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auths_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auths_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auths_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_edittext_mh(tx_message);
		key = chatlikes.push().getKey();
		like_num = 0;
		liked = false;
		like_key = key;
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listview1.setStackFromBottom(true);
		data.addChildEventListener(_data_child_listener);
		userdata.addChildEventListener(_userdata_child_listener);
		img = 0;
		linear_attach.setVisibility(View.GONE);
		linear_reply.setVisibility(View.GONE);
		layout.setVisibility(View.GONE);
		replyMode = false;
		pool = new SoundPool((int)(2), AudioManager.STREAM_MUSIC, 0);
		sound_receive = pool.load(getApplicationContext(), R.raw.incoming, 1);
		sound_sent = pool.load(getApplicationContext(), R.raw.send_message, 1);
		linear_message.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)60, 0xFFEEEEEE));
		im_send.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFF57C00));
		linear_reply.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)60, 0xFFEEEEEE));
		get_messages = true;
		_get_message_();
		doh = false;
		IsShow = false;
	}
	
	private MediaRecorder myAudioRecorder;
	
	private void fo4o() {
		b = false;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_VIDEO1:
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
				try {
					videoPath = _filePath.get((int)(0));
					video.child(Uri.parse(videoPath).getLastPathSegment()).putFile(Uri.fromFile(new File(videoPath))).addOnFailureListener(_video_failure_listener).addOnProgressListener(_video_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return video.child(Uri.parse(videoPath).getLastPathSegment()).getDownloadUrl();
						}}).addOnCompleteListener(_video_upload_success_listener);
				}catch(Exception e){
					SketchwareUtil.CustomToast(getApplicationContext(), e.toString(), 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				}
			}
			else {
				
			}
			break;
			
			case REQ_CD_IMAGE1:
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
				try {
					lm_list_chat.clear();
					n = 0;
					count = _filePath.size();
					imgcount = _filePath.get((int)(n));
					for(int _repeat24 = 0; _repeat24 < (int)(count); _repeat24++) {
						image.child(Uri.parse(imgcount).getLastPathSegment()).putFile(Uri.fromFile(new File(imgcount))).addOnFailureListener(_image_failure_listener).addOnProgressListener(_image_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
							@Override
							public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
								return image.child(Uri.parse(imgcount).getLastPathSegment()).getDownloadUrl();
							}}).addOnCompleteListener(_image_upload_success_listener);
						n++;
					}
				}catch(Exception e){
					SketchwareUtil.CustomToast(getApplicationContext(), e.toString(), 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				}
			}
			else {
				
			}
			break;
			
			case REQ_CD_CAM:
			if (_resultCode == Activity.RESULT_OK) {
				 String _filePath = _file_cam.getAbsolutePath();
				
				imgcount = _filePath;
				image.child(Uri.parse(imgcount).getLastPathSegment()).putFile(Uri.fromFile(new File(imgcount))).addOnFailureListener(_image_failure_listener).addOnProgressListener(_image_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return image.child(Uri.parse(imgcount).getLastPathSegment()).getDownloadUrl();
					}}).addOnCompleteListener(_image_upload_success_listener);
			}
			else {
				
			}
			break;
			
			case REQ_CD_FILL:
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
				try {
					audiopath = _filePath.get((int)(0));
					audio.child(Uri.parse(audiopath).getLastPathSegment()).putFile(Uri.fromFile(new File(audiopath))).addOnFailureListener(_audio_failure_listener).addOnProgressListener(_audio_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return audio.child(Uri.parse(audiopath).getLastPathSegment()).getDownloadUrl();
						}}).addOnCompleteListener(_audio_upload_success_listener);
				}catch(Exception e){
					SketchwareUtil.CustomToast(getApplicationContext(), e.toString(), 0xFFFFFFFF, 12, 0xFF424242, 60, SketchwareUtil.BOTTOM);
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (!sp.getString("chatdata", "").equals("")) {
			lop = new Gson().fromJson(sp.getString("chatdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(lop));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		i.setClass(getApplicationContext(), MainpageActivity.class);
		startActivity(i);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		get_messages = true;
		sp.edit().putString("chat", "message").commit();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		get_messages = false;
		sp.edit().putString("chat", "").commit();
	}
	public void _CardView(final String _color, final double _radius, final double _shadow, final View _view) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_radius);
		_view.setBackground(gd);
		
		try {
			if(Build.VERSION.SDK_INT >= 21) {
				_view.setElevation((int)_shadow);
			}
		} catch (Exception e) {}
	}
	
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		final Object _keyObject = _key;
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					}
					else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				}
				else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					}
					else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
		///Use true or false blocks if sorting number of listmap
	}
	
	
	public void _saveList(final SharedPreferences _getShPref, final ArrayList<String> _getList, final boolean _isSaving) {
		//set SharedPreferences and ListString when you start this block
		if (!_getShPref.getString("length", "").equals("")) {
			if (_isSaving) {
				//saves the list
				length = _getList.size();
				place = length - 1;
				_getShPref.edit().putString("length", String.valueOf((long)(length))).commit();
				for(int _repeat16 = 0; _repeat16 < (int)(length); _repeat16++) {
					_getShPref.edit().putString(String.valueOf((long)(place)), _getList.get((int)(place))).commit();
					place--;
				}
			}
			else {
				//read from SharedPreferences
				length = Double.parseDouble(_getShPref.getString("length", ""));
				place = length - 1;
				for(int _repeat43 = 0; _repeat43 < (int)(length); _repeat43++) {
					_getList.add(_getShPref.getString(String.valueOf((long)(place)), ""));
					place--;
				}
			}
		}
		else {
			
		}
	}
	
	
	public void _get_child_key() {
		
	}
	
	
	public void _replyAt(final double _position) {
		linear_reply.setVisibility(View.VISIBLE);
		replyMode = true;
		ReplyPosition = _position;
		if (lop.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
			name_reply_out.setText("Me");
			reply_uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
		}
		else {
			name_reply_out.setText(get_name);
			reply_uid = lop.get((int)_position).get("uid").toString();
		}
		if (lop.get((int)_position).containsKey("message")) {
			text_reply_out.setText(lop.get((int)_position).get("message").toString());
		}
		else {
			if (lop.get((int)_position).containsKey("image")) {
				text_reply_out.setText("Image📷");
			}
			else {
				if (lop.get((int)_position).containsKey("voice")) {
					text_reply_out.setText("voice message 🔊");
				}
				else {
					if (lop.get((int)_position).containsKey("video")) {
						text_reply_out.setText("Video 📽");
					}
					else {
						if (lop.get((int)_position).containsKey("file")) {
							text_reply_out.setText("File 📃");
						}
					}
				}
			}
		}
	}
	
	
	public void _recordVoice() {
		cal = Calendar.getInstance();
		outputFile = FileUtil.getExternalStorageDir().concat("/Imsu Connect/Media/Imsu Connect Voice/".concat(String.valueOf((long)(cal.getTimeInMillis()))));
		myAudioRecorder = new MediaRecorder();
		
		myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		
		myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		
		myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
		
		myAudioRecorder.setOutputFile(outputFile);
		final com.google.android.material.bottomsheet.BottomSheetDialog
		 pro_dialog = new com.google.android.material.bottomsheet.BottomSheetDialog
		(GeneralchatroomActivity.this);
		
		LayoutInflater inflater = getLayoutInflater();
		
		View convertView = (View) inflater.inflate(R.layout.recording, null);
		
		pro_dialog.setContentView(convertView);
		
		pro_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { 		@Override 		public void onDismiss(DialogInterface dialogInterface) { 			
				
				try {
					myAudioRecorder.stop();
					myAudioRecorder.release();
					myAudioRecorder = null;
				} catch(Exception e) {}
				
				 	} });
		
		/*

View touchOutsideView = pro_dialog.getWindow().getDecorView().findViewById(com.google.android.material.R
.id.touch_outside);

touchOutsideView.setOnClickListener(null);

View bottomSheetView = pro_dialog.getWindow().getDecorView().findViewById(com.google.android.material.R
.id.design_bottom_sheet);

com.google.android.material.bottomsheet.BottomSheetBehavior
.from(bottomSheetView).setHideable(false);

*/
		final ImageView l_send = (ImageView)convertView.findViewById(R.id.l_send);
		final ImageView l_stop = (ImageView)convertView.findViewById(R.id.l_stop);
		final TextView tx_duration = (TextView)convertView.findViewById(R.id.tx_duration);
		l_send.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
		_Shadow(0, 100, "#ECEFF1", l_send);
		_Shadow(0, 100, "#ECEFF1", l_stop);
		try {
			
			myAudioRecorder.prepare();
			myAudioRecorder.start();
			
		} catch (Exception e) {
		}
		time_passed = 0;
		try {
			timer.cancel();
		} catch(Exception e) {}
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						time_passed++;
						tx_duration.setText(String.valueOf((long)(time_passed / 60)).concat(":".concat(String.valueOf((long)(time_passed % 60)))));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
		l_send.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
				try {
					myAudioRecorder.stop();
					myAudioRecorder.release();
					myAudioRecorder = null;
				} catch(Exception e) {}
				voice_duration = tx_duration.getText().toString();
				voice.child(Uri.parse(outputFile).getLastPathSegment()).putFile(Uri.fromFile(new File(outputFile))).addOnFailureListener(_voice_failure_listener).addOnProgressListener(_voice_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return voice.child(Uri.parse(outputFile).getLastPathSegment()).getDownloadUrl();
					}}).addOnCompleteListener(_voice_upload_success_listener);
				pro_dialog.dismiss();
			}
				});
		l_stop.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
				try {
					myAudioRecorder.stop();
					myAudioRecorder.release();
					myAudioRecorder = null;
				} catch(Exception e) {}
				pro_dialog.dismiss();
			}
				});
		pro_dialog.show();
	}
	
	
	public void _playVoice(final double _position, final ImageView _img, final SeekBar _seekbar, final ArrayList<HashMap<String, Object>> _listmap) {
		ddd = _listmap.get((int)_position).get("path").toString();
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(ddd);
			mediaPlayer.prepare();
			mediaPlayer.start();
			_seekbar.setMax((int)mediaPlayer.getDuration());
			_img.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if (mediaPlayer.isPlaying()) {
						mediaPlayer.pause();
					}
					else {
						mediaPlayer.start();
					}
				}});
			try {
				tm4.cancel();
			} catch(Exception e) {}
			try {
				tatta.cancel();
			} catch(Exception e) {}
			tatta = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_seekbar.setProgress((int)mediaPlayer.getCurrentPosition());
							if (mediaPlayer.isPlaying()) {
								_img.setImageResource(R.drawable.ic_pause_white);
							}
							else {
								_img.setImageResource(R.drawable.ic_play_arrow_white);
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(tatta, (int)(0), (int)(750));
		} catch(Exception e) {}
		_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
						@Override
						public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
								final int _progressValue = _param2;
								
						}
						
						@Override
						public void onStartTrackingTouch(SeekBar _param1) {
								
						}
						
						@Override
						public void onStopTrackingTouch(SeekBar _param2) {
								
				try {
					if (!mediaPlayer.isPlaying()) {
						mediaPlayer.start();
					}
					mediaPlayer.seekTo((int)(_seekbar.getProgress()));
				} catch(Exception e) {}
			}
				});
		_img.setImageResource(R.drawable.ic_pause_white);
		mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			    public void onCompletion(MediaPlayer mp) {
				_img.setImageResource(R.drawable.ic_play_arrow_white);
			}
		});
	}
	
	
	public void _SX_CornerRadius_4(final View _view, final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
		
		_view.setElevation(2);
	}
	
	
	public void _setRadius(final double _position, final boolean _my_user_id, final ArrayList<HashMap<String, Object>> _listmap, final View _linear_layout) {
		if (_my_user_id) {
			if (_position == 0) {
				_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 3, 15);
				if (_listmap.size() == 1) {
					_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 15, 15);
				}
				else {
					if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
						_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 50, 15, 15);
					}
				}
			}
			else {
				if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
					_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 3, 15);
					if (_position == (_listmap.size() - 1)) {
						_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 15, 15);
					}
					else {
						if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 15, 15);
						}
					}
				}
				else {
					if (_position == (_listmap.size() - 1)) {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 3, 15, 15);
						}
						else {
							_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 15, 15);
						}
					}
					else {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString()) && _listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 3, 3, 15);
						}
						else {
							if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
								_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 15, 3, 15);
							}
							else {
								_SX_CornerRadius_4(_linear_layout, "#FFF7991D", "#FFF7991D", 0, 15, 3, 15, 15);
							}
						}
					}
				}
			}
		}
		else {
			if (_position == 0) {
				_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 15, 15, 15, 3);
				if (_listmap.size() == 1) {
					_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 15, 15, 15, 15);
				}
				else {
					if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
						_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 15, 15, 15, 15);
					}
				}
			}
			else {
				if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
					_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 15, 15, 15, 3);
				}
				else {
					if (_position == (_listmap.size() - 1)) {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 3, 15, 15, 15);
						}
						else {
							_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 15, 15, 15, 15);
						}
					}
					else {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString()) && _listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 3, 15, 15, 3);
						}
						else {
							if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
								_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 15, 15, 15, 3);
							}
							else {
								_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 3, 15, 15, 15);
							}
						}
					}
				}
			}
		}
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
	
	
	public void _Shadow(final double _sadw, final double _cru, final String _wc, final View _widgets) {
		android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
		wd.setColor(Color.parseColor(_wc));
		wd.setCornerRadius((int)_cru);
		_widgets.setElevation((int)_sadw);
		_widgets.setBackground(wd);
	}
	
	
	public void _smoothScroll(final double _position) {
		listview1.smoothScrollToPosition((int)(_position));
	}
	
	
	public void _setImageByExtension(final ImageView _ig, final String _str) {
		try {
			extension = _str.substring((int)(_str.lastIndexOf(".") + 1), (int)(_str.length()));
		} catch(Exception e) {
			extension = "";
		}
		if (extension.equals("avi")) {
			_ig.setImageResource(R.drawable.attach_video);
		}
		else {
			if (extension.equals("html")) {
				_ig.setImageResource(R.drawable.attach_document);
			}
			else {
				if (extension.equals("txt")) {
					_ig.setImageResource(R.drawable.icon_file_doc);
				}
				else {
					if (extension.equals("xml")) {
						_ig.setImageResource(R.drawable.default_image);
					}
					else {
						if (extension.equals("zip")) {
							_ig.setImageResource(R.drawable.default_image);
						}
						else {
							if (extension.equals("doc")) {
								_ig.setImageResource(R.drawable.icon_file_doc);
							}
							else {
								if (extension.equals("pdf")) {
									_ig.setImageResource(R.drawable.default_image);
								}
								else {
									if (extension.equals("apk")) {
										_ig.setImageResource(R.drawable.icon_file_doc);
									}
									else {
										_ig.setImageResource(R.drawable.default_image);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _imageUrl(final ImageView _view, final String _url) {
		
		Glide.with(getApplicationContext())
		.load(_url)
		.centerCrop()
		.into(_view);
	}
	
	
	public void _circleRipple(final String _color, final View _v) {
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , null, null);
		_v.setBackground(ripdrb);
	}
	
	
	public void _CoreProgressLoading(final boolean _ifShow) {
		if (_ifShow) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.setMessage(null);
			coreprog.show();
			coreprog.setContentView(R.layout.custom_dialog);
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _Animasi(final View _view, final String _transitionName, final Intent _intent) {
		_view.setTransitionName(_transitionName); android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(GeneralchatroomActivity.this, _view, _transitionName); startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _transitionName(final String _transitionName, final View _view) {
		_view.setTransitionName(_transitionName);
	}
	
	
	public void _set_Notification(final String _Title, final String _Message) {
		/*
Developer :- Aauraparti YouTube channel
Powered by :- Gopal
*/
		
		final Context context = getApplicationContext();
		
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this, GeneralchatroomActivity.class); 
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
	
	
	public void _get_message_() {
		if (!sp.getString("chatdata", "").equals("")) {
			lop = new Gson().fromJson(sp.getString("chatdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(lop));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); listview1.setStackFromBottom(true);
		}
		if (get_messages) {
			data.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					lop = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							lop.add(_map);
						}
					}
					catch (Exception _e) {
						_e.printStackTrace();
					}
					if (lop.size() > 0) {
						listview1.setAdapter(new Listview1Adapter(lm_pesan));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); listview1.setStackFromBottom(true);
						if (sp.getString("pushkey", "").equals(lop.get((int)lop.size() - 1).get("push key").toString())) {
							
						}
						else {
							if (lop.get((int)lop.size() - 1).get("push key").toString().equals(data.push().getKey())) {
								sound_sent = pool.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
							}
							else {
								sound_receive = pool.play((int)(2), 1.0f, 1.0f, 1, (int)(0), 1.0f);
							}
						}
						sp.edit().putString("pushkey", lop.get((int)lop.size() - 1).get("push key").toString()).commit();
					}
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									onchildAdded = true;
								}
							});
						}
					};
					_timer.schedule(timer, (int)(500));
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
		}
	}
	
	
	public void _edittext_mh(final TextView _txt) {
		final TextView regex1 = new TextView(this);
		
		regex1.setText("(?<![^\\s])(([@]{1}|[#]{1})([A-Za-z0-9_-]\\.?)+)(?![^\\s,])");
		final String mentionColor = "#2196F3";
		_txt.addTextChangedListener(new TextWatcher() {
			ColorScheme keywords1 = new ColorScheme(java.util.regex.Pattern.compile(regex1.getText().toString()), Color.parseColor(mentionColor));
			final ColorScheme[] schemes = {keywords1};
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			@Override
			public void afterTextChanged(Editable s) {
				removeSpans(s, android.text.style.ForegroundColorSpan.class);
				for(ColorScheme scheme : schemes) {
					for(java.util.regex.Matcher m = scheme.pattern.matcher(s);
					m.find();) {
						s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
						s.setSpan(new android.text.style.StyleSpan(Typeface.BOLD), m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
						
					}
				}
			}
			void removeSpans(Editable e, Class type) {
				android.text.style.CharacterStyle[] spans = e.getSpans(0, e.length(), type);
				for (android.text.style.CharacterStyle span : spans) {
					e.removeSpan(span);
				}
			}
			class ColorScheme {
				final java.util.regex.Pattern pattern;
				final int color;
				ColorScheme(java.util.regex.Pattern pattern, int color) {
					this.pattern = pattern;
					this.color = color;
				}
			}
		});
	}
	
	
	public void _textview_mh(final TextView _txt, final String _value) {
		_txt.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
		//_txt.setTextIsSelectable(true);
		updateSpan(_value, _txt);
	}
	private void updateSpan(String str, TextView _txt){
		SpannableString ssb = new SpannableString(str);
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(?<![^\\s])(([@]{1}|[#]{1})([A-Za-z0-9_-]\\.?)+)(?![^\\s,])");
		    java.util.regex.Matcher matcher = pattern.matcher(str);
		while(matcher.find()){
			ProfileSpan span = new ProfileSpan();
			ssb.setSpan(span, matcher.start() , matcher. end() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		} 
		_txt.setText(ssb);
		
	}
	private class ProfileSpan extends android.text.style.ClickableSpan{
		
		
		@Override
		public void onClick(View view){
			
			if(view instanceof TextView){
				    TextView tv = (TextView)view;
				
				    if(tv.getText() instanceof Spannable){
					        Spannable sp = (Spannable)tv.getText();
					    
					        int start = sp.getSpanStart(this);
					        int end = sp.getSpanEnd(this);
					        object_clicked = sp.subSequence(start,end).toString();
					SketchwareUtil.CustomToast(getApplicationContext(), object_clicked, 0xFFFFFFFF, 12, 0xFF000000, 60, SketchwareUtil.BOTTOM);
				}
			}
			
		}
		@Override
		    public void updateDrawState(TextPaint ds) {
			        ds.setUnderlineText(false);
			        ds.setColor(Color.parseColor("#2196F3"));
			        ds.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
			    }
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
				_view = _inflater.inflate(R.layout.gen_chatcustom, null);
			}
			
			final LinearLayout linear_main = _view.findViewById(R.id.linear_main);
			final LinearLayout linear_item = _view.findViewById(R.id.linear_item);
			final LinearLayout linear_message = _view.findViewById(R.id.linear_message);
			final LinearLayout l_voice = _view.findViewById(R.id.l_voice);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout lin_reply = _view.findViewById(R.id.lin_reply);
			final LinearLayout linear_name = _view.findViewById(R.id.linear_name);
			final TextView tx_message = _view.findViewById(R.id.tx_message);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView tx_reply_msg = _view.findViewById(R.id.tx_reply_msg);
			final TextView tx_replyer = _view.findViewById(R.id.tx_replyer);
			final ImageView verify2 = _view.findViewById(R.id.verify2);
			final TextView nameuser = _view.findViewById(R.id.nameuser);
			final ImageView verify = _view.findViewById(R.id.verify);
			final ImageView im_play = _view.findViewById(R.id.im_play);
			final SeekBar seekbar1 = _view.findViewById(R.id.seekbar1);
			final TextView tx_voice_name = _view.findViewById(R.id.tx_voice_name);
			final ImageView thumbs = _view.findViewById(R.id.thumbs);
			final TextView videotext = _view.findViewById(R.id.videotext);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView imagetext = _view.findViewById(R.id.imagetext);
			
			try {
				verify.setVisibility(View.GONE);
				verify2.setVisibility(View.GONE);
				linear_name.setVisibility(View.GONE);
				imagetext.setVisibility(View.GONE);
				videotext.setVisibility(View.GONE);
				get_name = user.get((int)_position).get("username").toString();
				nameuser.setText(user.get((int)_position).get("username").toString());
			} catch (Exception e) {
				 
			}
			try {
				_Shadow(0, 10, "#FFF7991D", linear2);
				_Shadow(0, 10, "#FFF7991D", linear1);
				_Shadow(0, 0, "#FFFFFF", thumbs);
				int[] colorsCRNZC = { Color.parseColor("#FFF7991D"), Color.parseColor("#ffb74d") }; android.graphics.drawable.GradientDrawable CRNZC = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colorsCRNZC);
				 Color.parseColor("#ffb74d");
				linear_message.setElevation((float) 0);
				linear_message.setBackground(CRNZC);
				if (lop.get((int)_position).get("email").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					linear_main.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
					linear_item.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
					tx_message.setTextColor(0xFFFFFFFF);
					_setRadius(_position, true, lop, linear_message);
					_Shadow(0, 15, "#ffb74d", lin_reply);
					tx_replyer.setTextColor(0xFFFFFFFF);
					tx_reply_msg.setTextColor(0xFFFFFFFF);
					_setRadius(_position, true, lop, l_voice);
					tx_voice_name.setTextColor(0xFFFFFFFF);
					im_play.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
					seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
					seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
					tx_message.setAutoLinkMask(android.text.util.Linkify.ALL);
					    tx_message.setLinkTextColor(Color.parseColor("#FFFFFF"));
					
					tx_message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
					if (lop.get((int)_position).get("email").toString().equals("archpacetechnologies@gmail.com")) {
						linear_main.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);
						linear_item.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);
						tx_message.setTextColor(0xFFFFFFFF);
						_setRadius(_position, true, lop, linear_message);
						_Shadow(0, 15, "#9e9e9e", lin_reply);
						tx_replyer.setTextColor(0xFFFFFFFF);
						tx_reply_msg.setTextColor(0xFFFFFFFF);
						_setRadius(_position, true, lop, l_voice);
						tx_voice_name.setTextColor(0xFFFFFFFF);
						im_play.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
						seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
						seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
						tx_message.setAutoLinkMask(android.text.util.Linkify.ALL);
						    tx_message.setLinkTextColor(Color.parseColor("#FFFFFF"));
						
						tx_message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
					}
				}
				else {
					linear_main.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
					linear_item.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
					tx_message.setTextColor(0xFF000000);
					_setRadius(_position, false, lop, linear_message);
					_Shadow(0, 15, "#EEEEEE", lin_reply);
					_Shadow(0, 10, "#9e9e9e", linear1);
					_Shadow(0, 10, "#9e9e9e", linear2);
					tx_replyer.setTextColor(0xFF000000);
					tx_reply_msg.setTextColor(0xFF000000);
					_setRadius(_position, false, lop, l_voice);
					tx_voice_name.setTextColor(0xFF000000);
					im_play.setColorFilter(0xFF607D8B, PorterDuff.Mode.MULTIPLY);
					seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#008DCD"), PorterDuff.Mode.SRC_IN);
					seekbar1.getThumb().setColorFilter(Color.parseColor("#008DCD"), PorterDuff.Mode.SRC_IN);
					tx_message.setAutoLinkMask(android.text.util.Linkify.ALL);
					    tx_message.setLinkTextColor(Color.parseColor("#008DCD"));
					
					tx_message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
					linear_name.setVisibility(View.VISIBLE);
					if (lop.get((int)_position).get("email").toString().equals("archpacetechnologies@gmail.com")) {
						linear_main.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);
						linear_item.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);
						tx_message.setTextColor(0xFFFFFFFF);
						_setRadius(_position, true, lop, linear_message);
						_Shadow(0, 15, "#9e9e9e", lin_reply);
						tx_replyer.setTextColor(0xFFFFFFFF);
						tx_reply_msg.setTextColor(0xFFFFFFFF);
						_setRadius(_position, true, lop, l_voice);
						tx_voice_name.setTextColor(0xFFFFFFFF);
						im_play.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
						seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
						seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
						tx_message.setAutoLinkMask(android.text.util.Linkify.ALL);
						    tx_message.setLinkTextColor(Color.parseColor("#FFFFFF"));
						
						tx_message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
					}
				}
				if (lop.get((int)_position).containsKey("message")) {
					tx_reply_msg.setVisibility(View.GONE);
					linear_message.setVisibility(View.VISIBLE);
					tx_message.setText(lop.get((int)_position).get("message").toString());
					if (tx_message.getText().toString().startsWith("https://")) {
						//Copied From Universal SketchCode.
						
						tx_message.setClickable(true);
						android.text.util.Linkify.addLinks(tx_message, android.text.util.Linkify.ALL);
						tx_message.setLinkTextColor(Color.parseColor("#009688"));
						tx_message.setLinksClickable(true);
					}
					_textview_mh(tx_message, tx_message.getText().toString());
				}
				else {
					tx_message.setVisibility(View.GONE);
					linear_message.setVisibility(View.GONE);
				}
				if (lop.get((int)_position).containsKey("image")) {
					linear_message.setVisibility(View.GONE);
					tx_reply_msg.setVisibility(View.GONE);
					imageview1.setVisibility(View.VISIBLE);
					tx_message.setVisibility(View.GONE);
					_imageUrl(imageview1, lop.get((int)_position).get("image").toString());
					if (!lop.get((int)_position).get("message").toString().equals("")) {
						tx_reply_msg.setVisibility(View.GONE);
						imagetext.setVisibility(View.VISIBLE);
						imagetext.setText(lop.get((int)_position).get("message").toString());
						_textview_mh(imagetext, imagetext.getText().toString());
					}
				}
				else {
					imageview1.setVisibility(View.GONE);
				}
				if (lop.get((int)_position).containsKey("reply")) {
					tx_reply_msg.setText(lop.get((int)_position).get("reply_message").toString());
					lin_reply.setVisibility(View.VISIBLE);
					lin_reply.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							_smoothScroll(Double.parseDouble(lop.get((int)_position).get("reply_position").toString()));
						}
					});
					if (lop.get((int)_position).get("reply_uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						tx_replyer.setText("You");
					}
					else {
						tx_replyer.setText(lop.get((int)_position).get("username").toString());
					}
				}
				else {
					lin_reply.setVisibility(View.GONE);
				}
				if (lop.get((int)_position).containsKey("voice")) {
					linear_message.setVisibility(View.GONE);
					tx_reply_msg.setVisibility(View.GONE);
					tx_message.setVisibility(View.GONE);
					l_voice.setVisibility(View.VISIBLE);
					tx_voice_name.setText(lop.get((int)_position).get("voice_during").toString());
					im_play.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (lop.get((int)_position).containsKey("path")) {
								if (FileUtil.isExistFile(lop.get((int)_position).get("path").toString())) {
									_playVoice(_position, im_play, seekbar1, lop);
								}
								else {
									_firebase_storage.getReferenceFromUrl(lop.get((int)_position).get("voice").toString()).getFile(new File(lop.get((int)_position).get("path").toString())).addOnSuccessListener(_voice_download_success_listener).addOnFailureListener(_voice_failure_listener).addOnProgressListener(_voice_download_progress_listener);
								}
							}
							_rippleEffect(im_play);
						}
					});
				}
				else {
					l_voice.setVisibility(View.GONE);
				}
				if (lop.get((int)_position).containsKey("video")) {
					linear_message.setVisibility(View.GONE);
					tx_reply_msg.setVisibility(View.GONE);
					tx_message.setVisibility(View.GONE);
					thumbs.setVisibility(View.VISIBLE);
					thumbs.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							i.putExtra("vid", lop.get((int)_position).get("video").toString());
							i.setClass(getApplicationContext(), ImgviewActivity.class);
							startActivity(i);
							_Animasi(thumbs, "video", in);
						}
					});
					if (!lop.get((int)_position).get("message").toString().equals("")) {
						videotext.setVisibility(View.VISIBLE);
						videotext.setText(lop.get((int)_position).get("message").toString());
						_textview_mh(videotext, videotext.getText().toString());
					}
				}
				else {
					thumbs.setVisibility(View.GONE);
				}
				imageview1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						if (lop.get((int)_position).containsKey("image")) {
							page.putExtra("url", lop.get((int)_position).get("image").toString());
							page.setClass(getApplicationContext(), ImgviewActivity.class);
							startActivity(page);
						}
						else {
							
						}
					}
				});
			}catch(Exception e){
				SketchwareUtil.showMessage(getApplicationContext(), e.toString());
			}
			
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