package TheSecretHistories.Content.Cards.Rites.SummonRites;

import TheSecretHistories.Content.Cards.Rites.AbstractSummonRite;
import TheSecretHistories.Utils.StringUtils;

public class RiteFollowerConsumeTool extends AbstractSummonRite {

    public static final String ID = StringUtils.MakeID(RiteFollowerConsumeTool.class.getSimpleName());

    private static final String IMG_NAME = "ritefollowerconsumetool";

    public RiteFollowerConsumeTool() {
        super(ID, IMG_NAME);
    }
}
