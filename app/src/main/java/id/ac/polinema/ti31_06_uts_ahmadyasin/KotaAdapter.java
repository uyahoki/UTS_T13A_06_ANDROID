package id.ac.polinema.ti31_06_uts_ahmadyasin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class KotaAdapter extends RecyclerView.Adapter<KotaAdapter.ViewHolder> {

    List<Kota> kotas;

    public KotaAdapter(List<Kota> kotas) {
        this.kotas = kotas;
    }

    @NonNull
    @Override
    public KotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kota_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KotaAdapter.ViewHolder holder, int position) {
        holder.tvNamaKota.setText(kotas.get(position).getNamaKota());
    }

    @Override
    public int getItemCount() {
        return kotas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaKota;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaKota = itemView.findViewById(R.id.tvNamaKota);
        }
    }
}
