package com.example.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<ProductModel> mData;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public RecyclerViewAdapter(Context mContext, List<ProductModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
       LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
       view = inflater.inflate( R.layout.product_row_items,parent,false );

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String imageUrl = mData.get( position ).getImgUrl();
        holder.productName.setText( mData.get( position ).getProductName() );
        holder.productCategory.setText( mData.get( position ).getProductCategory() );
        holder.tagPrice.setText( mData.get( position ).getTagPrice() );
        holder.salePrice.setText( mData.get( position ).getSalePrice() );
        holder.brand.setText( mData.get( position ).getBrand() );

        Picasso.with( mContext )
                .load( imageUrl )
                .fit()
                .placeholder( R.drawable.vegetables )
                .into( holder.productImage );

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView productImage;
        TextView productName, productCategory, tagPrice, salePrice, brand;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            productImage = itemView.findViewById( R.id.imageViewId );
            productName = itemView.findViewById( R.id.productName   );
            productCategory = itemView.findViewById( R.id.category );
            tagPrice = itemView.findViewById( R.id.tagPrice);
            salePrice = itemView.findViewById( R.id.salePrice );
            brand = itemView.findViewById( R.id.brand );


            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick( position );
                        }
                    }
                }
            } );
        }
    }



}
