package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class GenericHeart extends AbstractGenericDefend{

    public static final String ID = StringUtils.MakeID(GenericHeart.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_heart";
    private static final CardTags PRINCIPLE_TAG = HEART;

    public GenericHeart() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
