package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentGrail extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentGrail.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = GRAIL;

    public FragmentGrail() {
        super(ID, PRINCIPLE_TAG);
    }
}
