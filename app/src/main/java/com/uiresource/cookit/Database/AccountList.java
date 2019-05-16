package com.uiresource.cookit.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class AccountList {

    @PrimaryKey @NonNull
    public String id;

    public String email;

    public String userName;

    public String firstName;

    public String pathToAvatar;

    public String aboutYourself;

    public boolean gender;

    public int recipiesCount;

    public int reviewsCount;

    public int rateReviewsCount;
}


