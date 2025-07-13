package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class MansusPrincipleLantern extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleLantern.class.getSimpleName());

    private static final String IMG_NAME = "fragmentlantern";
    private static final CardTags PRINCIPLE_TAG = LANTERN;

    public MansusPrincipleLantern() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
