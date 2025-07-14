package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class GenericMoth extends AbstractGenericStrike{

    public static final String ID = StringUtils.MakeID(GenericMoth.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_moth";
    private static final CardTags PRINCIPLE_TAG = MOTH;

    public GenericMoth() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
