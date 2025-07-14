package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class MansusGrail extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusGrail.class.getSimpleName());

    private static final String IMG_NAME = "fragmentgrail";
    private static final CardTags PRINCIPLE_TAG = GRAIL;

    public MansusGrail() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
