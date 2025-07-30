package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class MansusHeart extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusHeart.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = HEART;

    public MansusHeart(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }
}
