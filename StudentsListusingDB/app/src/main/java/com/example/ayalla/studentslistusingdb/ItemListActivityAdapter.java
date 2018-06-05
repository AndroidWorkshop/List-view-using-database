package com.example.ayalla.studentslistusingdb;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemListActivityAdapter extends RecyclerView.Adapter<ItemListActivityAdapter.ItemViewHolder> {

    public List<Item> namesList;

    public ItemListActivityAdapter(List<Item> names) {
        this.namesList = names;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_name, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = namesList.get(position);
        holder.nameView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.nameView = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
