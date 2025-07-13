package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class MansusPrincipleForge extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusPrincipleForge.class.getSimpleName());

    private static final String IMG_NAME = "fragmentforge";
    private static final CardTags PRINCIPLE_TAG = FORGE;

    public MansusPrincipleForge() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
