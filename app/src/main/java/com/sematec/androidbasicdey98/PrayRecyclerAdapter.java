package com.sematec.androidbasicdey98;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PrayRecyclerAdapter extends RecyclerView.Adapter<PrayRecyclerAdapter.PrayRecyclerHolder> {
    List<String> list;

    PrayRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PrayRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pray_recycler_item, parent, false);
        return new PrayRecyclerHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PrayRecyclerHolder holder, int position) {
        holder.txtTime.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PrayRecyclerHolder extends RecyclerView.ViewHolder {

        TextView txtTime;

        public PrayRecyclerHolder(@NonNull View itemView) {
            super(itemView);
            txtTime = itemView.findViewById(R.id.txtTime);
        }
    }
}
