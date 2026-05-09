package labs.nexa.pigeongram.settings;

import android.content.Context;
import android.view.View;

import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.Components.UItem;
import org.telegram.ui.Components.UniversalAdapter;

import java.util.ArrayList;

import labs.nexa.pigeongram.config.PigeonConfig;

public class PigeonSettingsActivity extends BaseFragment {

    private UniversalAdapter adapter;

    private final int hideStoriesRow = 1;

    @Override
    public View createView(Context context) {

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("PigeonGram Settings");

        adapter = new UniversalAdapter(
                null,
                this::fillItems,
                this::onItemClick,
                null
        );

        fragmentView = adapter.createView(context);

        return fragmentView;
    }

    private void fillItems(ArrayList<UItem> items,
                           UniversalAdapter adapter) {

        items.add(UItem.asHeader("Interface"));

        items.add(
                UItem.asCheck(
                        hideStoriesRow,
                        "Hide Stories",
                        PigeonConfig.hideStories()
                )
        );

        items.add(UItem.asShadow(null));
    }

    private void onItemClick(UItem item,
                             View view,
                             int position,
                             float x,
                             float y) {

        if (item.id == hideStoriesRow) {

            boolean newValue = !PigeonConfig.hideStories();

            PigeonConfig.setHideStories(newValue);

            adapter.update(true);
        }
    }
}
