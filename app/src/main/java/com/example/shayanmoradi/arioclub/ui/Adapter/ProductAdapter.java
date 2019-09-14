package com.example.shayanmoradi.arioclub.ui.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.model.Product;
import com.example.shayanmoradi.arioclub.model.TempProduct;
import com.example.shayanmoradi.arioclub.model.offers.Offer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Product currentOffer;

    public interface OnUserAdapter {
        void onUserClicked(Offer user);
    }

    private List<TempProduct> muserList;
    private OnUserAdapter mListener;

    public ProductAdapter(OnUserAdapter listener) {
        mListener = listener;
        muserList = new ArrayList<>();
    }

    public void setItems(List<TempProduct> userLIst) {
        muserList = userLIst;
        ///we calling notfiy here and then use with observer
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_products_rv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TempProduct offer = getItem(i);
        Product product = offer.getProduct();
        viewHolder.setProductNameTv(product.getMNAme());
        viewHolder.setProductCountTv(offer.getCount()+ "");
        viewHolder.setProductTotalPriceTv(calcTotalPrice(offer.getCount(),product.getMPrice())+"");
        viewHolder.setProductCodeTv(product.getMCode() + "");
        //  viewHolder.setOnClickListener(offer);


    }

    private double calcTotalPrice(int count,double singlePrice) {
        return count*singlePrice;
    }


    private TempProduct getItem(int position) {
        return muserList.get(position);
    }

    @Override
    public int getItemCount() {
        return muserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.products_name_tv)
        TextView productNameTv;
        @BindView(R.id.products_count_tv)
        TextView productCountTv;
        @BindView(R.id.products_code_tv)
        TextView productCodeTv;
        @BindView(R.id.products_total_price_tv)
        TextView productTotalPriceTv;

//        @OnClick(R.id.offer_buy_btn)
//        void buyOffer() {
//            Offer offer = currentOffer;
//            offer.setPaientId(Authentication.getCurrentPAtient().getId());
//            OfferLab.getInstance().userBuysOffer(offer);
//
//        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setProductCodeTv(String title) {
            productCodeTv.setText(title);
        }

        public void setProductNameTv(String title) {
            productNameTv.setText(title);
        }

        public void setProductCountTv(String title) {
            productCountTv.setText(title);
        }

        public void setProductTotalPriceTv(String title) {
            productTotalPriceTv.setText(title);
        }


        public void buyOfferb(Offer incOffer) {
            Offer offer = new Offer();

            offer.setMName(incOffer.getMName());
            offer.setMPrice(incOffer.getMPrice());
            offer.setMAmount(incOffer.getMAmount());
            offer.setMDesc(incOffer.getMDesc());

            offer.setPaientId(Authentication.getCurrentPAtient().getId());

            Log.e("test", offer.getPaientId() + "");
            // Offer wtf = new Offer();
            OfferLab.getInstance().userBuysOffer(offer);

        }

        private void setOnClickListener(Offer user) {
            itemView.setTag(user);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mListener.onUserClicked((Offer) v.getTag());
        }
    }
}



