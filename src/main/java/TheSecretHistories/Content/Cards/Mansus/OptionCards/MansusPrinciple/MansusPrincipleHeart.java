package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class MansusPrincipleHeart extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleHeart.class.getSimpleName());

    private static final String IMG_NAME = "fragmentheart";
    private static final CardTags PRINCIPLE_TAG = HEART;

    public MansusPrincipleHeart() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
