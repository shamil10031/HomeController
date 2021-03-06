package shomazzapp.com.homecontorl.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;

import shomazzapp.com.homecontorl.R;
import shomazzapp.com.homecontorl.common.interfaces.FController;
import shomazzapp.com.homecontorl.common.Screens;
import shomazzapp.com.homecontorl.mvp.presnter.RegCameraPresenter;

public class MainActivity extends MvpAppCompatActivity implements FController {

    private static final int LAYOUT = R.layout.activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        RegCameraPresenter.requestPermissionIfNeed(this);
        if (savedInstanceState == null)
            //addFragment(createFragment(Screens.DEVICES_LIST), false);
            addFragment(createFragment(Screens.START), false);
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 1) getSupportFragmentManager().popBackStack();
        super.onBackPressed();
    }

    @Override
    public void addFragment(@NonNull Fragment fragment, boolean addToBackStack) {
        FragmentTransaction t = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragments_frame, fragment, fragment.getClass().toString());
        if (addToBackStack) t.addToBackStack(null);
        t.commit();
    }

    @Nullable
    @Override
    public Fragment getFragmentByTag(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    @Override
    public Fragment createFragment(Screens screens) {
        switch (screens) {
            case START:
                return StartFragment.newInstance();
            case AUTH:
                return AuthFragment.newInstance();
            case REGISTRATION_FIELDS:
                return RegFieldsFragment.newInstance();
            case REGISTRATION_CAMERA:
                return RegCameraFragment.newInstance();
            case DEVICES_LIST:
                return DeviceListFragment.newInstance();
            default:
                throw new RuntimeException("Unknown screen key !");
        }
    }
}
