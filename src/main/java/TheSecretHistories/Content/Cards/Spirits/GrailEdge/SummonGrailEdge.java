package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Utils.StringUtils;

public class SummonGrailEdge extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonGrailEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_graile_edge";
    private static final AbstractSpirit SPIRIT = new SpiritGrailEdge();

    public SummonGrailEdge() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
