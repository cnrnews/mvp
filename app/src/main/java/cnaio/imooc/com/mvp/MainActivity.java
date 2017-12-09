package cnaio.imooc.com.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cnaio.imooc.com.mvp.base.AbstractMvpActivity;
import cnaio.imooc.com.mvp.ilistener.IRequestView;
import cnaio.imooc.com.mvp.presenser.RequestPresenter;


public class MainActivity extends AbstractMvpActivity<IRequestView,RequestPresenter>
        implements IRequestView {

    @BindView(R.id.btn_load_data)
    Button btnLoadData;
    @BindView(R.id.tv_content)
    TextView tvContent;
    private String cityId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState!=null)
        {
            Log.e("perfect-mvp","MainActivity  onCreate 测试  = " + savedInstanceState.getString("test") );
        }
    }

    @OnClick(R.id.btn_load_data)
    public void onViewClicked() {
        getMvpPresenter().requestData(cityId);
    }
    @Override
    public void requestLoading() {
        tvContent.setText("loading...");
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        tvContent.setText(result.getWeatherInfo());
    }

    @Override
    public void resultFailure(String result) {
        tvContent.setText(result);
    }

}
