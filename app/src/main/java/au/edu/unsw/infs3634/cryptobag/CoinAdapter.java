package au.edu.unsw.infs3634.cryptobag;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import au.edu.unsw.infs3634.cryptobag.entities.Coin;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinViewHolder> {
    private MainActivity mParentActivity;
    private List<Coin> mCoins;
    private boolean mTwoPane;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Coin coin = (Coin) v.getTag();
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(DetailFragment.ARG_ITEM_ID, coin.getId());
                DetailFragment fragment = new DetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailFragment.ARG_ITEM_ID, coin.getId());
                context.startActivity(intent);
            }
        }
    };

    public CoinAdapter(MainActivity parent, List<Coin> coins, boolean twoPane) {
        mParentActivity = parent;
        mCoins = coins;
        mTwoPane = twoPane;
    }

    public static class CoinViewHolder extends RecyclerView.ViewHolder  {
        public TextView name, value, change;
        public ImageView image;

        public CoinViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.tvName);
            value = v.findViewById(R.id.tvValue);
            change = v.findViewById(R.id.tvChange);
            image = v.findViewById(R.id.ivArt);
        }
    }

    @Override
    public CoinAdapter.CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_list_row, parent, false);
        return new CoinViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CoinViewHolder holder, int position) {
        Coin coin = mCoins.get(position);
        Glide.with(holder.itemView).load("https://c1.coinlore.com/img/25x25/" + coin.getNameid() + ".png").fitCenter().into(holder.image);
        holder.name.setText(coin.getName());
        holder.value.setText(NumberFormat.getCurrencyInstance().format(Double.valueOf(coin.getPriceUsd())));
        holder.change.setText((coin.getPercentChange24h()) + " %");
        if (Double.valueOf(coin.getPercentChange24h()) > 0) {
            holder.change.setTextColor(Color.GREEN);
        } else {
            holder.change.setTextColor(Color.RED);
        }
        holder.itemView.setTag(coin);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mCoins.size();
    }

    public void setCoins(List<Coin> coins) {
        mCoins.clear();
        mCoins.addAll(coins);
        notifyDataSetChanged();
    }

}
