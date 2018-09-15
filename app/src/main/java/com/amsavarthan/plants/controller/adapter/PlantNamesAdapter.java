package com.amsavarthan.plants.controller.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.amsavarthan.plants.grow.R;
import com.amsavarthan.plants.model.PlantNames;

import java.util.ArrayList;

public class PlantNamesAdapter extends RecyclerView.Adapter<PlantNamesAdapter.ViewHolder> implements Filterable {
    private ArrayList<PlantNames> mArrayList;
    private ArrayList<PlantNames> mFilteredList;

    public PlantNamesAdapter(ArrayList<PlantNames> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public PlantNamesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_plant_help, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantNamesAdapter.ViewHolder viewHolder, int i) {

        viewHolder.english.setText(mFilteredList.get(i).getEnglish());

        if(!TextUtils.isEmpty(mFilteredList.get(i).getTamil()))
            viewHolder.tamil.setText("Tamil : "+mFilteredList.get(i).getTamil());
        else
            viewHolder.tamil.setText("Tamil : N/A");

        if(!TextUtils.isEmpty(mFilteredList.get(i).getHindi()))
            viewHolder.hindi.setText("Hindi : "+mFilteredList.get(i).getHindi());
        else
            viewHolder.hindi.setText("Hindi : N/A");

        if(!TextUtils.isEmpty(mFilteredList.get(i).getKannada()))
            viewHolder.kannada.setText("Kannada : "+mFilteredList.get(i).getKannada());
        else
            viewHolder.kannada.setText("Kannada : N/A");

        if(!TextUtils.isEmpty(mFilteredList.get(i).getMalayalam()))
            viewHolder.malayalam.setText("Malayalam : "+mFilteredList.get(i).getMalayalam());
        else
            viewHolder.malayalam.setText("Malayalam : N/A");

        if(!TextUtils.isEmpty(mFilteredList.get(i).getTelugu()))
            viewHolder.telugu.setText("Telugu : "+mFilteredList.get(i).getTelugu());
        else
            viewHolder.telugu.setText("Telugu : N/A");


    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<PlantNames> filteredList = new ArrayList<>();

                    for (PlantNames name : mArrayList) {

                        if (name.getEnglish().toLowerCase().contains(charString)  || name.getTelugu().toLowerCase().contains(charString) || name.getMalayalam().toLowerCase().contains(charString) || name.getKannada().toLowerCase().contains(charString) || name.getTamil().toLowerCase().contains(charString) || name.getHindi().toLowerCase().contains(charString)) {
                            filteredList.add(name);
                        }

                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<PlantNames>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView english,tamil,hindi;
        private TextView kannada,telugu,malayalam;
        public ViewHolder(View view) {
            super(view);

            english = view.findViewById(R.id.english);
            kannada = view.findViewById(R.id.kannada);
            telugu = view.findViewById(R.id.telugu);
            tamil = view.findViewById(R.id.tamil);
            hindi = view.findViewById(R.id.hindi);
            malayalam = view.findViewById(R.id.malayalam);

        }
    }

}