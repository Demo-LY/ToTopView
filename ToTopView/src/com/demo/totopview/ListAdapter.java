package com.demo.totopview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	private Context mContext;
	private List<DemoResponse> mList;
	private LayoutInflater mLayoutInflater;

	public ListAdapter(Context context, List<DemoResponse> list) {
		this.mContext = context;
		this.mList = list;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		if (mList != null) {
			return mList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int pos = position;
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.list_adapter_item,
					null);
			holder.adapter_tv = (TextView) convertView
					.findViewById(R.id.adpter_tv);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.adapter_tv.setText(mList.get(position).getName());
		return convertView;
	}

	class ViewHolder {
		public TextView adapter_tv;
	}

}
