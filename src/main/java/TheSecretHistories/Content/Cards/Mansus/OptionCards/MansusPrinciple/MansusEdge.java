package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class MansusEdge extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusEdge.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = EDGE;

    public MansusEdge(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }
}
