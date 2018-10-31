package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface KotaDao {

    @Query("SELECT * FROM kota")
    List<Kota> getAllUsers();

    @Insert
    void insertAll(Kota...kotas);
}