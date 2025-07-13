package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentLantern extends AbstractFragment {

    public static String ID = StringUtils.MakeID(FragmentLantern.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = LANTERN;

    public FragmentLantern() {
        super(ID, PRINCIPLE_TAG);
    }
}
