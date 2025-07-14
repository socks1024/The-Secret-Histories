package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class MansusKnock extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusKnock.class.getSimpleName());

    private static final String IMG_NAME = "fragmentknock";
    private static final CardTags PRINCIPLE_TAG = KNOCK;

    public MansusKnock() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
