package com.bmpl.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    int images[];
    String data[];
    Context context;

    LayoutInflater layoutInflater;

    CustomAdapter(){}

    CustomAdapter(MainActivity mainActivity, int images[], String data[]){
        context = mainActivity;
        this.images = images;
        this.data = data;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;//no data will be displayed on the screen if the count is 0
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        view = layoutInflater.inflate(R.layout.custom_list, null);

        TextView textView = (TextView)view.findViewById(R.id.textView);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        textView.setText(data[position]);
        imageView.setImageResource(images[position]);

        return view;

    }
}
