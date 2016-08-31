package com.android_wthao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button b1,b2,b3,b4,b5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		Listener();
	}

	private void findView() {
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
	}

	private void Listener(){
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.button1:
			//自定义控件
			intent = new Intent(this,CustomViewActivity.class);
			startActivity(intent);
			break;
			//自定义开关
		case R.id.button2:
			intent = new Intent(this,SwitchButtonActivity.class);
			startActivity(intent);
			break;
		case R.id.button3:
			intent = new Intent(this,ListsActivity.class);
			startActivity(intent);
			break;
		case R.id.button4:
			intent = new Intent(this,TostTestActivity.class);
			startActivity(intent);
			break;
		case R.id.button5:
			intent = new Intent(this,DialogTestActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
}
