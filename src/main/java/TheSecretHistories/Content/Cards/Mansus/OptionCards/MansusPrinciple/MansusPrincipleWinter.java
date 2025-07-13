package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class MansusPrincipleWinter extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleWinter.class.getSimpleName());

    private static final String IMG_NAME = "fragmentwinter";
    private static final CardTags PRINCIPLE_TAG = WINTER;

    public MansusPrincipleWinter() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
