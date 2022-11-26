package br.com.up.ruokAdmin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.up.ruokAdmin.R;
import br.com.up.ruokAdmin.model.Humor;

public class HumorAdapter extends
        RecyclerView.Adapter<HumorAdapter.HumorViewHolder> {

    private ArrayList<Humor> mood;
    public HumorAdapter(ArrayList<Humor> humores){
        this.mood = humores;
    }

    @NonNull
    @Override
    public HumorViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater
                .from(parent.getContext());

        View layout = inflater.inflate(
                R.layout.view_item_humor,
                parent,
                false
                );

        return new HumorViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HumorViewHolder holder,
                                 int position) {
        Humor gift = mood.get(position);

        TextView textViewId = holder.itemView
                .findViewById(R.id.text_humor_person_id);

        TextView textViewData = holder.itemView
                .findViewById(R.id.text_data);

        TextView textViewHumor = holder.itemView
                .findViewById(R.id.text_humor_nota);

        textViewId.setText(gift.getId());
        textViewData.setText(gift.getData());
        textViewHumor.setText(gift.getHumores());

    }

    @Override
    public int getItemCount() {
        return mood.size();
    }

    public static class HumorViewHolder extends
            RecyclerView.ViewHolder{
        public HumorViewHolder(View view){
            super(view);
        }
    }
}
