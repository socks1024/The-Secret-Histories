package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class MansusHeart extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusHeart.class.getSimpleName());

    private static final String IMG_NAME = "fragmentheart";
    private static final CardTags PRINCIPLE_TAG = HEART;

    public MansusHeart() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
