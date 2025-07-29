package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class MansusWinter extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusWinter.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = WINTER;

    public MansusWinter(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }
}
