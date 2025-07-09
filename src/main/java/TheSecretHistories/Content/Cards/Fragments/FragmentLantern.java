package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentLantern extends AbstractFragment {

    public static String ID = StringUtils.MakeID(FragmentLantern.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = LANTERN;

    public FragmentLantern() {
        super(ID, PRINCIPLE_TAG);
    }
}
