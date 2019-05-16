package com.uiresource.cookit.Database;

import java.util.List;

public class items {
    public List<AccountList> accountList;

    public String get(int i){
        return accountList.get(i).userName;
    }
}
