package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PastaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta, container, false);
        final String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        final int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageRecourseId();
        }

        CaptionedImagesAdapter pastaAdapter = new CaptionedImagesAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(pastaAdapter);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        pastaRecycler.setLayoutManager(manager);

        pastaAdapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position);
                getActivity().startActivity(intent);
            }
        });


        return pastaRecycler;
    }
}