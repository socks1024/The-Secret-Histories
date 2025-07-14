package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class MansusForge extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusForge.class.getSimpleName());

    private static final String IMG_NAME = "fragmentforge";
    private static final CardTags PRINCIPLE_TAG = FORGE;

    public MansusForge() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
