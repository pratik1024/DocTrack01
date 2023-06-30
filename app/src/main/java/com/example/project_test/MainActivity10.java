package com.example.project_test;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;
import io.github.muddz.styleabletoast.StyleableToast;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public class MainActivity10 extends AppCompatActivity {
Spinner spinner,spinner2,spinner3;
CircleImageView profile ;
FloatingActionButton changeDP ;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        spinner=findViewById(R.id.dept);
        spinner2=findViewById(R.id.qual);
        spinner3=findViewById(R.id.expr);
        button= findViewById(R.id.rgstr_btn2);
        profile = findViewById(R.id.profile_image);
        changeDP = findViewById(R.id.floatingActionButton5);

        String [] dept={"Select Dept.","Dept1","Dept2","Dept3","Dept4","Dept5","Dept6"};
        String [] qual={"Select Qual.","Qual1","Qual2","Qual3","Qual4","Qual5","Qual6"};
        String [] expr={"Select Expr.","Expr1","Expr2","Expr3","Expr4","Expr5","Expr6"};

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.dept_list,dept);
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getApplicationContext(), R.layout.dept_list,qual);
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getApplicationContext(), R.layout.dept_list,expr);


        itemAdapter.setDropDownViewResource(R.layout.dept_list);
        spinner.setAdapter(itemAdapter);
        itemAdapter.setDropDownViewResource(R.layout.dept_list);
        spinner2.setAdapter(itemAdapter2);
        itemAdapter.setDropDownViewResource(R.layout.dept_list);
        spinner3.setAdapter(itemAdapter3);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value1 = parent.getItemAtPosition(position).toString();
//                Toast.makeText(MainActivity10.this, value1, Toast.LENGTH_SHORT).show();
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
//                Toast.makeText(MainActivity10.this, value2, Toast.LENGTH_SHORT).show();
                StyleableToast.makeText(getApplicationContext(), value2, Toast.LENGTH_LONG, R.style.mytoast).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value3 = parent.getItemAtPosition(position).toString();
//                Toast.makeText(MainActivity10.this, value1, Toast.LENGTH_SHORT).show();
                StyleableToast.makeText(getApplicationContext(), value3, Toast.LENGTH_LONG, R.style.mytoast).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPtnt = new Intent(getApplicationContext(), MainActivity11.class);
                startActivity(iPtnt);
            }
        });
//        ActivityResultLauncher<Intent> launcher=
//                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),(ActivityResult result)->{
//                    if(result.getResultCode()==RESULT_OK){
//                        Uri uri=result.getData().getData();
//                        // Use the uri to load the image
//                    }else if(result.getResultCode()==ImagePicker.RESULT_ERROR){
//                        // Use ImagePicker.Companion.getError(result.getData()) to show an error
//                    }
//                });
//        changeDP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ImagePicker.Companion.with(MainActivity10.this)
//                        .crop()
//                        .cropOval()
//                        .maxResultSize(512,512,true)
//                        .provider(ImageProvider.BOTH) //Or bothCameraGallery()
//                        .createIntentFromDialog((Function1)(new Function1(){
//                            public Object invoke(Object var1){
//                                this.invoke((Intent)var1);
//                                return Unit.INSTANCE;
//                            }
//
//                            public final void invoke(@NotNull Intent it){
//                                Intrinsics.checkNotNullParameter(it,"it");
//                                launcher.launch(it);
//                            }
//                        }));
//
//            }
//        });
    }
}