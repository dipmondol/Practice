package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener  {

    public static final String extra_url = "productImage";
    public static final String extra_name = "productName";
    public static final String extra_category = "productCategory";
    public static final String extra_tag = "tagPrice";
    public static final String extra_sale = "salePrice";
    public static final String extra_brand = "brand";
    public static final String extra_description= "description";


    RecyclerView recyclerView;
    RequestQueue requestQueue;
    JsonArrayRequest arrayRequest;
    List<ProductModel> productModelList;

    private static final String url = "https://samabaybazar.cccul.com/api/products?fbclid=IwAR08QE42Uz8PFRJzT8wAqnjhs6uOBkJe6MhCVVbh1FrEPs1Lt5sVeJQN1Xc";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        productModelList = new ArrayList<>();
        recyclerView = findViewById( R.id.recyclerViewId );

        fetchData();
    }

    private void fetchData() {

    arrayRequest = new JsonArrayRequest( url, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            JSONObject jsonObject = null;
            for(int i= 0; i<response.length();i++){

                try{
                    jsonObject = response.getJSONObject( i );
                    ProductModel productModel = new ProductModel();
                    productModel.setProductName( jsonObject.getString( "product_name" ) );
                    productModel.setProductCategory( jsonObject.getString( "category_name" ) );
                    productModel.setTagPrice( jsonObject.getString( "tag_price" ) );
                    productModel.setSalePrice( jsonObject.getString( "sale_price" ) );
                    productModel.setBrand( jsonObject.getString( "brand_name" ) );
                    productModel.setImgUrl( jsonObject.getString( "product_image" ) );
                    productModel.setDescription( jsonObject.getString( "product_long_description" ) );

                    productModelList.add( productModel );

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            setUpRecyclerView(productModelList);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    } );

    requestQueue = Volley.newRequestQueue( MainActivity.this );
    requestQueue.add( arrayRequest );
    }

    private void setUpRecyclerView(List<ProductModel> productModelList) {
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter( this,productModelList);
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setHasFixedSize( true );
        recyclerView.setAdapter( myAdapter );

        myAdapter.setOnItemClickListener( MainActivity.this );


    }


    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this,ProductDetails.class);
        ProductModel clickedItem = productModelList.get( position );

        detailIntent.putExtra( extra_url,clickedItem.getImgUrl() );
        detailIntent.putExtra( extra_name,clickedItem.getProductName() );
        detailIntent.putExtra( extra_category,clickedItem.getProductCategory() );
        detailIntent.putExtra( extra_tag,clickedItem.getTagPrice() );
        detailIntent.putExtra( extra_sale,clickedItem.getSalePrice() );
        detailIntent.putExtra( extra_brand,clickedItem.getBrand() );
        detailIntent.putExtra( extra_description,clickedItem.getDescription() );

        startActivity( detailIntent );

    }
}