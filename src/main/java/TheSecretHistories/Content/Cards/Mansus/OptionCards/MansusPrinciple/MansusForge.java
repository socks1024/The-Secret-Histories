package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class MansusForge extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusForge.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = FORGE;

    public MansusForge(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }
}
