package TheSecretHistories.Content.Cards.Spirits.Options;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Content.Cards.Spirits.Concrete.SpiritForgeEdge;
import TheSecretHistories.Utils.StringUtils;

public class SummonForgeEdge extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonForgeEdge.class.getSimpleName());

    private static final String IMG_NAME = "spirit_forgee_edge";
    private static final AbstractSpirit SPIRIT = new SpiritForgeEdge();

    public SummonForgeEdge() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
