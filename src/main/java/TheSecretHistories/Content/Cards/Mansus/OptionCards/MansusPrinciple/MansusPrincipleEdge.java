package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class MansusPrincipleEdge extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleEdge.class.getSimpleName());

    private static final String IMG_NAME = "fragmentedge";
    private static final CardTags PRINCIPLE_TAG = EDGE;

    public MansusPrincipleEdge() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
