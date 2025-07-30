package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class MansusLantern extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusLantern.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = LANTERN;

    public MansusLantern(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }
}
