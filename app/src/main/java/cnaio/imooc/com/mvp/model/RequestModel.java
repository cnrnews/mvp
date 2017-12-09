package cnaio.imooc.com.mvp.model;

import cnaio.imooc.com.mvp.ApiService;
import cnaio.imooc.com.mvp.WeatherBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
*作者:candy
*创建时间:2017/12/9 8:38
*邮箱:1601796593@qq.com
*功能描述:MVP model层
**/
public class RequestModel {

    private static final String BASE_URL = "http://www.weather.com.cn/";
    private Call<WeatherBean> weatherBeanCall;
    //http://www.weather.com.cn/data/cityinfo/101010100.html
    public void request(String detailId, Callback<WeatherBean> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        weatherBeanCall  = apiService.requestWeather(detailId);
        weatherBeanCall.enqueue(callback);
    }
    public void intterupt()
    {
        if (weatherBeanCall!=null)
        {
            weatherBeanCall.cancel();
        }
    }
}
