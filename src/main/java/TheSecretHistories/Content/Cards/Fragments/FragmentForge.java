package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class FragmentForge extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentForge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = FORGE;

    public FragmentForge() {
        super(ID, PRINCIPLE_TAG);
    }
}
