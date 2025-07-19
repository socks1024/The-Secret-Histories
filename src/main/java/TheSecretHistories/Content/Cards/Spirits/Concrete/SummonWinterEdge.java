package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Utils.StringUtils;

public class SummonWinterEdge extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonWinterEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_winterd_edge";
    private static final AbstractSpirit SPIRIT = new SpiritWinterEdge();

    public SummonWinterEdge() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
