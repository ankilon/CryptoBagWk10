package au.edu.unsw.infs3634.cryptobag.entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Info implements Serializable
{

    @SerializedName("coins_num")
    @Expose
    private Integer coinsNum;
    @SerializedName("time")
    @Expose
    private Integer time;
    private final static long serialVersionUID = 6132040084086371856L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Info() {
    }

    /**
     *
     * @param time
     * @param coinsNum
     */
    public Info(Integer coinsNum, Integer time) {
        super();
        this.coinsNum = coinsNum;
        this.time = time;
    }

    public Integer getCoinsNum() {
        return coinsNum;
    }

    public void setCoinsNum(Integer coinsNum) {
        this.coinsNum = coinsNum;
    }

    public Info withCoinsNum(Integer coinsNum) {
        this.coinsNum = coinsNum;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Info withTime(Integer time) {
        this.time = time;
        return this;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("coinsNum", coinsNum).append("time", time).toString();
//    }

}