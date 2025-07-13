package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class FragmentWinter extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentWinter.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = WINTER;

    public FragmentWinter() {
        super(ID, PRINCIPLE_TAG);
    }
}
