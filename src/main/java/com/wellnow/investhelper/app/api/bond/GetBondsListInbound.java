package com.wellnow.investhelper.app.api.bond;

import java.util.List;

import com.wellnow.investhelper.domain.DBond;

public interface GetBondsListInbound {
    public List<DBond> execute(String token);
}
