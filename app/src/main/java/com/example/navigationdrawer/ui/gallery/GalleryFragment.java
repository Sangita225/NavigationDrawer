package com.example.navigationdrawer.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationdrawer.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    EditText etprinciple;
    EditText etrate;
    EditText ettime;
    Button btncalculate;
    TextView tvsi;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
     etprinciple = root.findViewById(R.id.etprinciple);
     ettime=root.findViewById(R.id.ettime);
     etrate=root.findViewById(R.id.etrate);
     btncalculate=root.findViewById(R.id.btncalculate);
     tvsi=root.findViewById(R.id.tvsi);

        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // etprinciple.setText(s);
               // etrate.setText(s);
              //  ettime.setText(s);

                btncalculate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        float p,t,r,si;
                        p=Float.parseFloat(etprinciple.getText().toString());
                        t=Float.parseFloat(ettime.getText().toString());
                        r=Float.parseFloat(etrate.getText().toString());
                        si=(p*t*r)/100;
                        tvsi.setText("simple intrest is:"+si);

                    }
                });

            }
        });
        return root;
    }
}