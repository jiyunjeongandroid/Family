package com.example.family;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    String str_name, str_birth, str_sex, str_species;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);

        ImageButton btn_dog = findViewById (R.id.btn_dog);
        ImageButton btn_cat = findViewById (R.id.btn_cat);
        Spinner spinner_species = findViewById (R.id.spinner_species);

        btn_dog.setOnClickListener (new View.OnClickListener () { // 강아지 버튼 클릭시 강아지 종류의 스피너 보여줌
            @Override
            public void onClick(View v) {
                final ArrayAdapter<CharSequence> sAdapter = ArrayAdapter.createFromResource (Register.this, R.array.dog_species, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                spinner_species.setAdapter (sAdapter);
                spinner_species.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ((TextView) parent.getChildAt (0)).setTextColor (Color.DKGRAY);
                        str_species = parent.getItemAtPosition (position).toString ();
                        Toast.makeText (Register.this, str_species, Toast.LENGTH_SHORT).show ();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });

        btn_cat.setOnClickListener (new View.OnClickListener () { //  고양이 버튼 클릭 시 고양이 종류의 스피너 보여줌
            @Override
            public void onClick(View v) {
                final ArrayAdapter<CharSequence> sAdapter = ArrayAdapter.createFromResource (Register.this, R.array.cat_species, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                spinner_species.setAdapter (sAdapter);
                spinner_species.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ((TextView) parent.getChildAt (0)).setTextColor (Color.DKGRAY);
                        str_species = parent.getItemAtPosition (position).toString ();
                        Toast.makeText (Register.this, str_species, Toast.LENGTH_SHORT).show ();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });



        ImageButton btn_back = findViewById (R.id.btn_back);
        btn_back.setOnClickListener (new View.OnClickListener () { // 뒤로가기 버튼 클릭 시 Family화면으로 전환
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Register.this, Family.class);
                startActivity (intent);
            }
        });

        RadioGroup radioGroup = findViewById (R.id.radio_sex);
        RadioButton radio_girl = findViewById (R.id.radio_girl);
        RadioButton radio_boy = findViewById (R.id.radio_boy);
        radioGroup.setOnCheckedChangeListener (new RadioGroup.OnCheckedChangeListener () { // 라디오 그룹 버튼
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio_girl) { // girl 라디오 버튼 클릭 시
                    str_sex = "girl";
                    Toast.makeText (Register.this, str_sex, Toast.LENGTH_SHORT).show ();
                } else if(checkedId == R.id.radio_boy){ // boy 라디오 버튼 클릭 시
                    str_sex = "boy";
                    Toast.makeText (Register.this, str_sex, Toast.LENGTH_SHORT).show ();
                }
            }
        });


        Button btn_ok = findViewById (R.id.btn_ok);
        btn_ok.setOnClickListener (new View.OnClickListener () { // ok버튼 클릭 시 화면내의 입력값들을 데이터베이스에 저장
            @Override
            public void onClick(View v) {
                EditText et_name = findViewById (R.id.et_name);
                EditText et_birth = findViewById (R.id.et_birth);

                str_name = et_name.getText ().toString (); // name 입력값 받기
                str_birth = et_birth.getText ().toString (); // birth 입력값 받기

                Intent intent = new Intent (Register.this, Family.class);
                intent.putExtra ("name", str_name);
                intent.putExtra ("species", str_species);
                startActivity (intent);

            }
        });
    }
}