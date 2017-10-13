package com.example.asus.lxdemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2017/9/1.
 */

public class SlideAdapter extends BaseAdapter  {
    private List<String> dataList;
    private Context context;
    private LayoutInflater inflater;
    private TextView itemTvToTop;
    private TextView itemTvNoRead;
    private TextView itemTvDelete;
    private setButtonClick msetButtonClick;

    public SlideAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View content = inflater.inflate(R.layout.adapter_item_content, null);
        TextView textView = content.findViewById(R.id.textviews);
        textView.setText(dataList.get(position));

        View menu = inflater.inflate(R.layout.adapter_item_menu, null);
        itemTvToTop = (TextView) menu.findViewById(R.id.item_to_top);
        itemTvNoRead = (TextView) menu.findViewById(R.id.item_no_read);
        itemTvDelete = (TextView) menu.findViewById(R.id.item_delete);

        SlideItem slideItem = new SlideItem(context);
        slideItem.setContentView(content, menu);

        msetButtonClick.setbuttonclick(itemTvToTop,itemTvNoRead,itemTvDelete,position);
        return slideItem;
    }

    public interface setButtonClick {
        void setbuttonclick(TextView itemTvToTop,TextView itemTvNoRead,TextView itemTvDelete,int positon);
    }

    public void ButtonClick(setButtonClick setButtonClick) {
        this.msetButtonClick = setButtonClick;
    }
}
