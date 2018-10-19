package com.example.dell.movielist;

/**
 * Created by DELL on 10/19/2018.
 */


import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Movie> movie;
    private Activity activity;


    public RecyclerAdapter(Activity activity, List<Movie> movie) {
        this.movie = movie;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //inflate your layout and pass it to view holder
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_recycler, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int position) {

        //setting data to view holder elements
        viewHolder.title.setText(movie.get(position).getTitle());
        NumberFormat nm = NumberFormat.getNumberInstance();
        viewHolder.ranting.setText(nm.format(movie.get(position).getRanting()));
        viewHolder.status.setText(movie.get(position).getStatus());



    }

    private void setDataToView(TextView title, TextView ranting, TextView status, int position) {
        title.setText(movie.get(position).getTitle());
        NumberFormat nm = NumberFormat.getNumberInstance();
        ranting.setText(nm.format(movie.get(position).getRanting()));
        status.setText(movie.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return (null != movie ? movie.size() : 0);
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.item_recycler);
                dialog.setTitle("Position " + position);
                dialog.setCancelable(true); // dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                TextView title = (TextView) dialog.findViewById(R.id.title);
                TextView ranting = (TextView) dialog.findViewById(R.id.ranting);
                TextView status = (TextView) dialog.findViewById(R.id.status);


                setDataToView(title, ranting, status, position);

                dialog.show();
            }
        };
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, status, ranting;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            status = (TextView) view.findViewById(R.id.status);
            ranting = (TextView) view.findViewById(R.id.ranting);
        }
    }
}