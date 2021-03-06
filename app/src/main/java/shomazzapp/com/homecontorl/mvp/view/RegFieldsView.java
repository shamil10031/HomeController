package shomazzapp.com.homecontorl.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface RegFieldsView extends MvpView {

    void startLoading();

    void finishLoading();

    @StateStrategyType(SkipStrategy.class)
    void showMsg(String msg);

}
