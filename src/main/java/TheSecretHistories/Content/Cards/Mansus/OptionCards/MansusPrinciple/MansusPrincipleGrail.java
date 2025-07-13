package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class MansusPrincipleGrail extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleGrail.class.getSimpleName());

    private static final String IMG_NAME = "fragmentgrail";
    private static final CardTags PRINCIPLE_TAG = GRAIL;

    public MansusPrincipleGrail() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
