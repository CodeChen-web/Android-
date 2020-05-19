package com.itau.jingdong.ui;

import com.itau.jingdong.R;
import com.itau.jingdong.ui.CategoryActivity.ViewHolder;
import com.itau.jingdong.ui.base.BaseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class StoreActivity extends BaseActivity {
	private ListView store_listview;
	private LayoutInflater layoutInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_store);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		store_listview=(ListView)this.findViewById(R.id.store_listview);

		store_listview.setAdapter(new CatergorAdapter());
		store_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int parent,
					long id) {
				Toast.makeText(StoreActivity.this, "你点击了第"+id+"项", 1).show();
				
			}
		});
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}
	
	private class CatergorAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImageIds.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@SuppressWarnings("null")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder=new ViewHolder();
			layoutInflater=LayoutInflater.from(StoreActivity.this);
			
			//组装数据
			if(convertView==null){
				convertView=layoutInflater.inflate(R.layout.activity_store_item, null);
				holder.image=(ImageView) convertView.findViewById(R.id.store_image);
				holder.title=(TextView) convertView.findViewById(R.id.store_title);
				holder.content=(TextView) convertView.findViewById(R.id.store_content);
				//使用tag存储数据
				convertView.setTag(holder);
			}else{
				holder=(ViewHolder) convertView.getTag();
			}
			holder.image.setImageResource(mImageIds[position]);
			holder.title.setText(mTitleValues[position]);
			holder.content.setText(mContentValues[position]);
		//	holder.title.setText(array[position]);
			
			return convertView;
		
		}
		
		
		
	}
	
	
	// 适配显示的图片数组
				private Integer[] mImageIds = {R.drawable.clothing_01,R.drawable.clothing_02,R.drawable.clothing_03,R.drawable.clothing_04,
						R.drawable.clothing_05,R.drawable.clothing_06,R.drawable.clothing_10,R.drawable.clothing_0108
						 };
				//给照片添加文字显示(Title)
				private String[] mTitleValues = { "长袖", "毛衣", "秋衣", "衬衫", "牛仔衬衫",
						"长袖", "裙子", "长袖" };
				
				private String[] mContentValues={"正常价：188/会员价：88", "正常价：188/会员价：88","正常价：188/会员价：88", "正常价：188/会员价：88", "正常价：188/会员价：88", 
						"正常价：188/会员价：88", "正常价：188/会员价：88", "正常价：188/会员价：88"};
			

		 public static class ViewHolder {
				ImageView image;
				TextView title;
				TextView content;
			}
}
