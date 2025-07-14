package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class GenericKnock extends AbstractGenericStrike{

    public static final String ID = StringUtils.MakeID(GenericKnock.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_knock";
    private static final CardTags PRINCIPLE_TAG = KNOCK;

    public GenericKnock() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
