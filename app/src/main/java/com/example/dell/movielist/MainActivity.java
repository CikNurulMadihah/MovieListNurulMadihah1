package com.example.dell.movielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Movie> MovieList;
    private FloatingActionButton fab;
    private Double ranting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, MovieList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());
    }

    private void setRecyclerViewData() {
        Movie movie = new Movie("Mad Max: Fury Road", 3.6, 1);
        MovieList.add(movie);

        movie = new Movie("Inside Out", 2.5, 2);
        MovieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", 5, 4);
        MovieList.add(movie);

        movie = new Movie("Shaun the Sheep", 6, 2);
        MovieList.add(movie);

        movie = new Movie("The Martian", 0, 4);
        MovieList.add(movie);


    }

    private View.OnClickListener onAddingListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_add); //layout for dialog
                dialog.setTitle("Add a Moviefhghghghfhgfhfgfgjghdtfdsrf");
                dialog.setCancelable(true); //none-dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                EditText title = (EditText) dialog.findViewById(R.id.title);
                EditText ranting = (EditText) dialog.findViewById(R.id.ranting);
                EditText status = (EditText) dialog.findViewById(R.id.status);
                View btnAdd = dialog.findViewById(R.id.add);


                //set handling event for 2 buttons and spinner

                btnAdd.setOnClickListener(onConfirmListener(title, ranting, status, dialog));


                dialog.show();
            }
        };
    }


    private View.OnClickListener onConfirmListener(final EditText title,final EditText ranting, final EditText status, final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double ranting1=Double.parseDouble(ranting.getText().toString());
                Integer status1=Integer.parseInt(status.getText().toString());
                Movie movie = new Movie(title.getText().toString().trim(), ranting1,status1 );

                //adding new object to arraylist
                MovieList.add(movie);

                //notify data set changed in RecyclerView adapter
                adapter.notifyDataSetChanged();

                //close dialog after all
                dialog.dismiss();
            }
        };
    }


}