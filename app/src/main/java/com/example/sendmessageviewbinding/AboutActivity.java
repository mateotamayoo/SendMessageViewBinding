package com.example.sendmessageviewbinding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.danielstone.materialaboutlibrary.ConvenienceBuilder;
import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;

public class AboutActivity extends MaterialAboutActivity {

    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {

        MaterialAboutCard.Builder authorCardBuilder = new MaterialAboutCard.Builder();
        authorCardBuilder.title("Autor");

        authorCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text("Mateo Tamayo")
                .desc("Alum. módulo DEINT")
                .icon(R.mipmap.ic_user_foreground)
                .build());


        authorCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                .text("Fork on Github")
                .icon(R.mipmap.ic_share_foreground)
                .setOnClickAction(ConvenienceBuilder.createWebsiteOnClickAction(context, Uri.parse("https://github.com/mateotamayoo/SendMessageViewBinding.git")))
                .build());

        MaterialAboutCard.Builder versionCardBuilder = new MaterialAboutCard.Builder();
            versionCardBuilder.addItem(new MaterialAboutTitleItem.Builder()
                    .text("Version")
                    .desc("1.0.0")
                            .icon(R.mipmap.ic_info_foreground)
                    .build());
            return  new MaterialAboutList(authorCardBuilder.build(),versionCardBuilder.build());

    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mal_title_about);
    }
}
