package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class GenericWinter extends AbstractGenericStrike{

    public static final String ID = StringUtils.MakeID(GenericWinter.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_winter";
    private static final CardTags PRINCIPLE_TAG = WINTER;

    public GenericWinter() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
