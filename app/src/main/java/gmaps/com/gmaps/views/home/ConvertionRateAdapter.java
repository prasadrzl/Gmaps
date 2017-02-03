package gmaps.com.gmaps.views.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gmaps.com.gmaps.R;
import gmaps.com.gmaps.models.Rates;
import gmaps.com.gmaps.models.SkuWithCurrency;

/**
 * Created by Durga Prasad on 30-01-2017.
 */

public class ConvertionRateAdapter extends RecyclerView.
        Adapter<ConvertionRateAdapter.ConvertionRateViewHolder> {
    private final LayoutInflater layoutInflater;
    private List<SkuWithCurrency> skuWithCurrencyRateList;
    private Context context;
    private List<Rates> ratesConvertionList;

    public ConvertionRateAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setConvertionListData(List<SkuWithCurrency> skuWithCurrencyRateList) {
        this.skuWithCurrencyRateList = skuWithCurrencyRateList;
    }

    @Override
    public ConvertionRateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.trsaction_view, parent, false);
        ConvertionRateViewHolder transactionViewHolder =
                new ConvertionRateViewHolder(view);
        return transactionViewHolder;
    }

    @Override
    public void onBindViewHolder(ConvertionRateViewHolder holder, int position) {
        holder.skuName.setText(skuWithCurrencyRateList.get(position).currency);
        holder.skuCount.setText(String.valueOf(convertedToGbp(skuWithCurrencyRateList.get(position)
                .currency, "GBP")));

    }

    private float convertedToGbp(String currency, String requiredCurrency) {
        float currencyValue = 1f;
        if (requiredCurrency.equals(currency)) {
            return currencyValue;
        }

        for (Rates rates : ratesConvertionList) {
            if (currency.equals(rates.from)) {
                if (requiredCurrency.equals(rates.to)) {
                    currencyValue = Float.valueOf(rates.rate);
                    break;
                }
                currencyValue = calc(rates.to, Float.valueOf(rates.rate), requiredCurrency);
            }
        }


        return currencyValue;
    }

    private float calc(String toCurrency, float currencyValue, String requiredCurrency) {
        for (Rates rates : ratesConvertionList) {
            if (requiredCurrency.equals(rates.to)) {
                if (toCurrency.equals(rates.from)) {
                    currencyValue = currencyValue * Float.parseFloat(rates.rate);
                    return currencyValue;
                }
            }
        }
        return currencyValue;
    }


    private float recursiveCal(String from,String to,String reqCur,String currencyRate) {
        float currencyValue = 1f;

        if(reqCur.equals(to)){
            currencyValue = currencyValue * Float.parseFloat(currencyRate);
            return  currencyValue;
        }
        else{
            for(Rates rates : ratesConvertionList){
                if(to.equals(rates.from)){
                    currencyValue =  recursiveCal(to,rates.to,reqCur,String.valueOf(Float.valueOf(currencyRate)* Float.valueOf(rates.rate)));
                }
            }

        }
       return  currencyValue;
    }


    @Override
    public int getItemCount() {
        return skuWithCurrencyRateList == null ? 0 : skuWithCurrencyRateList.size();
    }

    public void setRateJsonData(List<Rates> ratesConvertionList) {
        this.ratesConvertionList = ratesConvertionList;
    }

    public static class ConvertionRateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sku_name)
        TextView skuName;
        @BindView(R.id.sku_count)
        TextView skuCount;

        ConvertionRateViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}

