package com.amsavarthan.plants.grow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.amsavarthan.plants.controller.adapter.PlantNamesAdapter;
import com.amsavarthan.plants.grow.R;
import com.amsavarthan.plants.model.PlantNames;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HerbalPlantsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    PlantNamesAdapter adapter;
    private ArrayList<PlantNames> mArrayList=new ArrayList<>();
    EditText search;


    public HerbalPlantsFragment(){

    }


    private void getDatafromJSON(String json) {

        try {
            JSONObject jsonObj = new JSONObject(json);

            JSONArray data = jsonObj.getJSONArray("names");


            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                String English=c.getString("English");
                String Malayalam=c.getString("Malayalam");
                String Hindi=c.getString("Hindi");
                String Tamil=c.getString("Tamil");

                PlantNames plantNames=new PlantNames();
                plantNames.setEnglish(English);
                plantNames.setMalayalam(Malayalam);
                plantNames.setHindi(Hindi);
                plantNames.setTamil(Tamil);
                plantNames.setTelugu("");
                plantNames.setKannada("");
                mArrayList.add(plantNames);
                adapter.notifyDataSetChanged();

            }
        } catch (final JSONException e) {
            Log.e("Error", "Json parsing error: " + e.getMessage());
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_help, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        search=view.findViewById(R.id.search);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlantNamesAdapter(mArrayList);
        recyclerView.setAdapter(adapter);

        getDatafromJSON(loadJSONFromAsset("herbal_plants"));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    public String loadJSONFromAsset(String type) {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open(type+".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}
