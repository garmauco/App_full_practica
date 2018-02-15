package com.tresmas1r.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tresmas1r.platzigram.R;
import com.tresmas1r.platzigram.adapter.PictureAdapterRecyclerView;
import com.tresmas1r.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home),false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://novalandtours.com/images/guide/guilin.jpg", "Mauricio Garcia", "5 días", "4 Me Gusta"));
        pictures.add(new Picture("https://odis.homeaway.com/odis/listing/2dab00ec-cd29-4750-b698-bf9b18f3d673.c6.jpg", "Pedro Tapiero", "1 días", "1 Me Gusta"));
        pictures.add(new Picture("http://big5kayakchallenge.com/wp-content/uploads/2017/12/simple-church-at-corinth-background-corinth-greece-holy-land-photographs-powerpoint-church-at-corinth-background.jpg", "Carlos Perez", "3 días", "5 Me Gusta"));
        pictures.add(new Picture("https://odis.homeaway.com/odis/listing/a5284598-2822-46d1-9b35-d71672bf6b7b.c6.jpg", "Monica Garzon", "4 días", "1 Me Gusta"));
        pictures.add(new Picture("https://odis.homeaway.com/odis/listing/c3c4f51a-970e-4325-9783-827e92547c85.c6.jpg", "Andrea Torres", "7 días", "9 Me Gusta"));

        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);


    }
}
