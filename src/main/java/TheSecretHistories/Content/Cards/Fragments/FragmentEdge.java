package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FragmentEdge extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentEdge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = EDGE;

    public FragmentEdge() {
        super(ID, PRINCIPLE_TAG);
    }
}
