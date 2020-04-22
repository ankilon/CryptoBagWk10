package au.edu.unsw.infs3634.cryptobag.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Coin implements Serializable
{

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameid")
    @Expose
    private String nameid;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("price_usd")
    @Expose
    private String priceUsd;
    @SerializedName("percent_change_24h")
    @Expose
    private String percentChange24h;
    @SerializedName("percent_change_1h")
    @Expose
    private String percentChange1h;
    @SerializedName("percent_change_7d")
    @Expose
    private String percentChange7d;
    @SerializedName("price_btc")
    @Expose
    private String priceBtc;
    @SerializedName("market_cap_usd")
    @Expose
    private String marketCapUsd;
    @SerializedName("volume24")
    @Expose
    private Double volume24;
    @SerializedName("volume24a")
    @Expose
    private Double volume24a;
    @SerializedName("csupply")
    @Expose
    private String csupply;
    @SerializedName("tsupply")
    @Expose
    private String tsupply;
    @SerializedName("msupply")
    @Expose
    private String msupply;
    private final static long serialVersionUID = -7788521239405538888L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coin() {
    }

    /**
     *
     * @param symbol
     * @param volume24a
     * @param priceUsd
     * @param priceBtc
     * @param volume24
     * @param percentChange24h
     * @param percentChange7d
     * @param marketCapUsd
     * @param msupply
     * @param tsupply
     * @param name
     * @param nameid
     * @param rank
     * @param csupply
     * @param id
     * @param percentChange1h
     */
    public Coin(String id, String symbol, String name, String nameid, Integer rank, String priceUsd, String percentChange24h, String percentChange1h, String percentChange7d, String priceBtc, String marketCapUsd, Double volume24, Double volume24a, String csupply, String tsupply, String msupply) {
        super();
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.nameid = nameid;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.percentChange24h = percentChange24h;
        this.percentChange1h = percentChange1h;
        this.percentChange7d = percentChange7d;
        this.priceBtc = priceBtc;
        this.marketCapUsd = marketCapUsd;
        this.volume24 = volume24;
        this.volume24a = volume24a;
        this.csupply = csupply;
        this.tsupply = tsupply;
        this.msupply = msupply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coin withId(String id) {
        this.id = id;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Coin withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coin withName(String name) {
        this.name = name;
        return this;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public Coin withNameid(String nameid) {
        this.nameid = nameid;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Coin withRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Coin withPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
        return this;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public Coin withPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
        return this;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public Coin withPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
        return this;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public Coin withPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
        return this;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public Coin withPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
        return this;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public Coin withMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
        return this;
    }

    public Double getVolume24() {
        return volume24;
    }

    public void setVolume24(Double volume24) {
        this.volume24 = volume24;
    }

    public Coin withVolume24(Double volume24) {
        this.volume24 = volume24;
        return this;
    }

    public Double getVolume24a() {
        return volume24a;
    }

    public void setVolume24a(Double volume24a) {
        this.volume24a = volume24a;
    }

    public Coin withVolume24a(Double volume24a) {
        this.volume24a = volume24a;
        return this;
    }

    public String getCsupply() {
        return csupply;
    }

    public void setCsupply(String csupply) {
        this.csupply = csupply;
    }

    public Coin withCsupply(String csupply) {
        this.csupply = csupply;
        return this;
    }

    public String getTsupply() {
        return tsupply;
    }

    public void setTsupply(String tsupply) {
        this.tsupply = tsupply;
    }

    public Coin withTsupply(String tsupply) {
        this.tsupply = tsupply;
        return this;
    }

    public String getMsupply() {
        return msupply;
    }

    public void setMsupply(String msupply) {
        this.msupply = msupply;
    }

    public Coin withMsupply(String msupply) {
        this.msupply = msupply;
        return this;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("id", id).append("symbol", symbol).append("name", name).append("nameid", nameid).append("rank", rank).append("priceUsd", priceUsd).append("percentChange24h", percentChange24h).append("percentChange1h", percentChange1h).append("percentChange7d", percentChange7d).append("priceBtc", priceBtc).append("marketCapUsd", marketCapUsd).append("volume24", volume24).append("volume24a", volume24a).append("csupply", csupply).append("tsupply", tsupply).append("msupply", msupply).toString();
//    }

}