package org.telegram.ui;

import android.content.Context;
import android.widget.FrameLayout;

import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.ActionBar.BaseFragment;

public class PigeonSettingsActivity extends BaseFragment {

    @Override
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        return true;
    }

    @Override
    public android.view.View createView(Context context) {

        actionBar.setBackButtonImage(
                org.telegram.messenger.R.drawable.ic_ab_back);

        actionBar.setTitle("PigeonGram Settings");

        FrameLayout frameLayout = new FrameLayout(context);
        fragmentView = frameLayout;

        return fragmentView;
    }
}
