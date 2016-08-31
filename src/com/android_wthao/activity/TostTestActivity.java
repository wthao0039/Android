package com.android_wthao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TostTestActivity extends Activity implements OnClickListener{
	private Button b1,b2,b3,b4,b5;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast);
		findView();
		Listener();
	}


	private void findView() {
		b1 = (Button) findViewById(R.id.bt1_toast);
		b2 = (Button) findViewById(R.id.bt2_toast);
		b3 = (Button) findViewById(R.id.bt3_toast);
		b4 = (Button) findViewById(R.id.bt4_toast);
		b5 = (Button) findViewById(R.id.bt5_toast);
	}


	private void Listener() {
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		Toast toast = null;
		switch (v.getId()) {
		case R.id.bt1_toast:
			Toast.makeText(getApplicationContext(), "默认Toast样式",Toast.LENGTH_SHORT).show();
			break;
		case R.id.bt2_toast:
			toast = Toast.makeText(getApplicationContext(), "自定义位置Toast",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			break;
		case R.id.bt3_toast:
			toast = Toast.makeText(getApplicationContext(), "带图片的Toast",Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			LinearLayout toastView = (LinearLayout) toast.getView();
			ImageView imageCodeProject = new ImageView(getApplicationContext());
			imageCodeProject.setImageResource(R.drawable.tu5503_4);
			toastView.addView(imageCodeProject, 0);
			toast.show();
			break;
		case R.id.bt4_toast:
			LayoutInflater inflater = getLayoutInflater();
			View layout = inflater.inflate(R.layout.custom,(ViewGroup) findViewById(R.id.llToast));
			ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
			image.setImageResource(R.drawable.tu5503_5);
			TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
			title.setText("Attention");
			TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
			text.setText("完全自定义Toast");
			toast = new Toast(getApplicationContext());
			toast.setGravity(Gravity.RIGHT | Gravity.TOP, 12, 40);
			toast.setDuration(Toast.LENGTH_LONG);
			toast.setView(layout);
			toast.show();
			break;
		case R.id.bt5_toast:
			new Thread(new Runnable() {
				public void run() {
					showToast();
				}
			}).start();
			break;

		default:
			break;
		}
	}

	public void showToast() {
		handler.post(new Runnable() {

			@Override
			public void run() {
				Toast.makeText(getApplicationContext(), "我来自其他线程！",Toast.LENGTH_SHORT).show();
			}
		});
	}
}
