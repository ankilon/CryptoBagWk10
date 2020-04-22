package au.edu.unsw.infs3634.cryptobag;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import au.edu.unsw.infs3634.cryptobag.entities.Coin;

@Dao
public interface CoinDao {

    @Query("SELECT * FROM coin")
    List<Coin> getCoins();

    @Query("SELECT * FROM coin WHERE id == :coinId")
    Coin getCoin(String coinId);

    @Insert
    void insertAll(Coin... coins);

    @Delete
    void deleteAll(Coin... coins);
}
