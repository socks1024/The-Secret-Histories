package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FragmentMoth extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentMoth.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = MOTH;

    public FragmentMoth() {
        super(ID, PRINCIPLE_TAG);
    }
}
