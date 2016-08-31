package com.android_wthao.activity;

import java.util.ArrayList;

import com.android_wthao.lists.Leaf.Leaf;
import com.android_wthao.lists.Leaf.LeafDao;
import com.android_wthao.lists.Leaf.TreeLeafAdapter;
import com.android_wthao.lists.Leaf.TreeLeafItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

public class ListsActivity extends Activity {
	/** 树中的元素集合 */
	private ArrayList<LeafDao> leafs;
	/** 数据源元素集合 */
	private ArrayList<LeafDao> leafData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lists);

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		leafInit();//准备数据源
		
		ListView treeview = (ListView) findViewById(R.id.lv_lists);

		TreeLeafAdapter leafAdapter = new TreeLeafAdapter(leafs, leafData,
				inflater);

		TreeLeafItemClickListener leafItemClickListener = new TreeLeafItemClickListener(leafAdapter);

		treeview.setAdapter(leafAdapter);
		treeview.setOnItemClickListener(leafItemClickListener);
	}

	private void leafInit() {
		leafs = new ArrayList<LeafDao>();
		leafData = new ArrayList<LeafDao>();

		LeafDao e1 = new LeafDao(new Leaf("衣服", "上衣", 4), LeafDao.TOP_LEVEL, 0,LeafDao.NO_PARENT, true, false);
		LeafDao e2 = new LeafDao(new Leaf("吃", "方便面", 4), LeafDao.TOP_LEVEL, 1,LeafDao.NO_PARENT, true, false);
		LeafDao e3 = new LeafDao(new Leaf("吹灯", "奇怪", 4), LeafDao.TOP_LEVEL, 2,LeafDao.NO_PARENT, true, false);
		LeafDao e4 = new LeafDao(new Leaf("上衣", "a1", 4), LeafDao.TOP_LEVEL+ 1, 3,e1.getId(), true, false);
		LeafDao e5 = new LeafDao(new Leaf("裤子", "a3", 4), LeafDao.TOP_LEVEL+ 1, 4,e1.getId(), true, false);
		LeafDao e6 = new LeafDao(new Leaf("TT", "a26542", 4), LeafDao.TOP_LEVEL+ 2,5, e4.getId(), false, false);
		LeafDao e7 = new LeafDao(new Leaf("OO", "a22", 4), LeafDao.TOP_LEVEL+ 2, 6,e4.getId(), false, false);
		LeafDao e8 = new LeafDao(new Leaf("HTC", "萌主号", 4), LeafDao.TOP_LEVEL+ 1,8, e2.getId(), false, false);
		LeafDao e9 = new LeafDao(new Leaf("方便面", "小强号", 4), LeafDao.TOP_LEVEL+ 1,7, e2.getId(), false, false);
		LeafDao e11 = new LeafDao(new Leaf("CC", "a232", 4), LeafDao.TOP_LEVEL+ 2,6, e5.getId(), false, false);
		LeafDao e12 = new LeafDao(new Leaf("DD", "a23232", 4),LeafDao.TOP_LEVEL+ 2, 6, e5.getId(), false, false);
		leafs.add(e1);
		leafs.add(e2);
		leafs.add(e3);
		leafData.add(e1);
		leafData.add(e2);
		leafData.add(e3);
		leafData.add(e4);
		leafData.add(e5);
		leafData.add(e6);
		leafData.add(e7);
		leafData.add(e8);
		leafData.add(e9);
		leafData.add(e11);
		leafData.add(e12);
	}
}
