package com.android_wthao.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.android_wthao.widget.CustomDialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogTestActivity extends Activity{
	private Button btn_diaNormal;
	private Button btn_diaMulti;
	private Button btn_diaList;
	private Button btn_diaSinChos;
	private Button btn_diaMultiChos;
	private Button btn_diaProcess;
	private Button btn_diaReadProcess;
	private Button btn_diaCustom;
	private Button btn_popUpDia;

	ArrayList<Integer> myChose = new ArrayList<Integer>();
	// 进度读取框需要模拟读取
	ProgressDialog mReadProcessDia = null;
	public final static int MAX_READPROCESS = 100;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		findView();
		setListener();
	}

	private void findView() {
		btn_diaNormal = (Button) findViewById(R.id.btn_diaNormal);
		btn_diaMulti = (Button) findViewById(R.id.btn_diaMulti);
		btn_diaList = (Button) findViewById(R.id.btn_diaList);
		btn_diaSinChos = (Button) findViewById(R.id.btn_diaSigChos);
		btn_diaMultiChos = (Button) findViewById(R.id.btn_diaMultiChos);
		btn_diaProcess = (Button) findViewById(R.id.btn_diaProcess);
		btn_diaReadProcess = (Button) findViewById(R.id.btn_diaReadProcess);
		btn_diaCustom = (Button) findViewById(R.id.btn_diaCustom);
		btn_popUpDia = (Button) findViewById(R.id.btn_popUpDia);		
	}

	private void setListener() {
		btn_diaNormal.setOnClickListener(btnListener);
		btn_diaMulti.setOnClickListener(btnListener);
		btn_diaList.setOnClickListener(btnListener);
		btn_diaSinChos.setOnClickListener(btnListener);
		btn_diaMultiChos.setOnClickListener(btnListener);
		btn_diaProcess.setOnClickListener(btnListener);
		btn_diaReadProcess.setOnClickListener(btnListener);
		btn_diaCustom.setOnClickListener(btnListener);
		btn_popUpDia.setOnClickListener(btnListener);
	}

	private Button.OnClickListener btnListener = new Button.OnClickListener() {
		public void onClick(View v) {
			if (v instanceof Button) {
				int btnId = v.getId();
				switch (btnId) {
				case R.id.btn_diaNormal:
					showNormalDia();
					break;
				case R.id.btn_diaMulti:
					showMultiDia();
					break;
				case R.id.btn_diaList:
					showListDia();
					break;
				case R.id.btn_diaSigChos:
					showSinChosDia();
					break;
				case R.id.btn_diaMultiChos:
					showMultiChosDia();
					break;
				case R.id.btn_diaReadProcess:
					showReadProcess();
					break;
				case R.id.btn_diaProcess:
					showProcessDia();
					break;
				case R.id.btn_diaCustom:
					showCustomDia();
					break;
				case R.id.btn_popUpDia:
					showCusPopUp();
					break;
				default:
					break;
				}
			}
		}
	};

	/* 普通的对话框 */
	private void showNormalDia() {
		AlertDialog.Builder normalDia = new AlertDialog.Builder(DialogTestActivity.this);
		normalDia.setIcon(R.drawable.ic_launcher);
		normalDia.setTitle("普通的对话框");
		normalDia.setMessage("普通对话框的message内容");

		normalDia.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				showClickMessage("确定");
			}
		});
		normalDia.setNegativeButton("取消",
				new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				showClickMessage("取消");
			}
		});
		normalDia.create().show();
	}

	/* 多按钮对话框 */
	private void showMultiDia() {
		AlertDialog.Builder multiDia = new AlertDialog.Builder(DialogTestActivity.this);
		multiDia.setTitle("多选项对话框");
		multiDia.setPositiveButton("按钮一",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showClickMessage("按钮一");
			}
		});
		multiDia.setNeutralButton("按钮二", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showClickMessage("按钮二");
			}
		});
		multiDia.setNegativeButton("按钮三",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				showClickMessage("按钮三");
			}
		});
		multiDia.create().show();
	}

	/* 列表对话框 */
	private void showListDia() {
		final String[] mList = { "选项1", "选项2", "选项3", "选项4", "选项5", "选项6",
		"选项7" };
		AlertDialog.Builder listDia = new AlertDialog.Builder(DialogTestActivity.this);
		listDia.setTitle("列表对话框");
		listDia.setItems(mList, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				/* 下标是从0开始的 */
				showClickMessage(mList[which]);
			}
		});
		listDia.create().show();
	}

	/* 单项选择对话框 */
	int yourChose = -1;

	private void showSinChosDia() {
		final String[] mList = { "选项1", "选项2", "选项3", "选项4", "选项5", "选项6",
		"选项7" };
		yourChose = -1;
		AlertDialog.Builder sinChosDia = new AlertDialog.Builder(DialogTestActivity.this);
		sinChosDia.setTitle("单项选择对话框");
		sinChosDia.setSingleChoiceItems(mList, 0,
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				yourChose = which;

			}
		});
		sinChosDia.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (yourChose != -1) {
					showClickMessage(mList[yourChose]);
				}
			}
		});
		sinChosDia.create().show();
	}

	private void showMultiChosDia() {
		final String[] mList = { "选项1", "选项2", "选项3", "选项4", "选项5", "选项6",
		"选项7" };
		final boolean mChoseSts[] = { false, false, false, false, false, false,
				false };
		myChose.clear();
		AlertDialog.Builder multiChosDia = new AlertDialog.Builder(DialogTestActivity.this);
		multiChosDia.setTitle("多项选择对话框");
		multiChosDia.setMultiChoiceItems(mList, mChoseSts,
				new DialogInterface.OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which,
					boolean isChecked) {
				if (isChecked) {
					myChose.add(which);
				} else {
					myChose.remove(which);
				}
			}
		});
		multiChosDia.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				int size = myChose.size();
				String str = "";
				for (int i = 0; i < size; i++) {
					str += mList[myChose.get(i)];
				}
				showClickMessage(str);
			}
		});
		multiChosDia.create().show();
	}
	
	private void showReadProcess() {
		mReadProcessDia = new ProgressDialog(DialogTestActivity.this);
		mReadProcessDia.setProgress(0);
		mReadProcessDia.setTitle("进度条窗口");
		mReadProcessDia.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mReadProcessDia.setMax(MAX_READPROCESS);
		mReadProcessDia.show();
		new Thread(new Runnable() {
			// 新开启一个线程，循环的累加，一直到100然后在停止
			@Override
			public void run() {
				int Progress = 0;
				while (Progress < MAX_READPROCESS) {
					try {
						Thread.sleep(100);
						Progress++;
						mReadProcessDia.incrementProgressBy(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// 读取完了以后窗口自消失
				mReadProcessDia.cancel();				
			}
		}).start();
	}

	/* 读取中的对话框 */
	private void showProcessDia() {
		ProgressDialog processDia = new ProgressDialog(DialogTestActivity.this);
		processDia.setTitle("进度条框");
		processDia.setMessage("内容读取中...");
		processDia.setIndeterminate(true);
		processDia.setCancelable(true);
		processDia.show();
	}
	
	/* 自定义对话框 */
	private void showCustomDia() {
		AlertDialog.Builder customDia = new AlertDialog.Builder(DialogTestActivity.this);
		LayoutInflater inflater= LayoutInflater.from(getApplicationContext());
		
		
		
		final View viewDia = inflater.inflate(R.layout.custom_dialog, null);
		customDia.setTitle("自定义对话框");
		customDia.setView(viewDia);
		customDia.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						EditText diaInput = (EditText) viewDia.findViewById(R.id.username_value);
						showClickMessage(diaInput.getText().toString());
					}
				});
		customDia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		customDia.create().show();
	}
	
	private void showCusPopUp(){
		CustomDialogs.Builder dialog = new CustomDialogs.Builder(this);
		dialog.setTitle("提示");
		dialog.setMessage("这是个提示！");
		dialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.create().show();
	}
	
	/* 显示点击的内容 */
	private void showClickMessage(String message) {
		Toast.makeText(DialogTestActivity.this, "你选择的是: " + message,Toast.LENGTH_SHORT).show();
	}

}
