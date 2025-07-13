package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class GenericLantern extends AbstractGenericDefend{

    public static final String ID = StringUtils.MakeID(GenericLantern.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_lantern";
    private static final CardTags PRINCIPLE_TAG = LANTERN;

    public GenericLantern() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
