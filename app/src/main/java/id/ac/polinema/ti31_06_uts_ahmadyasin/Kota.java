package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Kota {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "namaKota")
    private String namaKota;

    public Kota(String namaKota) {
        this.namaKota = namaKota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }
}
