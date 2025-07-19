package TheSecretHistories.Content.Cards.Rites.SummonRites;

import TheSecretHistories.Content.Cards.Rites.AbstractSummonRite;
import TheSecretHistories.Utils.StringUtils;

public class RiteToolConsumeInfluence extends AbstractSummonRite {

    public static final String ID = StringUtils.MakeID(RiteToolConsumeInfluence.class.getSimpleName());

    private static final String IMG_NAME = "ritetoolconsumeinfluence";

    public RiteToolConsumeInfluence() {
        super(ID, IMG_NAME);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }
}
