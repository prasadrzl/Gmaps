package gmaps.com.gmaps.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import gmaps.com.gmaps.R;
import gmaps.com.gmaps.listeners.OnRecycleViewItemClickListener;
import gmaps.com.gmaps.models.SkuWithCurrency;

/**
 * Created by Durga Prasad on 30-01-2017.
 */

public class TransactionRecyclerViewAdapter extends RecyclerView.Adapter<TransactionRecyclerViewAdapter.TransactionViewHolder> {
    private final LayoutInflater layoutInflater;
    private Map<String, List<SkuWithCurrency>> transactionMap;
    private Context context;
    private OnRecycleViewItemClickListener onRecycleViewItemClickListener;

    public TransactionRecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setTransactionMapData(Map<String, List<SkuWithCurrency>>
                                              transactionMap) {
        this.transactionMap = transactionMap;
    }

    public void setOnRecyclerViewItemClickListener(OnRecycleViewItemClickListener
                                                           onRecyclerViewItemClickListener) {
        this.onRecycleViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public String getSkuName(int position) {
        return new ArrayList<>(transactionMap.keySet()).get(position);
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.trsaction_view, parent, false);
        TransactionViewHolder transactionViewHolder = new TransactionViewHolder(view);
        return transactionViewHolder;
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        holder.skuName.setText(getSkuName(position));
        holder.skuCount.setText(String.valueOf(transactionMap.
                get(getSkuName(position)).size()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecycleViewItemClickListener.setOnRecycleViewItemClickListener(position, getSkuName(position));
            }
        });

    }


    @Override
    public int getItemCount() {
        return transactionMap == null ? 0 : transactionMap.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.sku_name)
        TextView skuName;
        @BindView(R.id.sku_count)
        TextView skuCount;

        TransactionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }


        @Override
        public void onClick(View v) {
            //onRecycleViewItemClickListener.setOnRecycleViewItemClickListener(getLayoutPosition());
        }
    }
}
