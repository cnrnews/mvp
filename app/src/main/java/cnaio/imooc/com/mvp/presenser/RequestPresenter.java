package cnaio.imooc.com.mvp.presenser;

import cnaio.imooc.com.mvp.WeatherBean;
import cnaio.imooc.com.mvp.base.AbstractMvpPersenter;
import cnaio.imooc.com.mvp.ilistener.IRequestView;
import cnaio.imooc.com.mvp.model.RequestModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
*作者:candy
*创建时间:2017/12/9 8:39
*邮箱:1601796593@qq.com
*功能描述:MVP Presenser层
**/
public class RequestPresenter extends AbstractMvpPersenter<IRequestView> {


    private RequestModel mRequestModel;
    public RequestPresenter() {
        mRequestModel =new RequestModel();
    }
    public void requestData(String cityId)
    {

        if (getiMvpView()!=null) {
            getiMvpView().requestLoading();
        }
        mRequestModel.request(cityId, new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                if (getiMvpView() != null) {
                    getiMvpView().resultSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                if (getiMvpView() != null) {
                    getiMvpView() .resultFailure(t.getMessage());
                }
            }
        });
    }
    /**
     * 终端网络请求
     */
    public void interrupy()
    {
        mRequestModel.intterupt();
    }
}
