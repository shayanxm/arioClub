package com.example.shayanmoradi.arioclub.ui.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shayanmoradi.arioclub.R;
import com.example.shayanmoradi.arioclub.controller.authentication.Authentication;
import com.example.shayanmoradi.arioclub.database.OfferLab;
import com.example.shayanmoradi.arioclub.model.offers.Offer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    Offer currentOffer;

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
        currentOffer = offer;
        viewHolder.setUserName(offer.getMName());
        viewHolder.setOfferPrice(offer.getMAmount() + "");
        viewHolder.setOnClickListener(offer);
        viewHolder.buyOfferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.buyOfferb(offer);
                Log.e("test","wod");
            }
        });


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
        @BindView(R.id.offer_buy_btn)
        Button buyOfferBtn;

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

        public void setUserName(String title) {
            offerNameTV.setText(title);
        }

        public void setOfferPrice(String title) {
            offerPriceTV.setText(title);
        }
       public void buyOfferb(Offer incOffer) {
            Offer offer = new Offer();

     offer.setMName(incOffer.getMName());
     offer.setMPrice(incOffer.getMPrice());
     offer.setMAmount(incOffer.getMAmount());
     offer.setMDesc(incOffer.getMDesc());

  offer.setPaientId(Authentication.getCurrentPAtient().getId());

           Log.e("test",offer.getPaientId()+"");
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
