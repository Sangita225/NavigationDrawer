package com.example.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    Context mContext;
    List<Contacts>contactsList;

    public ContactsAdapter(List<Contacts>contactsList){
        this.contactsList=contactsList;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts,parent,false);
        return new ContactsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {

        Contacts contacts=contactsList.get(position);
        holder.imgview.setImageResource(contacts.getImgId());
        holder.tvName.setText(contacts.getName());
        holder.tvPhone.setText(contacts.getPhone());


    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public  class ContactsViewHolder extends RecyclerView.ViewHolder {

    ImageView imgview;
    TextView tvName,tvPhone;

    public ContactsViewHolder(@NonNull View itemView) {
        super(itemView);
        imgview=itemView.findViewById(R.id.imageView);
        tvName=itemView.findViewById(R.id.tvName);
        tvPhone=itemView.findViewById(R.id.tvPhone);
    }
}
}



