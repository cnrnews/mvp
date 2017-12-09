package cnaio.imooc.com.mvp;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author：lihl on 2017/12/9 08:22
 * @email：1601796593@qq.com
 */
public interface ApiService {

    @GET("data/cityinfo/{cityId}.html")
    Call<WeatherBean> requestWeather(@Path("cityId")String cityId);
}
