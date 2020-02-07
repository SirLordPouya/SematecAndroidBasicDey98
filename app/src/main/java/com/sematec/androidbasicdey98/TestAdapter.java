package com.sematec.androidbasicdey98;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    ArrayList<PersonClass> myList;

    TestAdapter(ArrayList<PersonClass> list) {
        myList = list;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item, parent, false);
        TestViewHolder holder = new TestViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        PersonClass person = myList.get(position);
        holder.txtName.setText(person.getName() + person.getFamily());
        holder.txtMobile.setText(person.getMobile());
        holder.imgProfile.setImageResource(person.getPic());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtMobile;
        ImageView imgProfile;

        public TestViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtMobile = itemView.findViewById(R.id.txtMobile);
            imgProfile = itemView.findViewById(R.id.imgProfile);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PersonClass person = myList.get(getAdapterPosition());

//                    Intent intent = new Intent(itemView.getContext(),MainActivity.class);
//                    intent.putExtra("id",person.getId());
//                    itemView.getContext().startActivity(intent);

                    Toast.makeText(itemView.getContext(), person.getId() + "", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
