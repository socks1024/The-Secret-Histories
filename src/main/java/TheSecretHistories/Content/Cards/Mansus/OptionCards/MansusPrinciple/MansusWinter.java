package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class MansusWinter extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusWinter.class.getSimpleName());

    private static final String IMG_NAME = "fragmentwinter";
    private static final CardTags PRINCIPLE_TAG = WINTER;

    public MansusWinter() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
