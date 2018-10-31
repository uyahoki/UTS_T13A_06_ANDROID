package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Kota.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract KotaDao kotaDao();
}