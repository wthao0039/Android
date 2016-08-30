package com.android_wthao.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View{
	private float currentX = 40;
	private float currentY = 50;
	//定义并创建画笔
	Paint p = new Paint();
	public DrawView(Context context) {
		super(context);
	}
	
	public DrawView(Context context,AttributeSet set) {
		super(context,set);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//设置画笔的颜色
		p.setColor(Color.RED);
		//绘制一个小圆
		canvas.drawCircle(currentX, currentX, 15, p);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		currentX = event.getX();
		currentY = event.getY();
		//通知当前组件重绘
		invalidate();
		//返回true表示该处理方法已经处理该事件
		return true;
	}
	
}
