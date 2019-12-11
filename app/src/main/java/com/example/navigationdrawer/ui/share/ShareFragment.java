package com.example.navigationdrawer.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer.Contacts;
import com.example.navigationdrawer.ContactsAdapter;
import com.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final  TextView textView=root.findViewById(R.id.text_share);

        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
           textView.setText(s);

            }
        });
recyclerView=root.findViewById(R.id.recyclerview);

//list of contacts to dispay in recyclerview
        List<Contacts>contactsList=new ArrayList<>();
        contactsList.add(new Contacts("lake","934797558",R.drawable.lake));
        contactsList.add(new Contacts("waterfall","98464874",R.drawable.waterfall));

        ContactsAdapter contactsAdapter=new ContactsAdapter(contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return root;
    }
}