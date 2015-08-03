package com.demo.totopview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Custom Top components. When using the incoming call setListOrScrollInstance
 * ScrollView / ListView reference
 */

public class ToTopView extends ImageView implements OnClickListener,
		OnScrollListener {

	private Object obj;
	private Context context;
	private boolean autoVisible;

	public ToTopView(Context context) {
		super(context);
		this.context = context;
		init(context);
	}

	public ToTopView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init(context);
	}

	public ToTopView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init(context);
	}

	public void init(Context context) {
		setImageDrawable(getResources()
				.getDrawable(R.drawable.ico_fanhuidingbu));
		setOnClickListener(this);
	}

	public Bitmap convertViewToBitmap(View view, int bitWidth, int bitHeight) {
		Bitmap bitmap = Bitmap.createBitmap(bitWidth, bitHeight,
				Bitmap.Config.ARGB_8888);
		view.draw(new Canvas(bitmap));
		return bitmap;
	}

	public void setListOrScrollInstance(Object instance) {
		obj = instance;
	}

	@Override
	public void onClick(View view) {
		if (obj != null) {
			if (obj instanceof ScrollView) {
				((ScrollView) obj).fullScroll(View.FOCUS_UP);
			} else if (obj instanceof ListView) {
				((ListView) obj).smoothScrollToPosition(0);
			}
		}

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	public void setAutoVivible(boolean pautoVisible) {
		autoVisible = pautoVisible;
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		if (autoVisible) {
			if (firstVisibleItem == 0) {
				setVisibility(View.GONE);
			} else {
				setVisibility(View.VISIBLE);
			}
		}
	}

}
