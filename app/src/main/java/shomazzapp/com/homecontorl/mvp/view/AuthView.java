package shomazzapp.com.homecontorl.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AuthView extends MvpView {

    void startAuth();

    void finishAuth();

    @StateStrategyType(SkipStrategy.class)
    void showMsg(String msg);

    void showLoginAndPass(String login, String password);

}
