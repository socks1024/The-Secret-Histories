package TheSecretHistories.Content.Cards.Rites.SummonRites;

import TheSecretHistories.Content.Cards.Rites.AbstractSummonRite;
import TheSecretHistories.Utils.StringUtils;

public class RiteInfluenceConsumeFollower extends AbstractSummonRite {

    public static final String ID = StringUtils.MakeID(RiteInfluenceConsumeFollower.class.getSimpleName());

    private static final String IMG_NAME = "riteinfluenceconsumefollower";

    public RiteInfluenceConsumeFollower() {
        super(ID, IMG_NAME);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }
}
