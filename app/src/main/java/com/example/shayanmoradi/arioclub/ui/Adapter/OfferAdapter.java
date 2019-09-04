package com.example.shayanmoradi.arioclub.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.model.offers.Offer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    public interface OnUserAdapter {
        void onUserClicked(Offer user);
    }

    private List<Offer> muserList;
    private OnUserAdapter mListener;

    public OfferAdapter(OnUserAdapter listener) {
        mListener = listener;
        muserList = new ArrayList<>();
    }

    public void setItems(List<Offer> userLIst) {
        muserList = userLIst;
        ///we calling notfiy here and then use with observer
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_offer_rv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Offer offer = getItem(i);
        viewHolder.setUserName(offer.getMName());
        viewHolder.setOfferPrice(offer.getMAmount()+"");
        viewHolder.setOnClickListener(offer);
    }

    private Offer getItem(int position) {
        return muserList.get(position);
    }

    @Override
    public int getItemCount() {
        return muserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.offer_name)
        TextView offerNameTV;
        @BindView(R.id.offer_price)
        TextView offerPriceTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setUserName(String title) {
            offerNameTV.setText(title);
        }
        public void setOfferPrice(String title) {
            offerPriceTV.setText(title);
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
