package com.lzy.imagepicker.day17_search_editext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liuwangping on 2017/8/6.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public ListViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder myHolder;
        if(convertView==null) {
            myHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_item,null);
            myHolder.text= (TextView) convertView.findViewById(R.id.list_item_text);
            convertView.setTag(myHolder);
        }else {
            myHolder= (ViewHolder) convertView.getTag();
        }
        myHolder.text.setText(list.get(position));
        return convertView;
    }

    class  ViewHolder {
        private TextView text;
    }
}
