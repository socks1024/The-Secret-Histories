package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class FragmentHeart extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentHeart.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = HEART;

    public FragmentHeart() {
        super(ID, PRINCIPLE_TAG);
    }
}
