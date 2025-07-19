package TheSecretHistories.Content.Cards.Spirits.GrailEdge;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Utils.StringUtils;

public class SummonWinterMoth extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonWinterMoth.class.getSimpleName());

    private static final String IMG_NAME = "spirit_winterb_heart";
    private static final AbstractSpirit SPIRIT = new SpiritWinterMoth();

    public SummonWinterMoth() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
