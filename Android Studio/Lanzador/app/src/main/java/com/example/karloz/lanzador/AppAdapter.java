package com.example.karloz.lanzador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AppAdapter extends BaseAdapter {
    private ArrayList<App> items = new ArrayList();
    private Context context;

    public AppAdapter(Context context, ArrayList<App> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.app_lista, parent, false);
        }

        ImageView icono = (ImageView) convertView.findViewById(R.id.icono);
        TextView nombre = (TextView) convertView.findViewById(R.id.nombre);

        icono.setImageDrawable(items.get(position).getIcono());
        nombre.setText(items.get(position).getNombre());

        return convertView;
    }
}
