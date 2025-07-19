package TheSecretHistories.Content.Cards.Spirits.Concrete;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Utils.StringUtils;

public class SummonGrailMoth extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonGrailMoth.class.getSimpleName());

    private static final String IMG_NAME = "spirit_grailc_moth";
    private static final AbstractSpirit SPIRIT = new SpiritGrailMoth();

    public SummonGrailMoth() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
