package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class FragmentKnock extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentKnock.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = KNOCK;

    public FragmentKnock() {
        super(ID, PRINCIPLE_TAG);
    }
}
