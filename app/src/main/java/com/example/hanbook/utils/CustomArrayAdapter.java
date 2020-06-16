package com.example.hanbook.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanbook.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomArrayAdapter extends ArrayAdapter<ListItemClass> {

    private LayoutInflater inflater;
    private List<ListItemClass> listItem = new ArrayList<>();
    private Context context;

    public CustomArrayAdapter(@NonNull Context context, int resource, List<ListItemClass> listItem,LayoutInflater inflater) {
        super(context, resource,listItem);
        this.inflater = inflater;
        this.listItem = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        ListItemClass listItemMain = listItem.get(position);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_item_1, null, false);
            viewHolder = new ViewHolder();
            viewHolder.image = convertView.findViewById(R.id.imageViewItem);
            viewHolder.name = convertView.findViewById(R.id.textViewName);
            viewHolder.engName = convertView.findViewById(R.id.textViewEngName);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(listItemMain.getCityName());
        viewHolder.engName.setText(listItemMain.getEng_name());
        viewHolder.image.setImageResource(listItemMain.image_id);
        return convertView;
    }
    private class ViewHolder{
        TextView name;
        TextView engName;
        ImageView image;
    }
}
