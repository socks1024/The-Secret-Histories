package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class GenericForge extends AbstractGenericDefend{

    public static final String ID = StringUtils.MakeID(GenericForge.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_forge";
    private static final CardTags PRINCIPLE_TAG = FORGE;

    public GenericForge() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
