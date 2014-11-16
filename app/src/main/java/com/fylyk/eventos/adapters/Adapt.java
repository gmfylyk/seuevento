package com.fylyk.eventos.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fylyk.eventos.Eventos;
import com.fylyk.eventos.R;
import com.fylyk.eventos.ViewHolder;

import java.util.List;

/**
 * Created by gustavo on 14-11-2014.
 */
public class Adapt extends BaseAdapter {

    private final LayoutInflater inflater;
    private List<Eventos> eventos;
    private Activity ctx;

    public Adapt(List<Eventos> eventos, Activity ctx) {
        this.inflater = LayoutInflater.from(ctx);
        this.eventos = eventos;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int i) {
        return eventos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.event_item, null);
            holder = getViewHolder(view);
            view.setTag(holder);
        }

        holder = (ViewHolder) view.getTag();

        holder.txtName.setText(eventos.get(position).getName());
        holder.txtOrganizer.setText(eventos.get(position).getOrganizer());
        holder.imageView.setImageResource(eventos.get(position).getImage_url());

        return view;
    }

    private ViewHolder getViewHolder(View convertView) {

        ViewHolder holder = new ViewHolder(); //instancia um novo ViewHolder

        holder.txtName = (TextView) convertView.findViewById(R.id.eventName);
        holder.txtOrganizer = (TextView) convertView.findViewById(R.id.organizer);
        holder.imageView = (ImageView) convertView.findViewById(R.id.eventImage);

        return holder;
    }
}
