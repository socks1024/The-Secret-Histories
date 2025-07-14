package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class MansusEdge extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusEdge.class.getSimpleName());

    private static final String IMG_NAME = "fragmentedge";
    private static final CardTags PRINCIPLE_TAG = EDGE;

    public MansusEdge() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
