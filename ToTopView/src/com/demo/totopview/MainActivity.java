package com.demo.totopview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	private ToTopView top;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {
		listView = (ListView) findViewById(R.id.demo_list);
		top = (ToTopView) findViewById(R.id.list_Top);

		ArrayList<DemoResponse> list = new ArrayList<DemoResponse>();
		for (int i = 0; i < 40; i++) {
			DemoResponse response = new DemoResponse();
			response.setName("Demo" + i);
			list.add(response);
		}

		ListAdapter mAdapter = new ListAdapter(MainActivity.this, list);
		listView.setAdapter(mAdapter);

		top.setAutoVivible(true);
		listView.setOnScrollListener(top);
		top.setVisibility(View.INVISIBLE);
		top.setListOrScrollInstance(listView);

	}

}
