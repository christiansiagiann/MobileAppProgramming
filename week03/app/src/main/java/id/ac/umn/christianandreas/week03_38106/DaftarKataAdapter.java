package id.ac.umn.christianandreas.week03_38106;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarKataAdapter extends
        RecyclerView.Adapter<DaftarKataAdapter.KataViewHolder> {
    private final LinkedList<String> mDaftarKata;
    private final LayoutInflater mInflater;



    DaftarKataAdapter(Context context, LinkedList<String>
            daftarKata) {
        mInflater = LayoutInflater.from(context);
        mDaftarKata = daftarKata;
    }

    @NonNull
    @Override
    public DaftarKataAdapter.KataViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.daftarkata_item,
                parent, false);
        return new KataViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder
            (@NonNull DaftarKataAdapter.KataViewHolder holder,
             int position) {
        String mCurrent = mDaftarKata.get(position);
        holder.kataItemView.setText(mCurrent);
    }
    @Override
    public int getItemCount() {
        return mDaftarKata.size();
    }
    static class KataViewHolder extends RecyclerView.ViewHolder{
        public final TextView kataItemView;
        final DaftarKataAdapter mAdapter;

        public KataViewHolder(@NonNull View itemView,
                              DaftarKataAdapter adapter) {
            super(itemView);
            kataItemView = itemView.findViewById(R.id.kata);
            this.mAdapter = adapter;


        }
    }
}
