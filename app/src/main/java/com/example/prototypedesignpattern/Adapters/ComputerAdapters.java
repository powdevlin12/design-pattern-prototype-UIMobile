package com.example.prototypedesignpattern.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prototypedesignpattern.MainActivity;
import com.example.prototypedesignpattern.Models.Computer;
import com.example.prototypedesignpattern.R;

public class ComputerAdapters extends ArrayAdapter<Computer> {
    private Activity context;
    private int resource;

    public ComputerAdapters(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater(); // nap layout vao bo nho
        View CustomView = inflater.inflate(this.resource, null);// resource thuc la ra item layout.xml

        TextView txtDepartment = CustomView.findViewById(R.id.txtDepartment);
        TextView txtVirus = CustomView.findViewById(R.id.txtVirus);
        TextView txtOffice = CustomView.findViewById(R.id.txtOffice);
        TextView txtOs = CustomView.findViewById(R.id.txtOs);
        TextView txtBrowser = CustomView.findViewById(R.id.txtBrowser);
        TextView txtOthers = CustomView.findViewById(R.id.txtOthers);
        ImageButton btnCopy = CustomView.findViewById(R.id.btnCopy);
        ImageButton btnEdit = CustomView.findViewById(R.id.btnEdit);
        ImageButton btnCopyDeep = CustomView.findViewById(R.id.btnCopyDeep);

        Computer computer = getItem(position);

        txtDepartment.setText(computer.getDepartment());
        txtBrowser.setText(computer.getBrowser());
        txtVirus.setText(computer.getAntivirus());
        txtOffice.setText(computer.getOffice());
        txtOs.setText(computer.getOs());
        txtOthers.setText(computer.getOthers());

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.copyItem(computer);
            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getToEditItem(computer);
            }
        });

        btnCopyDeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.copyItemDeep(computer);
            }
        });

        return CustomView;
    }
}
