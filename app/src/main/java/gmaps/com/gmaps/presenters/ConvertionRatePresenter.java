package gmaps.com.gmaps.presenters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import gmaps.com.gmaps.models.Rates;
import gmaps.com.gmaps.views.ConvertionRateView;

/**
 * Created by Durga Prasad on 30-01-2017.
 */

public class ConvertionRatePresenter extends BasePresenterImp<ConvertionRateView> {

    @Inject
    Gson gson;

   @Inject
    public ConvertionRatePresenter(){

    }

    public List<Rates> getConvertionRateData(InputStream inputStream)
            throws IOException {
        List<Rates> tateConvertionList = getRateConvertionList(inputStream);
        return tateConvertionList;
    }

    private List<Rates> getRateConvertionList(InputStream inputStream)
            throws IOException {
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String json = new String(buffer, "UTF-8");
        return gson.fromJson(json,
                new TypeToken<List<Rates>>() {
                }.getType());
    }
}
