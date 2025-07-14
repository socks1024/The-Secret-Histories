package TheSecretHistories.Content.Cards.Starters.Generics;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class GenericGrail extends AbstractGenericDefend{

    public static final String ID = StringUtils.MakeID(GenericGrail.class.getSimpleName());

    private static final String IMG_NAME = "generic_a_grail";
    private static final CardTags PRINCIPLE_TAG = GRAIL;

    public GenericGrail() {
        super(ID, IMG_NAME, PRINCIPLE_TAG);
    }
}
