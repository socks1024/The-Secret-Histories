package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Utils.StringUtils;

public class SummonHeartEdge extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonHeartEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_heartc_edge";
    private static final AbstractSpirit SPIRIT = new SpiritHeartEdge();

    public SummonHeartEdge() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
