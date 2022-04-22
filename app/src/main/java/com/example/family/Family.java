package com.example.family;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Family extends AppCompatActivity {
    private String name, species;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_family);

        Intent getIntent = getIntent ();
        name = getIntent.getStringExtra ("name"); // 이름 출력
        species = getIntent.getStringExtra ("species");
        Log.v ("what", "is" + name);
        Log.v ("what", "is" + species);

        TextView tv_name = findViewById (R.id.tv_name);
        tv_name.setText (name);

        ImageView img_species = findViewById (R.id.img_species); // 종류에 맞는 이미지
        switch (species) {
            // 강아지 종류
            case  "Akita" :
                img_species.setImageResource (R.drawable.ic_akitaxml);
                break;
            case "Corgi" :
                img_species.setImageResource (R.drawable.ic_corgixml);
                break;
            case "Chow Chow" :
                img_species.setImageResource (R.drawable.ic_chowchowxml);
                break;
            case "Dachshund" :
                img_species.setImageResource (R.drawable.ic_dachshundxml);
                break;
            case "Dalmatian" :
                img_species.setImageResource (R.drawable.ic_dalmatianxml);
                break;
            case "Miniature Schnauzer" :
                img_species.setImageResource (R.drawable.ic_miniatureschnauzerxml);
                break;
            case "Pomeranian" :
                img_species.setImageResource (R.drawable.ic_pomeranianxml);
                break;
            case "Poodle" :
                img_species.setImageResource (R.drawable.ic_poodlexml);
                break;
            case "Siberian Husky" :
                img_species.setImageResource (R.drawable.ic_siberianhuskyxml);
                break;
                //  고양이 종류
            case "Abyssinian" :
                img_species.setImageResource (R.drawable.ic_abyssinianxml);
                break;
            case "Birman" :
                img_species.setImageResource (R.drawable.ic_birmanxml);
                break;
            case "British Shorthair" :
                img_species.setImageResource (R.drawable.ic_britishshorthairxml);
                break;
            case "Japanese Bobtail" :
                img_species.setImageResource (R.drawable.ic_japanesebobtailxml);
                break;
            case "Oriental" :
                img_species.setImageResource (R.drawable.ic_orientalxml);
                break;
            case "Persian" :
                img_species.setImageResource (R.drawable.ic_persianxml);
                break;
            case "Scottish Fold" :
                img_species.setImageResource (R.drawable.ic_scottishfoldxml);
                break;
            case "Shorthair" :
                img_species.setImageResource (R.drawable.ic_shorthairxml);
                break;
            case "Siamese" :
                img_species.setImageResource (R.drawable.ic_siamesexml);
                break;
            case "Snowshoe" :
                img_species.setImageResource (R.drawable.ic_snowshoexml);
                break;


        }
    }
}