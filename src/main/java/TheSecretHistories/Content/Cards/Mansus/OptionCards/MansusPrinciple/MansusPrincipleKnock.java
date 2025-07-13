package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class MansusPrincipleKnock extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleKnock.class.getSimpleName());

    private static final String IMG_NAME = "fragmentknock";
    private static final CardTags PRINCIPLE_TAG = KNOCK;

    public MansusPrincipleKnock() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
