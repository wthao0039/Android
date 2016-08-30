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
	}
	
	private void Listener(){
		b1.setOnClickListener(this);
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

		default:
			break;
		}
	}
}
