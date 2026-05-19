package labs.nexa.pigeongram.settings;

import android.content.Context;
import android.widget.FrameLayout;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

public class ChatsSettingsActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("Chats");

        FrameLayout frameLayout = new FrameLayout(context);

        fragmentView = frameLayout;

        return fragmentView;
    }
}
