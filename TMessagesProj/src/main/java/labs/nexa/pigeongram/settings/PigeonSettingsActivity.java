package labs.nexa.pigeongram.settings;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.Cells.TextCheckCell;

import labs.nexa.pigeongram.config.PigeonConfig;

public class PigeonSettingsActivity extends BaseFragment {

    @Override
    public android.view.View createView(Context context) {

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("PigeonGram Settings");

        FrameLayout frameLayout = new FrameLayout(context);

        TextCheckCell hideStoriesCell = new TextCheckCell(context);
        hideStoriesCell.setTextAndCheck(
                "Hide Stories",
                PigeonConfig.hideStories(),
                false
        );

        hideStoriesCell.setOnClickListener(v -> {

            boolean newValue = !PigeonConfig.hideStories();

            PigeonConfig.setHideStories(newValue);

            hideStoriesCell.setChecked(newValue);
        });

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                );

        params.gravity = Gravity.TOP;

        frameLayout.addView(hideStoriesCell, params);

        fragmentView = frameLayout;

        return fragmentView;
    }
}