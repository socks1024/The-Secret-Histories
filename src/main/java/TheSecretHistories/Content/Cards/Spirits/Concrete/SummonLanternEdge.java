package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Utils.StringUtils;

public class SummonLanternEdge extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonLanternEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_lanternc_edge";
    private static final AbstractSpirit SPIRIT = new SpiritLanternEdge();

    public SummonLanternEdge() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
