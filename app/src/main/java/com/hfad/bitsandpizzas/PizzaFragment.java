package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView pizzaRecycle = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycle.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycle.setLayoutManager(manager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            //Реализация метода onClick() интерфейса Listener запускает активность PizzaDetailActivity,
            //передавая ей идентификатор пиццы, выбранной пользователем.
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycle;
    }

}