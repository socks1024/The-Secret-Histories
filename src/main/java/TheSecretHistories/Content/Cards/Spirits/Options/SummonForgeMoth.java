package TheSecretHistories.Content.Cards.Spirits.Options;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Content.Cards.Spirits.Concrete.SpiritForgeMoth;
import TheSecretHistories.Utils.StringUtils;

public class SummonForgeMoth extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonForgeMoth.class.getSimpleName());

    private static final String IMG_NAME = "spirit_forgec_winter";
    private static final AbstractSpirit SPIRIT = new SpiritForgeMoth();

    public SummonForgeMoth() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
