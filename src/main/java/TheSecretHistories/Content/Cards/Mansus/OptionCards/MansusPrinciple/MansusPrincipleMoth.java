package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class MansusPrincipleMoth extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleMoth.class.getSimpleName());

    private static final String IMG_NAME = "fragmentmoth";
    private static final CardTags PRINCIPLE_TAG = MOTH;

    public MansusPrincipleMoth() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
