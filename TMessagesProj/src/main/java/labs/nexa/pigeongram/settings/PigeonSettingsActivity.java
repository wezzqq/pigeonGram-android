package labs.nexa.pigeongram.settings;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.BuildVars;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.Cells.TextSettingsCell;
import org.telegram.ui.Components.LayoutHelper;
import org.telegram.ui.Components.RecyclerListView;

public class PigeonSettingsActivity extends BaseFragment {

    @Override
    public View createView(Context context) {

        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setTitle("");

        FrameLayout frameLayout = new FrameLayout(context);

        RecyclerListView listView = new RecyclerListView(context);

        LinearLayout content = new LinearLayout(context);
        content.setOrientation(LinearLayout.VERTICAL);

        // LOGO

        TextView logo = new TextView(context);
        logo.setText("\uD83D\uDD4A");
        logo.setTextSize(48);
        logo.setGravity(Gravity.CENTER);

        // TITLE

        TextView title = new TextView(context);
        title.setText("PigeonGram");
        title.setTextSize(28);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);

        // VERSION

        TextView version = new TextView(context);
        version.setText(BuildVars.BUILD_VERSION_STRING);
        version.setTextSize(14);
        version.setAlpha(0.7f);
        version.setGravity(Gravity.CENTER);

        content.addView(
                logo,
                LayoutHelper.createLinear(
                        LayoutHelper.MATCH_PARENT,
                        LayoutHelper.WRAP_CONTENT,
                        0,
                        32,
                        0,
                        0
                )
        );

        content.addView(
                title,
                LayoutHelper.createLinear(
                        LayoutHelper.MATCH_PARENT,
                        LayoutHelper.WRAP_CONTENT
                )
        );

        content.addView(
                version,
                LayoutHelper.createLinear(
                        LayoutHelper.MATCH_PARENT,
                        LayoutHelper.WRAP_CONTENT,
                        0,
                        4,
                        0,
                        24
                )
        );

        // INTERFACE

        TextSettingsCell interfaceCell =
                new TextSettingsCell(context);

        interfaceCell.setText("Interface", true);

        interfaceCell.setOnClickListener(v ->
                presentFragment(new InterfaceSettingsActivity())
        );

        // CHATS

        TextSettingsCell chatsCell =
                new TextSettingsCell(context);

        chatsCell.setText("Chats", true);

        chatsCell.setOnClickListener(v ->
                presentFragment(new ChatsSettingsActivity())
        );

        // DEVELOPER

        TextSettingsCell developerCell =
                new TextSettingsCell(context);

        developerCell.setText("Developer", false);

        developerCell.setOnClickListener(v ->
                presentFragment(new DeveloperSettingsActivity())
        );

        content.addView(interfaceCell);

        content.addView(chatsCell);

        content.addView(developerCell);

        frameLayout.addView(
                content,
                LayoutHelper.createFrame(
                        LayoutHelper.MATCH_PARENT,
                        LayoutHelper.WRAP_CONTENT,
                        Gravity.TOP
                )
        );

        fragmentView = frameLayout;

        return fragmentView;
    }
}
