package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class GenericHeart extends AbstractGenericDefend{

    public static final String ID = StringUtils.MakeID(GenericHeart.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_lantern";
    private static final CardTags PRINCIPLE_TAG = LANTERN;

    public GenericHeart() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
