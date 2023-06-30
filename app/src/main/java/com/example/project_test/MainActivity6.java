package com.example.project_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import io.github.muddz.styleabletoast.StyleableToast;


public class MainActivity6 extends AppCompatActivity {
// AutoCompleteTextView autoCompleteTextView,autoCompleteTextView2;
// TextInputLayout textInputLayout,textInputLayout2;
    Spinner spinner1,spinner2;
 Button rgstr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        spinner1 = findViewById(R.id.dept);
        spinner2 = findViewById(R.id.doct);


//        textInputLayout =findViewById(R.id.til_dept);
//        autoCompleteTextView = findViewById(R.id.act_dept);
//        textInputLayout2 =findViewById(R.id.til_doct);
//        autoCompleteTextView2 = findViewById(R.id.act_doct);
        String [] dept={"Select Dept.","Medicine","Dept2","Dept3","Dept4","Dept5","Dept6"};
        String [] doct={"Select Doct.","Pratik","Doct2","Doct3","Doct4","Doct5","Doct6"};
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.dept_list,dept);
//        autoCompleteTextView.setAdapter(itemAdapter);
//        autoCompleteTextView.setThreshold(1);
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getApplicationContext(),R.layout.dept_list,doct);
//        autoCompleteTextView2.setAdapter(itemAdapter2);
//        autoCompleteTextView2.setThreshold(1);
//        autoCompleteTextView.setOnClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?>parent, View view, int position,long id){}
//
//        });
        itemAdapter.setDropDownViewResource(R.layout.dept_list);
        spinner1.setAdapter(itemAdapter);
itemAdapter2.setDropDownViewResource(R.layout.dept_list);
spinner2.setAdapter(itemAdapter2);

spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value1 = parent.getItemAtPosition(position).toString();
//        Toast.makeText(MainActivity6.this, value1, Toast.LENGTH_SHORT).show();
        StyleableToast.makeText(getApplicationContext(), value1, Toast.LENGTH_LONG, R.style.mytoast).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value2 = parent.getItemAtPosition(position).toString();
//        Toast.makeText(MainActivity6.this, value2, Toast.LENGTH_SHORT).show();
        StyleableToast.makeText(getApplicationContext(), value2, Toast.LENGTH_LONG, R.style.mytoast).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});


        rgstr = findViewById(R.id.rgstr_btn);
        rgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                showBookedDialog();
                Intent iPtnt = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(iPtnt);
            }
        });

    }
    private void showBookedDialog(){
        ConstraintLayout boookedlayout = findViewById(R.id.bookedDialog);
        View view= LayoutInflater.from(MainActivity6.this).inflate(R.layout.success_dialog,boookedlayout);
        Button done=view.findViewById(R.id.done);

        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        done.findViewById(R.id.done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
//                Intent iPtnt = new Intent(getApplicationContext(), MainActivity3.class);
//                startActivity(iPtnt);
                Toast.makeText(MainActivity6.this, "Login your Account", Toast.LENGTH_SHORT).show();
            }
        });
        if ( alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}