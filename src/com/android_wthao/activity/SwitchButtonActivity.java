package com.android_wthao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.android_wthao.widget.CheckSwitchButton;
import com.android_wthao.widget.SlideSwitchView;
import com.android_wthao.widget.SlideSwitchView.OnSwitchChangedListener;

public class SwitchButtonActivity extends Activity {
	private ToggleButton mTogBtn;
	private CheckSwitchButton mCheckSwithcButton;
	private CheckSwitchButton mEnableCheckSwithcButton;
	private SlideSwitchView mSlideSwitchView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_switch_button);
		findView();
	}

	private void findView() {
		// TODO Auto-generated method stub
		mTogBtn = (ToggleButton) findViewById(R.id.mTogBtn);
		mTogBtn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					//选中
				}else{
					//未选中
				}
			}
		});// 添加监听事件
		
		mCheckSwithcButton = (CheckSwitchButton)findViewById(R.id.mCheckSwithcButton);
		mEnableCheckSwithcButton = (CheckSwitchButton)findViewById(R.id.mEnableCheckSwithcButton);
		mCheckSwithcButton.setChecked(false);
		mCheckSwithcButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					mEnableCheckSwithcButton.setEnabled(false);
					mSlideSwitchView.setEnabled(false);
				}else{
					mEnableCheckSwithcButton.setEnabled(true);
					mSlideSwitchView.setEnabled(true);
				}
			}
		});
		mSlideSwitchView = (SlideSwitchView) findViewById(R.id.mSlideSwitchView);
		mSlideSwitchView.setOnChangeListener(new OnSwitchChangedListener() {
			
			@Override
			public void onSwitchChange(SlideSwitchView switchView, boolean isChecked) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
