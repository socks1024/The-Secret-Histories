package TheSecretHistories.Content.Cards.Spirits.Options;

import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Spirits.AbstractSummonOption;
import TheSecretHistories.Content.Cards.Spirits.Concrete.SpiritLanternSecret;
import TheSecretHistories.Utils.StringUtils;

public class SummonLanternSecret extends AbstractSummonOption {

    public static final String ID = StringUtils.MakeID(SummonLanternSecret.class.getSimpleName());

    private static final String IMG_NAME = "spirit_lanterne_secret";
    private static final AbstractSpirit SPIRIT = new SpiritLanternSecret();

    public SummonLanternSecret() {
        super(ID, IMG_NAME, SPIRIT);
    }
}
