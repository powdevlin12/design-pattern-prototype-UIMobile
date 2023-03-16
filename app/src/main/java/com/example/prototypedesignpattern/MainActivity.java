package com.example.prototypedesignpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prototypedesignpattern.Adapters.ComputerAdapters;
import com.example.prototypedesignpattern.Models.Computer;

public class MainActivity extends AppCompatActivity {

    ListView lvComputer;
    static ComputerAdapters computerAdapter;
    Button btnAdd, btnEdit;
    static Computer computer, computerEdit;
    static EditText edtDepartment, edtOs, edtOffice, edtBrowser, edtVirus, edtOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
        fakeData();
    }

    private void fakeData() {
        computerAdapter.add(new Computer("Win10", "Office365", "BKAV", "Chrome", "VSCode", "2A25"));
    }


    private void setControl() {
        lvComputer = findViewById(R.id.lvComputer);
        btnAdd = findViewById(R.id.btnAdd);
        edtBrowser = findViewById(R.id.browser);
        edtDepartment = findViewById(R.id.department);
        edtOffice = findViewById(R.id.office);
        edtOs = findViewById(R.id.os);
        edtVirus = findViewById(R.id.antivirus);
        edtOthers = findViewById(R.id.other);
        btnEdit = findViewById(R.id.btnEdit);
    }

    private void setEvent() {
        computerAdapter = new ComputerAdapters(MainActivity.this, R.layout.layout_item_computer);
        lvComputer.setAdapter(computerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department = edtDepartment.getText().toString();
                String os = edtOs.getText().toString();
                String office = edtOffice.getText().toString();
                String browser = edtBrowser.getText().toString();
                String virus = edtVirus.getText().toString();
                String others = edtOthers.getText().toString();

                computerAdapter.add(new Computer(os, office, virus, browser, others, department));
                reset();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editItem();
            }
        });


        lvComputer.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }

    public static void copyItem(Computer computer) {
        Computer x = computer;
        computerAdapter.add(x);
        computerAdapter.notifyDataSetChanged();
    }

    public static void copyItemDeep(Computer computer) {
        Computer x = computer.clone();
        computerAdapter.add(x);
        computerAdapter.notifyDataSetChanged();
    }

    public static void getToEditItem(Computer computer) {
        edtDepartment.setText(computer.getDepartment());
        edtBrowser.setText(computer.getBrowser());
        edtOffice.setText(computer.getOffice());
        edtOs.setText(computer.getOs());
        edtVirus.setText(computer.getAntivirus());
        edtOthers.setText(computer.getOthers());
        computerEdit = computer;

    }

    private void editItem() {
        Toast.makeText(MainActivity.this,edtOffice.getText().toString() , Toast.LENGTH_SHORT).show();
        computerEdit.setOffice(edtOffice.getText().toString());
        computerEdit.setOs(edtOs.getText().toString());
        computerEdit.setOthers(edtOthers.getText().toString());
        computerEdit.setDepartment(edtDepartment.getText().toString());
        computerEdit.setBrowser(edtBrowser.getText().toString());
        computerEdit.setAntivirus(edtVirus.getText().toString());
        reset();
        computerAdapter.notifyDataSetChanged();
    }

    private void reset() {
        edtDepartment.setText("");
        edtBrowser.setText("");
        edtOffice.setText("");
        edtOs.setText("");
        edtVirus.setText("");
        edtOthers.setText("");
    }
}