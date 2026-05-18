package labs.nexa.pigeongram.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.Cells.HeaderCell;
import org.telegram.ui.Cells.ShadowSectionCell;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Components.BulletinFactory;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;

import labs.nexa.pigeongram.config.PigeonConfig;

public class PigeonSettingsActivity extends BaseFragment {

    private RecyclerListView listView;

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_CHECK = 1;
    private static final int VIEW_TYPE_SHADOW = 2;

    @Override
    public View createView(Context context) {

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("PigeonGram Settings");

        FrameLayout frameLayout = new FrameLayout(context);

        listView = new RecyclerListView(context);

        listView.setLayoutManager(
                new LinearLayoutManager(context)
        );

        listView.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {

            @Override
            public int getItemCount() {
                return 5;
            }

            @Override
            public int getItemViewType(int position) {

                switch (position) {
                    case 0:
                    case 3:
                        return VIEW_TYPE_HEADER;

                    case 2:
                        return VIEW_TYPE_SHADOW;

                    default:
                        return VIEW_TYPE_CHECK;
                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(
                    ViewGroup parent,
                    int viewType
            ) {

                View view;

                if (viewType == VIEW_TYPE_HEADER) {

                    view = new HeaderCell(context);

                } else if (viewType == VIEW_TYPE_SHADOW) {

                    view = new ShadowSectionCell(context);

                } else {

                    view = new TextCheckCell(context);
                }

                return new RecyclerListView.Holder(view);
            }

            @Override
            public void onBindViewHolder(
                    RecyclerView.ViewHolder holder,
                    int position
            ) {

                switch (getItemViewType(position)) {

                    case VIEW_TYPE_HEADER: {

                        HeaderCell cell =
                                (HeaderCell) holder.itemView;

                        if (position == 0) {
                            cell.setText("Interface");
                        } else {
                            cell.setText("Developer");
                        }

                        break;
                    }

                    case VIEW_TYPE_CHECK: {

                        TextCheckCell cell =
                                (TextCheckCell) holder.itemView;

                        if (position == 1) {

                            cell.setTextAndCheck(
                                    "Hide Stories",
                                    PigeonConfig.hideStories(),
                                    true
                            );

                        } else if (position == 4) {

                            cell.setTextAndCheck(
                                    "Developer Mode",
                                    false,
                                    false
                            );
                        }

                        break;
                    }
                }
            }
        });

        listView.setOnItemClickListener((view, position) -> {

            if (position == 1) {

                boolean value = !PigeonConfig.hideStories();

                PigeonConfig.setHideStories(value);

                TextCheckCell cell = (TextCheckCell) view;

                cell.setChecked(value);

                BulletinFactory.of(this)
                        .createSimpleBulletin(
                                R.raw.info,
                                "Restart PigeonGram to apply changes"
                        )
                        .show();
            }
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
