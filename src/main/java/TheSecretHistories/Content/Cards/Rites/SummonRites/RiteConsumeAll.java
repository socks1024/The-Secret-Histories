package TheSecretHistories.Content.Cards.Rites.SummonRites;

import TheSecretHistories.Content.Cards.Rites.AbstractSummonRite;
import TheSecretHistories.Utils.StringUtils;

public class RiteConsumeAll extends AbstractSummonRite {

    public static final String ID = StringUtils.MakeID(RiteConsumeAll.class.getSimpleName());

    private static final String IMG_NAME = "riteconsumetoolingredientfollowerinfluence";

    public RiteConsumeAll() {
        super(ID, IMG_NAME);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }
}
