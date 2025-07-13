package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class FragmentSecretHistories extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentSecretHistories.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = SECRET_HISTORIES;

    public FragmentSecretHistories() {
        super(ID, PRINCIPLE_TAG);

        this.exhaust = true;
    }
}
