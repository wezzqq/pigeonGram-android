package labs.nexa.pigeongram.settings;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Components.BulletinFactory;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;

import labs.nexa.pigeongram.config.PigeonConfig;

public class InterfaceSettingsActivity extends BaseFragment {

    @Override
    public View createView(Context context) {

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("Interface");

        FrameLayout frameLayout = new FrameLayout(context);

        RecyclerListView listView =
                new RecyclerListView(context);

        listView.setLayoutManager(
                new LinearLayoutManager(context)
        );

        listView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            @Override
            public int getItemCount() {
                return 1;
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(
                    android.view.ViewGroup parent,
                    int viewType
            ) {

                TextCheckCell cell =
                        new TextCheckCell(context);

                return new RecyclerListView.Holder(cell);
            }

            @Override
            public void onBindViewHolder(
                    RecyclerView.ViewHolder holder,
                    int position
            ) {

                TextCheckCell cell =
                        (TextCheckCell) holder.itemView;

                cell.setTextAndCheck(
                        "Hide Stories",
                        PigeonConfig.hideStories(),
                        false
                );
            }
        });

        listView.setOnItemClickListener((view, position) -> {

            boolean value =
                    !PigeonConfig.hideStories();

            PigeonConfig.setHideStories(value);

            TextCheckCell cell =
                    (TextCheckCell) view;

            cell.setChecked(value);

            BulletinFactory.of(this)
                    .createSimpleBulletin(
                            R.raw.info,
                            "Restart PigeonGram required"
                    )
                    .show();
        });

        frameLayout.addView(
                listView,
                LayoutHelper.createFrame(
                        LayoutHelper.MATCH_PARENT,
                        LayoutHelper.MATCH_PARENT
                )
        );

        fragmentView = frameLayout;

        return fragmentView;
    }
}
