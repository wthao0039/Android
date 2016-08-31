package com.android_wthao.lists.Leaf;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android_wthao.activity.R;

public class TreeLeafAdapter extends BaseAdapter {

	/** 元素数据源 */
	private ArrayList<LeafDao> elementsData;
	/** 树中元素 */
	private ArrayList<LeafDao> elements;
	/** LayoutInflater */
	private LayoutInflater inflater;
	/** item的行首缩进基数 */
	private int indentionBase;

	public TreeLeafAdapter(ArrayList<LeafDao> elements,
			ArrayList<LeafDao> elementsData, LayoutInflater inflater) {
		this.elements = elements;
		this.elementsData = elementsData;
		this.inflater = inflater;
		indentionBase = 50;
	}

	public ArrayList<LeafDao> getElements() {
		return elements;
	}

	public ArrayList<LeafDao> getElementsData() {
		return elementsData;
	}

	@Override
	public int getCount() {
		return elements.size();
	}

	@Override
	public Object getItem(int position) {
		return elements.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.treeleaf_item, null);
			holder.disclosureImg = (ImageView) convertView
					.findViewById(R.id.disclosureImg);
			holder.contentName = (TextView) convertView
					.findViewById(R.id.contentName);
			holder.contentText = (TextView) convertView
					.findViewById(R.id.contentText);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		LeafDao element = elements.get(position);
		int level = element.getLevel();
		holder.disclosureImg.setPadding(indentionBase * (level + 1),
				holder.disclosureImg.getPaddingTop(),
				holder.disclosureImg.getPaddingRight(),
				holder.disclosureImg.getPaddingBottom());
		holder.contentName.setText(element.getContentText().getName());
		holder.contentText.setText(element.getContentText().getText());
		if (element.isHasChildren() && !element.isExpanded()) {
			holder.disclosureImg.setImageResource(R.drawable.close);
			// 这里要主动设置一下icon可见，因为convertView有可能是重用了"设置了不可见"的view，下同。
			holder.disclosureImg.setVisibility(View.VISIBLE);
		} else if (element.isHasChildren() && element.isExpanded()) {
			holder.disclosureImg.setImageResource(R.drawable.open);
			holder.disclosureImg.setVisibility(View.VISIBLE);
		} else if (!element.isHasChildren()) {
			holder.disclosureImg.setImageResource(R.drawable.close);
			holder.disclosureImg.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}

	static class ViewHolder {
		ImageView disclosureImg;
		TextView contentText;
		TextView contentName;
	}
}
