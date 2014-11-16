package com.fylyk.eventos.adapters;

import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidviewhover.BlurLayout;
import com.fylyk.eventos.Eventos;
import com.fylyk.eventos.R;
import com.fylyk.eventos.ViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by gustavo on 15-11-2014.
 */
public class InvitesAdapter extends BaseAdapter{

    private final LayoutInflater inflater;
    private List<Eventos> eventos;
    private Activity ctx;

    public InvitesAdapter(List<Eventos> convites, Activity ctx) {
        this.inflater = LayoutInflater.from(ctx);
        this.eventos = convites;
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
            view = inflater.inflate(R.layout.invite_item, null);
            holder = getViewHolder(view);
            view.setTag(holder);
        }

        holder = (ViewHolder) view.getTag();

        holder.txtName.setText(eventos.get(position).getName());
        holder.txtPlace.setText(eventos.get(position).getPlace());
        holder.date.setText(formatDate(eventos.get(position).getDate()));
        holder.imageView.setImageResource(eventos.get(position).getImage_thumb());

        BlurLayout blurLayout = (BlurLayout)view.findViewById(R.id.blurImage);
        View hover = inflater.inflate(R.layout.blur_event_item,null);
        blurLayout.setHoverView(hover);

        blurLayout.addChildAppearAnimator(hover,R.id.accept, Techniques.FlipInX);
        blurLayout.addChildAppearAnimator(hover,R.id.reject, Techniques.FlipInX);
        blurLayout.addChildDisappearAnimator(hover,R.id.accept, Techniques.FlipOutX);
        blurLayout.addChildDisappearAnimator(hover,R.id.reject, Techniques.FlipOutX);

        return view;
    }

    public static String formatDate(DatePicker dp){

        String date = dp.getDayOfMonth() + "/" + dp.getMonth();

        Date d = new Date(dp.getDayOfMonth(),dp.getMonth(),dp.getYear());

        String dow = new SimpleDateFormat("EE").format(d).toUpperCase();

        date = dow + " " + date;

        return date;
    }

    private ViewHolder getViewHolder(View convertView) {

        ViewHolder holder = new ViewHolder(); //instancia um novo ViewHolder

        holder.txtName = (TextView) convertView.findViewById(R.id.iEventName);
        holder.txtPlace = (TextView) convertView.findViewById(R.id.iEventPlace);
        holder.date = (TextView) convertView.findViewById(R.id.iEventDate);
        holder.imageView = (ImageView) convertView.findViewById(R.id.iEventImage);

        return holder;
    }
}
