package TheSecretHistories.Content.Cards.Rites.SummonRites;

import TheSecretHistories.Content.Cards.Rites.AbstractSummonRite;
import TheSecretHistories.Utils.StringUtils;

public class RiteToolFollowerConsumeLore extends AbstractSummonRite {

    public static final String ID = StringUtils.MakeID(RiteToolFollowerConsumeLore.class.getSimpleName());

    private static final String IMG_NAME = "ritetoolfollowerconsumelore";

    public RiteToolFollowerConsumeLore() {
        super(ID, IMG_NAME);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }
}
