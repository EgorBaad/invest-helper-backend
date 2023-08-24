package com.wellnow.investhelper.app.impl.bond;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wellnow.investhelper.app.api.bond.GetBondsListInbound;
import com.wellnow.investhelper.app.api.bond.GetBondsListOutbound;
import com.wellnow.investhelper.domain.DBond;

import lombok.RequiredArgsConstructor;
import ru.tinkoff.piapi.contract.v1.Bond;

@Component
@RequiredArgsConstructor
public class GetBondsListUseCase implements GetBondsListInbound {
    private final GetBondsListOutbound getBondsListOutbound;

    @Override
    public List<DBond> execute() {
        List<Bond> bondList = getBondsListOutbound.getBondsList();
        List<DBond> dBondList = new ArrayList<>();
        for (Bond bond : bondList) {
            DBond dBond = new DBond(bond.getFigi(), bond.getTicker(), bond.getLot(), bond.getCurrency(), bond.getName()/*, bond.getNominal()*/);
            dBondList.add(dBond);
        }

        return dBondList;
    }
}
