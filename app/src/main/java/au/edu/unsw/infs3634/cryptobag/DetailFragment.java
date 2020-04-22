package au.edu.unsw.infs3634.cryptobag;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import au.edu.unsw.infs3634.cryptobag.entities.Coin;
import au.edu.unsw.infs3634.cryptobag.entities.CoinLoreResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import static android.content.ContentValues.TAG;

public class DetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    public static final String TAG = "DetailFragment";
    private Coin mCoin;
    private CoinDatabase mDb;

    public DetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDb = Room.databaseBuilder(getContext(), CoinDatabase.class, "coin-database").build();

        if(getArguments().containsKey(ARG_ITEM_ID)) {

            new GetCoinDBTask().execute(getArguments().getString(ARG_ITEM_ID));

        }
    }


    private class GetCoinDBTask extends AsyncTask<String, Void, Coin> {

        @Override
        protected Coin doInBackground(String... ids) {
            return mDb.coinDao().getCoin(ids[0]);
        }

        @Override
        protected void onPostExecute(Coin coin) {
            mCoin = coin;
            updateUi();
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        updateUi();
        return rootView;
    }

    private void updateUi(){

        View rootView = getView();

        if(mCoin != null) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            Glide.with(this).load("https://c1.coinlore.com/img/25x25/" + mCoin.getNameid() + ".png").fitCenter().into((ImageView) rootView.findViewById(R.id.imageView));
            ((TextView) rootView.findViewById(R.id.tvName)).setText(mCoin.getName());
            ((TextView) rootView.findViewById(R.id.tvSymbol)).setText(mCoin.getSymbol());
            ((TextView) rootView.findViewById(R.id.tvValueField)).setText(formatter.format(Double.valueOf(mCoin.getPriceUsd())));
            ((TextView) rootView.findViewById(R.id.tvChange1hField)).setText(mCoin.getPercentChange1h() + " %");
            ((TextView) rootView.findViewById(R.id.tvChange24hField)).setText(mCoin.getPercentChange24h() + " %");
            ((TextView) rootView.findViewById(R.id.tvChange7dField)).setText(mCoin.getPercentChange7d() + " %");
            ((TextView) rootView.findViewById(R.id.tvMarketcapField)).setText(formatter.format(Double.valueOf(mCoin.getMarketCapUsd())));
            ((TextView) rootView.findViewById(R.id.tvVolumeField)).setText(formatter.format(Double.valueOf(mCoin.getVolume24())));

            ((ImageView) rootView.findViewById(R.id.ivSearch)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchCoin(mCoin.getName());
                }
            });
            ((AppCompatActivity) rootView.getContext()).setTitle(mCoin.getName());
        }
    }

    private void searchCoin(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
        startActivity(intent);
    }
}
