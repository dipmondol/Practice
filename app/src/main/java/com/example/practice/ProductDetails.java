package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.practice.MainActivity.extra_brand;
import static com.example.practice.MainActivity.extra_category;
import static com.example.practice.MainActivity.extra_description;
import static com.example.practice.MainActivity.extra_name;
import static com.example.practice.MainActivity.extra_sale;
import static com.example.practice.MainActivity.extra_tag;
import static com.example.practice.MainActivity.extra_url;


public class ProductDetails extends AppCompatActivity {
    ImageView imageView;
    TextView productName, productCategory, tagPrice, salePrice, productBrand, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_product_details );

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra( extra_url );
        String name = intent.getStringExtra( extra_name );
        String category = intent.getStringExtra( extra_category );
        String tag = intent.getStringExtra( extra_tag );
        String price = intent.getStringExtra( extra_sale );
        String brand = intent.getStringExtra( extra_brand );
        String product_description = intent.getStringExtra( extra_description );







        imageView = findViewById( R.id.detailsProductImage );
        productName = findViewById( R.id.detailsProductName );
        productCategory = findViewById( R.id.detailsProducCategory );
        tagPrice = findViewById( R.id.detailsTagPrice );
        salePrice = findViewById( R.id.detailsSalePrice );
        productBrand = findViewById( R.id.detailsBrand);
        description = findViewById( R.id.detailsDescription );

        Picasso.with( this )
                .load( imageUrl )
                .fit()
                .placeholder( R.drawable.vegetables)
                .into( imageView );

        productName.setText( name );
        productCategory.setText( "Category: "+ category );
        tagPrice.setText( "Tag Price: "+tag );
        salePrice.setText( "Sale Price: "+price );
        productBrand.setText( "Brand: "+brand );
        description.setText( product_description );



    }
}